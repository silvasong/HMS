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
var OnlineOrder = function () {
	
	var handleDatePickers = function () {

        if (jQuery().datepicker) {
            $('.date-picker').datepicker({
                rtl: Metronic.isRTL(),
                orientation: "left",
                autoclose: true,
                language:"zh-CN",
                
                
            });
            //$('body').removeClass("modal-open"); // fix bug when inline picker is used in modal
        }

        /* Workaround to restrict daterange past date select: http://stackoverflow.com/questions/11933173/how-to-restrict-the-selectable-date-ranges-in-bootstrap-datepicker */
    }
	 
	var predetemine = function(){
		var day;
		var price;
		$('#predetemine').on('click','tbody tr button',function(){
			var count = 1;
			var btn = $(this).parent().parent();
			var roomTypeName = btn.find('td:eq(1)').text();
			 price = btn.find('td:eq(4)').text();
			var roomTypeId = btn.find('input').val();
			var start= $('input[name=start]').val();
			var end= $('input[name=end]').val();
			 day = DateDiff(start,end);
			$('#register_form').find('legend:eq(0)').text(roomTypeName);
			$('#time').text(start+"入住,"+end+"退房")
			$('#price').text("¥"+count*day*parseInt(price));
			
			$('input[name=roomTypeId]').val(roomTypeId);
			$('input[name=time]').val(start+'#'+end);
			$('input[name=price]').val(count*day*parseInt(price));
			$("#register_form option").removeAttr("selected");
			$("#register_form select[name='number']").children("option[value='"+1+"']").attr("selected","true");
			$('#predetemine_modal').modal('show');
		});
		
		$('#count').on('change',function(){
			$('input[name=price]').val($(this).val()*day*parseInt(price));
			$('#price').text("¥"+parseInt($(this).val())*day*parseInt(price));
		});
		
	}
    
	 function DateDiff(sDate1, sDate2){ //sDate1和sDate2是2002-12-18格式 
		 var aDate, oDate1, oDate2, iDays 
		 aDate = sDate1.split("-") 
		 oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]) //转换为12-18-2002格式 
		 aDate = sDate2.split("-") 
		 oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]) 
		 iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 /24) //把相差的毫秒数转换为天数 
		 return iDays 
	 }
	 
	//处理表单验证方法
	    var PredetemineFormValidation = function() {
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
	                    phone:{
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
	                    predetemineAjax();               
	                }
	            });
	    };
		
	    //预定
		var predetemineAjax=function(){		
			$.ajax( {
	         "dataType": 'json', 
	         "type":'POST', 
	         "url": rootURI+"frontend/predetemine_order/add_predetemine?random="+Math.random(), 
	         "data": $('#register_form').serialize(),
	         "success": function(resp,status){
	        	 if(status == "success"){  
	        		 if(resp.status){						 
		            	
		                 handleAlerts("预定成功.","success","#alert");		            	 
					 }
					 else{
						 handleAlerts("预定失败","danger","#alert");						 
					 }
				}             	 
	         },
	         "error":function(XMLHttpRequest, textStatus, errorThrown){
	        	 alert(errorThrown);
	         }
	       });	
			$('#predetemine_modal').modal('hide');
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
        	predetemine();
        	PredetemineFormValidation();
        }

    };

}();