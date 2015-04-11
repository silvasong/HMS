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
var PredetemineOrder = function () {
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
	        "ajaxSource": rootURI+"admin/predetemine/predetemineOrder/list?rand="+Math.random(),
	        "fnServerParams": function ( aoData ) {
	           aoData.push( { "name": "istatic", "value": 0 } );
		         }
        });	
        
	    $('input[name=status]').on('change',function(){
	    	$('#qr_btn').addClass('hide');
	    	$('#qx_btn').addClass('hide');
	    	if(parseInt($(this).val())==0){
	    		$('#qr_btn').removeClass('hide');
		    	$('#qx_btn').removeClass('hide');
	    	}
	    	var jsonData=$("#searchForm").serializeJson();
			var jsonDataStr=JSON.stringify(jsonData);			
			oTable.fnFilter(jsonDataStr);
			return false;
	    });
	    
	    $("#qx_btn").on("click",function(event){
			if(selected.length==0){
				handleAlerts("至少选择一行.","warning","#alert");				
				return false;
			}else{
			   $('#qx_modal').modal('show');
			}
		});
		
		$('#qx_com').on('click', function (e) {
			$.ajax( {
             "dataType": 'json', 
             "type": "POST", 
             "url": rootURI+"admin/predetemine/predetemineOrder/manager/"+selected.join()+"/?flag=1", 
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
			$('#qx_modal').modal('hide');
        });
		
		$("#qr_btn").on("click",function(event){
			if(selected.length==0){
				handleAlerts("至少选择一行.","warning","#alert");				
				return false;
			}else{
			   $('#qr_modal').modal('show');
			}
		});
		
		$('#qr_com').on('click', function (e) {
			$.ajax( {
             "dataType": 'json', 
             "type": "POST", 
             "url": rootURI+"admin/predetemine/predetemineOrder/manager/"+selected.join()+"/?flag=1", 
             "success": function(data,status){
            	 if(status == "success"){					
					 if(data.status){
						 selected=[];						 
		            	 oTable.api().draw();
		            	 oTable.$('th span').removeClass();
		            	 oTable6.api().draw();
		            	 handleAlerts("确认成功. " ,"success","#alert");
					 }
					 else{
						 handleAlerts("确认失败. " ,"danger","#alert");
					 }
				}             	 
             },
             "error":function(XMLHttpRequest, textStatus, errorThrown){
            	 alert(errorThrown);
             }
           });
			$('#qr_modal').modal('hide');
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
             "url": rootURI+"admin/room/room/room_delete/"+selected.join(), 
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
		
		
		/* handle show/hide columns*/
        var tableColumnToggler = $('#column_toggler');		
		$('input[type="checkbox"]', tableColumnToggler).change(function () {
		    /* Get the DataTables object again - this is not a recreation, just a get of the object */
		    var iCol = parseInt($(this).attr("data-column"));
		    var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
		    oTable.fnSetColumnVis(iCol, (bVis ? false : true));
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
        	
        }

    };

}();