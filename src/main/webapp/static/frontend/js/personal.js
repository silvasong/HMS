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
var Personal = function () {
	   var oTable4;
	   var oTable5;
	   var oTable6;
	var handleTable1 = function () {
		var oTable;
		var selected = [];
	    var table=$('#table1');
		oTable = table.dataTable({
			"lengthChange":false,
        	"filter":true,
        	"sort":false,
        	"info":true,
        	"scrollX":"100%",
        	"scrollXInner":"100%",         	
        	"processing":true,                
            // set the initial value
            "displayLength": 5,
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
               { title: "订单编号",   data: "predetermineId" },
	           { title: "下单时间",  data: "presetTime"},
	           { title: "房型及数量",  data: "roomType"},
	           { title: "订单总价",  data: "price"},
	           { title: "入住信息",  data: "customerIdCard"},
	           { title: "入住时间",  data: "checkInTime"},
	           { title: "离店时间",  data: "checkOutTime"},
	           { title: "状态",   'render':function(data,status,row){
                   var tem = row.status;
   				var str = '';
   				if(tem==0){
   					str = '待确认';
   				}else if(tem==1){
   					str = '作废订单';
   				}else if(tem==2){
   					str = '待入住';
   				}else if(tem==3){
   					str = '已入住订单';
   				}else if(tem==4){
   					str = '待评价';
   				}else if(tem==5){
   					str = '已经完成';
   				}
   				return str;
   			}
            }
	         ],
	        "serverSide": true,
	        "serverMethod": "GET",
	        "ajaxSource": rootURI+"frontend/predetemine_order/order_list?rand="+Math.random(),
	        "fnServerParams": function ( aoData ) {
	           aoData.push( { "name": "istatic", "value": 0 } );
		         }
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
	            	var id = data.predetermineId;
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
            var id = data.predetermineId;
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
         
        
		$("#qx_btn1").on("click",function(event){
			if(selected.length==0){
				handleAlerts("至少选择一行.","warning","#alert");				
				return false;
			}else{
			   $('#qx_modal1').modal('show');
			}
		});
		
		$('#qx_com1').on('click', function (e) {
			$.ajax( {
             "dataType": 'json', 
             "type": "POST", 
             "url": rootURI+"frontend/predetemine_order/order_qx/"+selected.join(), 
             "success": function(data,status){
            	 if(status == "success"){					
					 if(data.status){
						 selected=[];						 
		            	 oTable.api().draw();
		            	 oTable.$('th span').removeClass();
		            	 oTable6.api().draw();
		            	 handleAlerts("取消成功. " ,"success","#alert");
					 }
					 else{
						 handleAlerts("取消失败. " ,"danger","#alert");
					 }
				}             	 
             },
             "error":function(XMLHttpRequest, textStatus, errorThrown){
            	 alert(errorThrown);
             }
           });
			$('#qx_modal1').modal('hide');
        });
		

	};
	
	var handleTable2 = function () {
		var oTable;
		var selected = [];
	    var table=$('#table2');
		oTable = table.dataTable({
			"lengthChange":false,
        	"filter":true,
        	"sort":false,
        	"info":true,
        	"scrollX":"100%",
        	"scrollXInner":"100%",         	
        	"processing":true,                
            // set the initial value
            "displayLength": 5,
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
               { title: "订单编号",   data: "predetermineId" },
	           { title: "下单时间",  data: "presetTime"},
	           { title: "房型及数量",  data: "roomType"},
	           { title: "订单总价",  data: "price"},
	           { title: "入住信息",  data: "customerIdCard"},
	           { title: "入住时间",  data: "checkInTime"},
	           { title: "离店时间",  data: "checkOutTime"},
	           { title: "状态",   'render':function(data,status,row){
                   var tem = row.status;
   				var str = '';
   				if(tem==0){
   					str = '待确认';
   				}else if(tem==1){
   					str = '作废订单';
   				}else if(tem==2){
   					str = '待入住';
   				}else if(tem==3){
   					str = '已入住订单';
   				}else if(tem==4){
   					str = '待评价';
   				}else if(tem==5){
   					str = '已经完成';
   				}
   				return str;
   			}
            }
	         ],
	        "serverSide": true,
	        "serverMethod": "GET",
	        "ajaxSource": rootURI+"frontend/predetemine_order/order_list?rand="+Math.random(),
	        "fnServerParams": function ( aoData ) {
	           aoData.push( { "name": "istatic", "value": 2 } );
		         }
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
	            	var id = data.predetermineId;
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
            var id = data.predetermineId;
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
         
        $("#qx_btn2").on("click",function(event){
			if(selected.length==0){
				handleAlerts("至少选择一行.","warning","#alert");				
				return false;
			}else{
			   $('#qx_modal2').modal('show');
			}
		});
		
		$('#qx_com2').on('click', function (e) {
			$.ajax( {
             "dataType": 'json', 
             "type": "POST", 
             "url": rootURI+"frontend/predetemine_order/order_qx/"+selected.join(), 
             "success": function(data,status){
            	 if(status == "success"){					
					 if(data.status){
						 selected=[];						 
		            	 oTable.api().draw();
		            	 oTable.$('th span').removeClass();
		            	 oTable6.api().draw();
		            	 handleAlerts("取消成功. " ,"success","#alert");
					 }
					 else{
						 handleAlerts("取消失败. " ,"danger","#alert");
					 }
				}             	 
             },
             "error":function(XMLHttpRequest, textStatus, errorThrown){
            	 alert(errorThrown);
             }
           });
			$('#qx_modal2').modal('hide');
        });
		
		
        
        
	};
	
	var handleTable3 = function () {
		var oTable;
		var selected = [];
	    var table=$('#table3');
		oTable = table.dataTable({
			"lengthChange":false,
        	"filter":true,
        	"sort":false,
        	"info":true,
        	"scrollX":"100%",
        	"scrollXInner":"100%",         	
        	"processing":true,                
            // set the initial value
            "displayLength": 5,
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
//            "columnDefs": [{                    
//                    'targets': 0,   
//                    'render':function(data,type,row){
//                    	return '<div class="checker"><span><input type="checkbox" class="checkboxes"/></span></div>';
//                    },
//                    //'defaultContent':'<div class="checker"><span><input type="checkbox" class="checkboxes" value="1"/></span></div>'                    
//                }
//            ],
            "columns": [
           
               { title: "订单编号",   data: "predetermineId" },
	           { title: "下单时间",  data: "presetTime"},
	           { title: "房型及数量",  data: "roomType"},
	           { title: "订单总价",  data: "price"},
	           { title: "入住信息",  data: "customerIdCard"},
	           { title: "入住时间",  data: "checkInTime"},
	           { title: "离店时间",  data: "checkOutTime"},
	           { title: "状态",   'render':function(data,status,row){
                   var tem = row.status;
   				var str = '';
   				if(tem==0){
   					str = '待确认';
   				}else if(tem==1){
   					str = '作废订单';
   				}else if(tem==2){
   					str = '待入住';
   				}else if(tem==3){
   					str = '已入住订单';
   				}else if(tem==4){
   					str = '待评价';
   				}else if(tem==5){
   					str = '已经完成';
   				}
   				return str;
   			}
            }
	         ],
	        "serverSide": true,
	        "serverMethod": "GET",
	        "ajaxSource": rootURI+"frontend/predetemine_order/order_list?rand="+Math.random(),
	        "fnServerParams": function ( aoData ) {
	           aoData.push( { "name": "istatic", "value": 3 } );
		         }
        });		

	
	};
	
	var handleTable4 = function () {
		
		var selected = [];
	    var table=$('#table4');
		oTable4 = table.dataTable({
			"lengthChange":false,
        	"filter":true,
        	"sort":false,
        	"info":true,
        	"scrollX":"100%",
        	"scrollXInner":"100%",         	
        	"processing":true,                
            // set the initial value
            "displayLength": 5,
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
        	'targets':6,
        	'data':null,//定义列名
        	'render':function(data,type,row){
            	return '<div class="actions"><a class="btn btn-default btn-sm" data-toggle="modal"  href="#pj_modal" id="pj">评价</a></div>';
            },
            'class':'center'
        }
            ],
            "columns": [
           
               { title: "订单编号",   data: "predetermineId" },
	           { title: "下单时间",  data: "presetTime"},
	           { title: "房型及数量",  data: "roomType"},
	           { title: "订单总价",  data: "price"},
	           { title: "入住信息",  data: "customerIdCard"},
	           { title: "入住时间",  data: "checkInTime"},
	           { title: "离店时间",  data: "checkOutTime"},{ title: "评价"},
	           { title: "状态",   'render':function(data,status,row){
                   var tem = row.status;
   				var str = '';
   				if(tem==0){
   					str = '待确认';
   				}else if(tem==1){
   					str = '作废订单';
   				}else if(tem==2){
   					str = '待入住';
   				}else if(tem==3){
   					str = '已入住订单';
   				}else if(tem==4){
   					str = '待评价';
   				}else if(tem==5){
   					str = '已经完成';
   				}
   				return str;
   			}
            }
	         ],
	        "serverSide": true,
	        "serverMethod": "GET",
	        "ajaxSource": rootURI+"frontend/predetemine_order/order_list?rand="+Math.random(),
	        "fnServerParams": function ( aoData ) {
	           aoData.push( { "name": "istatic", "value": 4 } );
		         }
        });		
        $('#table4').on('click','tbody tr',function(){
        	$('#predetermineId').val($(this).find('td:eq(0)').text());
        });
        
       

	};
	
	var handleTable5 = function () {
		
		var selected = [];
	    var table=$('#table5');
		oTable5 = table.dataTable({
			"lengthChange":false,
        	"filter":true,
        	"sort":false,
        	"info":true,
        	"scrollX":"100%",
        	"scrollXInner":"100%",         	
        	"processing":true,                
            // set the initial value
            "displayLength": 5,
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
            	'targets':7,
            	'data':null,//定义列名
            	'render':function(data,type,row){
                	return '<div class="actions"><a class="btn btn-default btn-sm" data-toggle="modal"  href="#ckpj_modal" id="ckpj">查看评价</a></div>';
                },
                'class':'center'
            }
                ],
            "columns": [
           
               { title: "订单编号",   data: "predetermineId" },
	           { title: "下单时间",  data: "presetTime"},
	           { title: "房型及数量",  data: "roomType"},
	           { title: "订单总价",  data: "price"},
	           { title: "入住信息",  data: "customerIdCard"},
	           { title: "入住时间",  data: "checkInTime"},
	           { title: "离店时间",  data: "checkOutTime"},{ title: "查看评价"},
	           { title: "状态",   'render':function(data,status,row){
                   var tem = row.status;
   				var str = '';
   				if(tem==0){
   					str = '待确认';
   				}else if(tem==1){
   					str = '作废订单';
   				}else if(tem==2){
   					str = '待入住';
   				}else if(tem==3){
   					str = '已入住订单';
   				}else if(tem==4){
   					str = '待评价';
   				}else if(tem==5){
   					str = '已经完成';
   				}
   				return str;
   			}
            }
	         ],
	        "serverSide": true,
	        "serverMethod": "GET",
	        "ajaxSource": rootURI+"frontend/predetemine_order/order_list?rand="+Math.random(),
	        "fnServerParams": function ( aoData ) {
	           aoData.push( { "name": "istatic", "value": 5 } );
		         }
        });		
        
		$('#table5').on('click','tbody tr',function(){
			//alert($(this).find('td:eq(0)').text());
			$.ajax( {
	             "dataType": 'json', 
	             "type": "GET", 
	             "url": rootURI+"frontend/predetemine_order/order_commend_reply?predetermineId="+$(this).find('td:eq(0)').text(), 
	             "success": function(data,status){
	            	 if(status == "success"){					
						 var html = '<ul><li>环境:'+data.score1+'分</li><li>舒适:'+data.score2+'分</li>'+
						            '<li>服务：'+data.score3+'分</li>'+data.CommendContend;
						 $('#ckpj_pj').empty();
						 $('#ckpj_pj').append(html);
						 $('#ckpj_rpy').empty();
						 $('#ckpj_rpy').text(data.CommendReply);
					}             	 
	             },
	             "error":function(XMLHttpRequest, textStatus, errorThrown){
	            	 alert(errorThrown);
	             }
	           });
		});
	    
        
	};
	
	var handleTable6 = function () {
		
		var selected = [];
	    var table=$('#table6');
		oTable6 = table.dataTable({
			"lengthChange":false,
        	"filter":true,
        	"sort":false,
        	"info":true,
        	"scrollX":"100%",
        	"scrollXInner":"100%",         	
        	"processing":true,                
            // set the initial value
            "displayLength": 5,
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
//            "columnDefs": [{                    
//                    'targets': 0,   
//                    'render':function(data,type,row){
//                    	return '<div class="checker"><span><input type="checkbox" class="checkboxes"/></span></div>';
//                    },
//                    //'defaultContent':'<div class="checker"><span><input type="checkbox" class="checkboxes" value="1"/></span></div>'                    
//                }
//            ],
            "columns": [
             
               { title: "订单编号",   data: "predetermineId" },
	           { title: "下单时间",  data: "presetTime"},
	           { title: "房型及数量",  data: "roomType"},
	           { title: "订单总价",  data: "price"},
	           { title: "入住信息",  data: "customerIdCard"},
	           { title: "入住时间",  data: "checkInTime"},
	           { title: "离店时间",  data: "checkOutTime"},
	           { title: "状态",   'render':function(data,status,row){
                   var tem = row.status;
   				var str = '';
   				if(tem==0){
   					str = '待确认';
   				}else if(tem==1){
   					str = '作废订单';
   				}else if(tem==2){
   					str = '待入住';
   				}else if(tem==3){
   					str = '已入住订单';
   				}else if(tem==4){
   					str = '待评价';
   				}else if(tem==5){
   					str = '已经完成';
   				}
   				return str;
   			}
            }
	         ],
	        "serverSide": true,
	        "serverMethod": "GET",
	        "ajaxSource": rootURI+"frontend/predetemine_order/order_list?rand="+Math.random(),
	        "fnServerParams": function ( aoData ) {
	           aoData.push( { "name": "istatic", "value": 1 } );
		         }
        });		
        
		

        
	};
	
	
	//处理表单验证方法
    var EditPersonalFormValidation = function() {
            var form = $('#edit_form');
            var errorDiv = $('.alert-danger', form);            
            form.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block help-block-error', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",  // validate all fields including form hidden input                
                rules: {
                	
                    name: {
                        required: true
                    },
                    email:{
                    	required: true,
                    	email:true
                    },
                    phone:{
                    	required: true
                    },
                    address:{
                    	required: true
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
                    editPersonal();                 
                }
            });
    };
	
    //修改个人资料
	var editPersonal=function(){		
		$.ajax( {
         "dataType": 'json', 
         "type":'POST', 
         "url": rootURI+"frontend/personal_center/edit_personal?random="+Math.random(), 
         "data": $('#edit_form').serialize(),
         "success": function(resp,status){
        	 if(status == "success"){  
        		 if(resp.status){						 
	            	
	            	 handleAlerts("编辑成功.","success","#alert");		            	 
				 }
				 else{
					 handleAlerts("编辑失败","danger","#alert");						 
				 }
			}             	 
         },
         "error":function(XMLHttpRequest, textStatus, errorThrown){
        	 alert(errorThrown);
         }
       });	
		
    };
	 
  //处理表单验证方法
    var EditPasswordFormValidation = function() {
            var form = $('#edit_password_form');
            var errorDiv = $('.alert-danger', form);            
            form.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block help-block-error', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",  // validate all fields including form hidden input                
                rules: {
                	password:{
                    	required: true,
                    	minlength:6
                    },
                    newpassword:{
                    	required: true,
                    	minlength:6
                    },
                    confirm_password:{
                    	required: true,
                    	minlength:6,
                    	equalTo:"#new_password"
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
                    editPassword();                 
                }
            });
    };
	
    //修改密码
	var editPassword=function(){		
		$.ajax( {
         "dataType": 'json', 
         "type":'POST', 
         "url": rootURI+"frontend/personal_center/edit_password?random="+Math.random(), 
         "data": $('#edit_password_form').serialize(),
         "success": function(resp,status){
        	 if(status == "success"){  
        		 if(resp.status){						 
	            	
	            	 handleAlerts("修改成功.","success","#alert");		            	 
				 }
				 else{
					 handleAlerts("修改失败","danger","#alert");						 
				 }
			}             	 
         },
         "error":function(XMLHttpRequest, textStatus, errorThrown){
        	 alert(errorThrown);
         }
       });	
		
    };
    var handleSpinners = function () {
        $('#spinner1').spinner({value:5, step: 1, min: 1, max: 10});
        $('#spinner2').spinner({value:5, step: 1, min: 1, max: 10});
        $('#spinner3').spinner({value:5, step: 1, min: 1, max: 10});
    }
	 
    var pj = function(){
    	 $('#pj').on("click",function(){	
         	$.ajax( {
              "dataType": 'json', 
              "type":'POST', 
              "url": rootURI+"frontend/predetemine_order/order_commend?random="+Math.random(), 
              "data": $('#px_from').serialize(),
              "success": function(resp,status){
             	 if(status == "success"){  
             		 if(resp.status){						 
             			oTable4.api().draw();
             			oTable5.api().draw();
     	            	handleAlerts("评论成功.","success","#alert");		            	 
     				 }
     				 else{
     					 handleAlerts("评论失败.","danger","#alert");						 
     				 }
     			}             	 
              },
              "error":function(XMLHttpRequest, textStatus, errorThrown){
             	 alert(errorThrown);
              }
            });	
     		$('#pj_modal').modal('hide');
         });
    }
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
        	EditPasswordFormValidation();
        	EditPersonalFormValidation();
        	handleSpinners();
        	pj();
        	handleTable1();
        	handleTable2();
        	handleTable3();
        	handleTable4();
        	handleTable5();
        	handleTable6();
        	
        }

    };

}();