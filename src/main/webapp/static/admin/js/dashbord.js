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
var Dashbord = function () {
   var chart1_data = [];
   var chart2_data = [];
   var chart3_data = [];
   var handleData = function(){
	   $.ajax({
		   dataType:"json",
		   type:"get",
		   url:rootURI+"admin/dashbord/chartData?random="+Math.random(),
		   success:function(data,status){
			   if(status="success"){
				   chart1_data = data.data1;
				   chart2_data = data.data2;
				   chart3_data = data.data3;
				   handleChart();
			   }
		   }
		   ,
           error:function(XMLHttpRequest, textStatus, errorThrown){
          	 alert(errorThrown);
           }
		   
	   });
	  
	  
   }
   var handleChart = function(){
	   var chart1 = AmCharts.makeChart("chart_1", {
           "type": "pie",
           "theme": "light",

           "fontFamily": 'Open Sans',
           
           "color":    '#888',

           "dataProvider": chart1_data,
           "valueField": "count",
           "titleField": "score",
           "exportConfig": {
               menuItems: [{
                   icon: Metronic.getGlobalPluginsPath() + "amcharts/amcharts/images/export.png",
                   format: 'png'
               }]
           }
       });

       $('#chart_1').closest('.portlet').find('.fullscreen').click(function() {
           chart1.invalidateSize();
       });
       
       var chart2 = AmCharts.makeChart("chart_2", {
           "type": "pie",
           "theme": "light",

           "fontFamily": 'Open Sans',
           
           "color":    '#888',

           "dataProvider":chart2_data,
           "valueField": "count",
           "titleField": "score",
           "exportConfig": {
               menuItems: [{
                   icon: Metronic.getGlobalPluginsPath() + "amcharts/amcharts/images/export.png",
                   format: 'png'
               }]
           }
       });

       $('#chart_2').closest('.portlet').find('.fullscreen').click(function() {
           chart2.invalidateSize();
       });
       
       var chart3 = AmCharts.makeChart("chart_3", {
           "type": "pie",
           "theme": "light",

           "fontFamily": 'Open Sans',
           
           "color":    '#888',

           "dataProvider":chart3_data,
           "valueField": "count",
           "titleField": "score",
           "exportConfig": {
               menuItems: [{
                   icon: Metronic.getGlobalPluginsPath() + "amcharts/amcharts/images/export.png",
                   format: 'png'
               }]
           }
       });

       $('#chart_3').closest('.portlet').find('.fullscreen').click(function() {
           chart3.invalidateSize();
       });
   }
	
   return {
        //main function to initiate the module
        init: function (rootPath) {
        	rootURI=rootPath;
        	handleData();
        	
        	
        }

    };

}();