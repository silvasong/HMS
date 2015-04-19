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
var NewsType = function () {
	
	var handlePage = function(){
		
		$("#page").page({
	        showInfo: true,
	        showJump: true,
	        showPageSizes: true,
	        remote: {
	        	params:{"type":parseInt($('input[name=type]').val())},
	            url: rootURI+'frontend/news/news_type_list',
	            callback: function (data) {
	            	var html = '';
	            	$.each(data.data,function(i,value){
	            		html += '<div class="row"><div class="col-md-12 blog-article">'+
            	        '<h3><a href="news_item?id='+value.newId+'"> '+value.newTitle+'</a></h3>'+
            	        '<span>'+value.newTime+' </span>&nbsp;&nbsp;<span>By '+value.newAuthor+' </span>'+
            	        '<hr></div></div>';
	            	});
	            	$('#page_data').empty();
	            	$('#page_data').append(html);
            }
	        }
	     })/*.on("pageClicked", function (event, data) {
	         $("#eventLog").append('EventName = pageClicked , data = ' + data + '<br />');
	     }).on('jumpClicked', function (event, data) {
	         $("#eventLog").append('EventName = jumpClicked , data = ' + data + '<br />');
	     }).on('pageSizeChanged', function (event, data) {
	         $("#eventLog").append('EventName = pageSizeChanged , data = ' + data + '<br />');
	     })*/;
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
        	handlePage();
        }

    };

}();