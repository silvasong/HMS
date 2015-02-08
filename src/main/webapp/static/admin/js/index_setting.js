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
var IndexSetting = function () {
	
	 var handleImages = function() {

	        // see http://www.plupload.com/
	        var uploader = new plupload.Uploader({
	            runtimes : 'html5,flash,silverlight,html4',
	             
	            browse_button : document.getElementById('tab_images_uploader_pickfiles'), // you can pass in id...
	            container: document.getElementById('tab_images_uploader_container'), // ... or DOM Element itself
	             
	            url : rootURI+"admin/setting/index_setting_uploadImages?random="+Math.random(),
	             
	            filters : {
	                max_file_size : '10mb',
	                mime_types: [
	                    {title : "Image files", extensions : "jpg,gif,png"}
	                    
	                ]
	            },
	         
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
	                    } else {
	                        $('#uploaded_file_' + file.id + ' > .status').removeClass("label-info").addClass("label-danger").html('<i class="fa fa-warning"></i> Failed'); // set failed upload
	                        Metronic.alert({type: 'danger', message: 'One of uploads failed. Please retry.', closeInSeconds: 10, icon: 'warning'});
	                    }
	                   
	                },
	                 
	                Error: function(up, err) {
	                    Metronic.alert({type: 'danger', message: err.message, closeInSeconds: 10, icon: 'warning'});
	                }
	            }
	        });

	        uploader.init();

	    }
	 
	 var removeImage = function(){
		 //单选
	        $('#remove_bg').on('click', 'tbody tr .remove', function () {
	           var tr = $(this).parents('tr');
	           $.ajax({
	        		dataType:'json',
	        		type:'POST',
	        		url:rootURI+'admin/setting/index_setting_removeImage?random='+Math.random(),
	        		data:{value:$(this).next().val()},
	        		success: function(data,status){
	               	   if(status == "success"){					
	   					   if(data.status){
	   						handleAlerts("移除成功","success","",10);
	   						tr.remove();
	   					   }else{
	   						handleAlerts("移除失败","danger","",10);  
	   					   }
	   				   }             	 
	                },
	                error:function(XMLHttpRequest, textStatus, errorThrown){
	               	 alert(errorThrown);
	                }
	        	});
	            
	        });
	 }
	
	//提示信息处理方法（是在页面中指定位置显示提示信息的方式）
		var handleAlerts = function(msg,msgType,position,closeInSeconds) {         
	        Metronic.alert({
	            container: position, // alerts parent container(by default placed after the page breadcrumbs)
	            place: "prepent", // append or prepent in container 
	            type: msgType,  // alert's type (success, danger, warning, info)
	            message: msg,  // alert's message
	            close: true, // make alert closable
	            reset: true, // close all previouse alerts first
	            focus: false, // auto scroll to the alert after shown
	            closeInSeconds: closeInSeconds, // auto close after defined seconds, 0 never close
	            icon: "warning" // put icon before the message, use the font Awesone icon (fa-[*])
	        });        

	    };
	 
    return {
        //main function to initiate the module
        	init: function (rootPath) {
        	rootURI=rootPath;
        	handleImages();
        	removeImage();
        }

    };

}();