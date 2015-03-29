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
var SignUp = function () {
	
	//处理表单验证方法
    var SingUpFormValidation = function() {
            var form = $('#register_form');
            var errorDiv = $('.alert-danger', form);            
            form.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block help-block-error', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",  // validate all fields including form hidden input                
                rules: {
                	idCard: {
                        required: true,
                        rangelength:[15,18]
                    },
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
                    },
                    password:{
                    	required: true,
                    	minlength:6
                    },
                    confirm_password:{
                    	required: true,
                    	minlength:6,
                    	equalTo:"#pass"
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
                    register();                 
                }
            });
    };
	
    //注册
	var register=function(){		
		$.ajax( {
         "dataType": 'json', 
         "type":'POST', 
         "url": rootURI+"frontend/customer/register?random="+Math.random(), 
         "data": $('#register_form').serialize(),
         "success": function(resp,status){
        	 if(status == "success"){  
        		 if(resp.status){						 
	            	alert("注册成功");
	            	window.location.href=rootURI+"frontend/login"; 
	            	// handleAlerts("注册成功.","success","#alert");		            	 
				 }
				 else{
					 handleAlerts(resp.info,"danger","#alert");						 
				 }
			}             	 
         },
         "error":function(XMLHttpRequest, textStatus, errorThrown){
        	 alert(errorThrown);
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
        	SingUpFormValidation();
        	
        }

    };

}();