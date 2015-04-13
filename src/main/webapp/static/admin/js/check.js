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
var Check = function () {
	
	var handleDatePickers = function () {

        if (jQuery().datepicker) {
            $('.date-picker').datepicker({
                rtl: Metronic.isRTL(),
                orientation: "left",
                autoclose: true,
                language:"zh-CN"
            });
            //$('body').removeClass("modal-open"); // fix bug when inline picker is used in modal
        }

        /* Workaround to restrict daterange past date select: http://stackoverflow.com/questions/11933173/how-to-restrict-the-selectable-date-ranges-in-bootstrap-datepicker */
    }
	
	var handlePredetemine = function(){
		$('input[name=ordertpye]').on('change',function(){
			$('#predetemine').removeClass("hide");
			if(parseInt($(this).val())==0){
				$('#predetemine').addClass("hide");
			}
			
		});
		
		$('select[name=roomType]').on('change',function(){
			$('select[name=roomId]').empty();
			var roomIds = [];
			
			if(parseInt($(this).val())!=-1){
				$.ajax( {
			         "dataType": 'json', 
			         "type":'POST', 
			         "url": rootURI+"admin/checkmanagement/check/getRoom?random="+Math.random(), 
			         "data": {"roomType":parseInt($(this).val())},
			         "success": function(resp,status){
			        	 if(status == "success"){  
			        		 if(resp.status){						 
			        			 roomIds = resp.roomId;
			        			 var html = '<option value="-1">选择房号</option>';
			        			 $.each(roomIds, function(i,val){      
			        			      html += '<option value="'+val+'">'+val+'</option>'
			        			  });
			        			 $('select[name=roomId]').append(html);
							 }
							 
						}             	 
			         },
			         "error":function(XMLHttpRequest, textStatus, errorThrown){
			        	 alert(errorThrown);
			         }
			       });	
			}else{
				 $('select[name=roomId]').append('<option value="-1">选择房号</option>');
			}
			
			
		});
		
	}
	//办理入住
	var checkOrder=function(){		
		$.ajax( {
         "dataType": 'json', 
         "type":'POST', 
         "url": rootURI+"admin/checkmanagement/check/checkIn?random="+Math.random(), 
         "data": $('#check_form').serialize(),
         "success": function(resp,status){
        	 if(status == "success"){  
        		 if(resp.status){						 
	            	 alert("办理成功");
	            	 window.location.href=rootURI+"admin/checkmanagement/check";
				 }
				 else{
					 handleAlerts("办理失败.","danger","#alert");						 
				 }
			}             	 
         },
         "error":function(XMLHttpRequest, textStatus, errorThrown){
        	 alert(errorThrown);
         }
       });	
		
    };
   
    //处理表单验证方法
    var formValidation = function() {
            var form = $('#check_form');
            var errorDiv = $('.alert-danger', form);            
            form.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block help-block-error', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",  // validate all fields including form hidden input                
                rules: {
                	customerName1: {
                        required: true
                     },
                     customerIdcard1: {
                         required: true
                      }, 
                      
                        cost: {
                            required: true,
                            digits:true
                         }, 
                         margin: {
                             required: true,
                             digits:true
                          }, 
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
                    checkOrder();                  
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
        	handleDatePickers();
        	handlePredetemine();
        	formValidation();
        }

    };

}();