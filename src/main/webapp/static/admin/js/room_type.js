//jquery插件把表单序列化成json格式的数据start 
(function($){
    $.fn.serializeJson=function(){
        var serializeObj={};
        var array=this.serializeArray();
        var str=this.serialize();
        $(array).each(function(){
            if(serializeObj[this.name]){
                if($.isArray(serializeObj[this.name])){
                    serializeObj[this.name].push(this.value);
                }else{
                    serializeObj[this.name]=[serializeObj[this.name],this.value];
                }
            }else{
                serializeObj[this.name]=this.value;
            }
        });
        return serializeObj;
    };
})(jQuery);

var rootURI="/";
var RoomType = function () {
	var oTable;
	var selected = [];
	var uploader;
	var handleTable = function () {
	    var table=$('#table');
		oTable = table.dataTable({
			"lengthChange":false,
        	"filter":true,
        	"sort":false,
        	"info":true,
        	"scrollX":"100%",
        	"scrollXInner":"100%",         	
        	"processing":true,                
            // set the initial value
            "displayLength": 10,
            "dom": "t<'row'<'col-md-6'i><'col-md-6'p>>",
//            "sPaginationType": "bootstrap_full_number",   //bootstrap_extended
//            "oLanguage": {
//                "sLengthMenu": "_MENU_ records per page",
//                "oPaginate": {
//                    "sPrevious": "Prev",
//                    "sNext": "Next",
//                	"zeroRecords": "No records to display"
//                }
//            },
            "columnDefs": [{                    
                    'targets': 0,   
                    'render':function(data,type,row){
                    	return '<div class="checker"><span><input type="checkbox" class="checkboxes"/></span></div>';
                    },
                    //'defaultContent':'<div class="checker"><span><input type="checkbox" class="checkboxes" value="1"/></span></div>'                    
                }
            ],
            "columns": [
               {"orderable": false },
	           { title: "ID",   data: "id" },
	           { title: "类型",   data: "type" },
	           { title: "原价",  data: "price"},
	           { title: "现价", data: "discountPrice" },
	           { title: "床位数", data: "bedNumber" },
	         ],
	        "serverSide": true,
	        "serverMethod": "GET",
	        "ajaxSource": rootURI+"admin/room/room_type/room_type_list?rand="+Math.random()

		});		

	    //全选
        $(".group-checkable").on('change',function () {
            var set = jQuery(this).attr("data-set");
            var checked = jQuery(this).is(":checked");
            selected=[];
            if(checked){            	
	            var api=oTable.api();            
	            jQuery(set).each(function () {            	
	            	var data = api.row($(this).parents('tr')).data();
	            	var id = data.nodeId;
	                var index = $.inArray(id, selected);
	                selected.push( id );
                    $(this).attr("checked", true);
                    $(this).parents('tr').addClass("active");
                    $(this).parents('span').addClass("checked");
	            });
            }
            else{
            	jQuery(set).removeAttr("checked");
            	jQuery(set).parents('tr').removeClass("active");
            	jQuery(set).parents('span').removeClass("checked");
            }
            jQuery.uniform.update(set);
        });
        
        //单选
        table.on('change', 'tbody tr .checkboxes', function () {
            $(this).parents('tr').toggleClass("active");            
            var data = oTable.api().row($(this).parents('tr')).data();
            var id = data.id;
            var index = $.inArray(id, selected);     
            if ( index === -1 ) {
                selected.push( id );
                $(this).parents('span').addClass("checked");
                $(this).attr("checked","checked");
            } else {
                selected.splice( index, 1 );
                $(this).parents('span').removeClass("checked");
                $(this).removeAttr("checked");
            }
        });
         
       //打开删除对话框前判断是否已选择要删除的行
		$("#delete_btn").on("click",function(event){
			if(selected.length==0){
				handleAlerts("至少选择一行.","warning","");				
				return false;
			}else{
			   $('#delete_modal').modal('show');
			}
		});
		//删除操作
		$('#delete_com').on('click', function (e) {
			$.ajax( {
             "dataType": 'json', 
             "type": "DELETE", 
             "url": rootURI+"admin/room/room_type/room_type_delete/"+selected.join(), 
             "success": function(data,status){
            	 if(status == "success"){					
					 if(data.status){
						 selected=[];						 
		            	 oTable.api().draw();
		            	 oTable.$('th span').removeClass();
		            	 handleAlerts("删除成功. " ,"success","");
					 }
					 else{
						 handleAlerts("删除失败. " ,"danger","");
					 }
				}             	 
             },
             "error":function(XMLHttpRequest, textStatus, errorThrown){
            	 alert(errorThrown);
             }
           });
			$('#delete_modal').modal('hide');
        });
		
		$("#edit_btn").on("click",function(event){
			if(selected.length != 1){
				handleAlerts("请选择一行.","warning","");				
				return false;
			}else{
				var data = oTable.api().row($("tr input:checked").parents('tr')).data();
				var id = data.id;
				var type = data.type;
	            var price = data.price;
	            var discountPrice  = data.discountPrice;
	            var bedNumber  = data.bedNumber;
	            $("#edit_from option").removeAttr("selected");
	            $("#edit_from input[name='id']").val(id);
	            $("#edit_from input[name='type']").val(type);
	            $("#edit_from input[name='price']").val(price);
	            $("#edit_from input[name='discountPrice']").val(discountPrice);
	            $("#edit_from select[name='bedNumber']").children("option[value='"+bedNumber+"']").attr("selected","true");
	            
			   $('#edit_modal').show();
			}
		});
		
		$("#bind_image").on("click",function(event){
			uploader.settings.multipart_params.id = selected.join();
			if(selected.length != 1){
				handleAlerts("请选择一行.","warning","");				
				return false;
			}else{
				
				$('#tab_images_uploader_filelist').empty();
				var data = oTable.api().row($("tr input:checked").parents('tr')).data();
				var id = data.id;
				
				var roomTypeImages = data.roomTypeImages;
				var html = '<thead><tr role="row" class="heading"><th width="60%">Image</th><th width="40%">操作</th></tr></thead><tbody>';
											
				$.each(roomTypeImages,function(n,value){
					html += '<tr><td>'+
						    '<img class="img-responsive" src="../../upload/admin/room_type_image/'+value.image_url+'" alt="" style="height: 100px;width: 100px;" >'+
					        '</td><td><a href="javascript:;" class="btn default btn-sm remove"><i class="fa fa-times"></i> Remove </a> <input class="hide" value="'+value.id+'"/></td>'+
				            '</tr>';
				
				});
				   html +='</tbody>';
				   $('#image_table').empty();
				   $('#image_table').append(html);
	              
	               $('#bind_modal').modal('show');
	               removeImage();
			}
		});
		
		var removeImage = function(){
			 //单选
		        $('#image_table').on('click', 'tbody tr .remove', function () {
		          
		           var tr = $(this).parents('tr');
		           $.ajax({
		        		dataType:'json',
		        		type:'POST',
		        		url:rootURI+"admin/room/room_type/delete_bind_image?random="+Math.random(),
		        		data:{id:$(this).next().val()},
		        		success: function(data,status){
		               	   if(status == "success"){					
		   					   if(data.status){
		   						oTable.api().draw();
		   						selected = [];
		   						tr.remove();
		   					   }else{
		   						  
		   					   }
		   				   }             	 
		                },
		                error:function(XMLHttpRequest, textStatus, errorThrown){
		               	 alert(errorThrown);
		                }
		        	});
		        });
		 }
		
		/* handle show/hide columns*/
        var tableColumnToggler = $('#column_toggler');		
		$('input[type="checkbox"]', tableColumnToggler).change(function () {
		    /* Get the DataTables object again - this is not a recreation, just a get of the object */
		    var iCol = parseInt($(this).attr("data-column"));
		    var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
		    oTable.fnSetColumnVis(iCol, (bVis ? false : true));
		});
        
        
	};
	
	var handleImages = function() {

        // see http://www.plupload.com/
         uploader = new plupload.Uploader({
            runtimes : 'html5,flash,silverlight,html4',
             
            browse_button : document.getElementById('tab_images_uploader_pickfiles'), // you can pass in id...
            container: document.getElementById('tab_images_uploader_container'), // ... or DOM Element itself
             
            url : rootURI+"admin/room/room_type/room_type_uploadImages?random="+Math.random(),
             
            filters : {
                max_file_size : '10mb',
                mime_types: [
                    {title : "Image files", extensions : "jpg,gif,png"}
                    
                ]
            },
            multipart_params: {'id':selected.join()},
            // Flash settings
            flash_swf_url : '../../../assets/global/plugins/plupload/js/Moxie.swf',
     
            // Silverlight settings
            silverlight_xap_url : '../../../assets/global/plugins/plupload/js/Moxie.xap',             
         
            init: {
                PostInit: function() {
                    $('#tab_images_uploader_filelist').html("");
         
                    $('#tab_images_uploader_uploadfiles').click(function() {
                        uploader.start();
                        return false;
                    });

                    $('#tab_images_uploader_filelist').on('click', '.added-files .remove', function(){
                        uploader.removeFile($(this).parent('.added-files').attr("id"));    
                        $(this).parent('.added-files').remove();                     
                    });
                },
         
                FilesAdded: function(up, files) {
                    plupload.each(files, function(file) {
                        $('#tab_images_uploader_filelist').append('<div class="alert alert-warning added-files" id="uploaded_file_' + file.id + '">' + file.name + '(' + plupload.formatSize(file.size) + ') <span class="status label label-info"></span>&nbsp;<a href="javascript:;" style="margin-top:-5px" class="remove pull-right btn btn-sm red"><i class="fa fa-times"></i> remove</a></div>');
                    });
                },
         
                UploadProgress: function(up, file) {
                    $('#uploaded_file_' + file.id + ' > .status').html(file.percent + '%');
                },

                FileUploaded: function(up, file, response) {
                    var response = $.parseJSON(response.response);

                    if (response.result && response.result == 'OK') {
                        var id = response.id; // uploaded file's unique name. Here you can collect uploaded file names and submit an jax request to your server side script to process the uploaded files and update the images tabke
                        
                        $('#uploaded_file_' + file.id + ' > .status').removeClass("label-info").addClass("label-success").html('<i class="fa fa-check"></i> Done'); // set successfull upload
                        oTable.api().draw();
                        selected=[];
                    } else {
                        $('#uploaded_file_' + file.id + ' > .status').removeClass("label-info").addClass("label-danger").html('<i class="fa fa-warning"></i> Failed'); // set failed upload
                        Metronic.alert({type: 'danger', message: 'One of uploads failed. Please retry.', closeInSeconds: 10, icon: 'warning','container':'#info'});
                    }
                   
                },
                Error: function(up, err) {
                    Metronic.alert({type: 'danger', message: err.message, closeInSeconds: 10, icon: 'warning','container':'#info'});
                }
            }
        });

        uploader.init();

    }
	
	//添加操作
	var addRoomType=function(){		
		$.ajax( {
         "dataType": 'json', 
         "type":'POST', 
         "url": rootURI+"admin/room/room_type/room_type_add?random="+Math.random(), 
         "data": $('#add_from').serialize(),
         "success": function(resp,status){
        	 if(status == "success"){  
        		 if(resp.status){						 
	            	 oTable.api().draw();
	            	 handleAlerts("Added the data successfully.","success","");		            	 
				 }
				 else{
					 handleAlerts("Failed to add the data.","danger","");						 
				 }
			}             	 
         },
         "error":function(XMLHttpRequest, textStatus, errorThrown){
        	 alert(errorThrown);
         }
       });	
		$('#add_modal').hide();
    };
   
  //处理表单验证方法
    var addFormValidation = function() {
            var form = $('#add_from');
            var errorDiv = $('.alert-danger', form);            
            form.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block help-block-error', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",  // validate all fields including form hidden input                
                rules: {
                    type:{
                        
                        required: true
                    },
                    price: {
                        required: true,
                        digits:true
                    },
                    discountPrice: {
                        required: true,
                        digits:true
                    }                  
                },

                invalidHandler: function (event, validator) { //display error alert on form submit                	
                    errorDiv.show();                    
                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.form-group').addClass('has-error'); // set error class to the control group
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    $(element)
                        .closest('.form-group').removeClass('has-error'); // set error class to the control group
                },
                onfocusout: function (element) { // hightlight error inputs
                    $(element).valid();
                },
                success: function (label) {
                    label
                        .closest('.form-group').removeClass('has-error'); // set success class to the control group
                },

                submitHandler: function (form) {                	
                    errorDiv.hide();
                    addRoomType();                  
                }
            });
    };
  //添加操作
	var editRoomType=function(){		
		$.ajax( {
         "dataType": 'json', 
         "type":'POST', 
         "url": rootURI+"admin/room/room_type/room_type_edit?random="+Math.random(), 
         "data": $('#edit_from').serialize(),
         "success": function(resp,status){
        	 if(status == "success"){  
        		 if(resp.status){						 
	            	 oTable.api().draw();
	            	 handleAlerts("编辑成功.","success","");		            	 
				 }
				 else{
					 handleAlerts("编辑失败.","danger","");						 
				 }
			}             	 
         },
         "error":function(XMLHttpRequest, textStatus, errorThrown){
        	 alert(errorThrown);
         }
       });	
		$('#edit_modal').hide();
    };
   
  //处理表单验证方法
    var editFormValidation = function() {
            var form = $('#edit_from');
            var errorDiv = $('.alert-danger', form);            
            form.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block help-block-error', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",  // validate all fields including form hidden input                
                rules: {
                    type:{
                        
                        required: true
                    },
                    price: {
                        required: true,
                        digits:true
                    },
                    discountPrice: {
                        required: true,
                        digits:true
                    }                  
                },

                invalidHandler: function (event, validator) { //display error alert on form submit                	
                    errorDiv.show();                    
                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.form-group').addClass('has-error'); // set error class to the control group
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    $(element)
                        .closest('.form-group').removeClass('has-error'); // set error class to the control group
                },
                onfocusout: function (element) { // hightlight error inputs
                    $(element).valid();
                },
                success: function (label) {
                    label
                        .closest('.form-group').removeClass('has-error'); // set success class to the control group
                },

                submitHandler: function (form) {                	
                    errorDiv.hide();
                    editRoomType();                  
                }
            });
    };
    
    
	//提示信息处理方法（是在页面中指定位置显示提示信息的方式）
	var handleAlerts = function(msg,msgType,position) {         
        Metronic.alert({
            container: position, // alerts parent container(by default placed after the page breadcrumbs)
            place: "prepent", // append or prepent in container 
            type: msgType,  // alert's type (success, danger, warning, info)
            message: msg,  // alert's message
            close: true, // make alert closable
            reset: true, // close all previouse alerts first
            focus: false, // auto scroll to the alert after shown
            closeInSeconds: 10, // auto close after defined seconds, 0 never close
            icon: "warning" // put icon before the message, use the font Awesone icon (fa-[*])
        });        

    };
   return {
        //main function to initiate the module
        init: function (rootPath) {
        	rootURI=rootPath;
        	handleTable();
        	addFormValidation();
        	editFormValidation();
        	handleImages();
        	
        }

    };

}();