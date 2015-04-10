//jquery插件把表单序列化成json格式的数据start 
(function($) {
	$.fn.serializeJson = function() {
		var serializeObj = {};
		var array = this.serializeArray();
		var str = this.serialize();
		$(array).each(
				function() {
					if (serializeObj[this.name]) {
						if ($.isArray(serializeObj[this.name])) {
							serializeObj[this.name].push(this.value);
						} else {
							serializeObj[this.name] = [
									serializeObj[this.name], this.value ];
						}
					} else {
						serializeObj[this.name] = this.value;
					}
				});
		return serializeObj;
	};
})(jQuery);

var rootURI = "/";
var PredetemineOrderComment = function() {
	var oTable;
	var selected = [];
	var uploader;
	var handleTable = function() {
		var table = $('#table');
		oTable = table
				.dataTable({
					"lengthChange" : false,
					"filter" : true,
					"sort" : false,
					"info" : true,
					"scrollX" : "100%",
					"scrollXInner" : "100%",
					"processing" : true,
					// set the initial value
					"displayLength" : 10,
					"dom" : "t<'row'<'col-md-6'i><'col-md-6'p>>",
					// "sPaginationType": "bootstrap_full_number",
					// //bootstrap_extended
					// "oLanguage": {
					// "sLengthMenu": "_MENU_ records per page",
					// "oPaginate": {
					// "sPrevious": "Prev",
					// "sNext": "Next",
					// "zeroRecords": "No records to display"
					// }
					// },
					"columnDefs" : [ {
						'targets' : 0,
						'render' : function(data, type, row) {
							return '<div class="checker"><span><input type="checkbox" class="checkboxes"/></span></div>';
						},
					// 'defaultContent':'<div class="checker"><span><input
					// type="checkbox" class="checkboxes"
					// value="1"/></span></div>'
					} ],
					"columns" : [ {
						"orderable" : false
					}, {
						title : "评价编号",
						data : "commendId"
					}, {
						title : "订单编号",
						data : "predetermineId"
					}, {
						title : "评价内容",
						data : "commendContend"
					}, {
						title : "环境",
						data : "score1"
					}, {
						title : "舒适",
						data : "score2"
					}, {
						title : "服务",
						data : "score3"
					}, {
						title : "管理员回复",
						data : "replyContent"
					}, {
						title : "管理员",
						data : "adminName"
					},

					],
					"serverSide" : true,
					"serverMethod" : "GET",
					"ajaxSource" : rootURI
							+ "admin/predetemine/predetemineOrderCommend/list?rand="
							+ Math.random(),
					"fnServerParams" : function(aoData) {
						aoData.push({
							"name" : "istatic",
							"value" : 0
						});
					}
				});
		
		$("#hf_btn").on("click",function(event){
			if(selected.length!=1){
				handleAlerts("请选择一行.","warning","#alert");				
				return false;
			}else{
			  $('textarea[name=content]').val("");
			   $('#hf_modal').modal('show');
			}
		});
		
		$('#hf').on('click', function (e) {
			$.ajax( {
             "dataType": 'json', 
             "type": "POST", 
             "data":$('#hf_from').serialize(),
             "url": rootURI+"admin/predetemine/predetemineOrderCommend/adminReply/"+selected.join(), 
             "success": function(data,status){
            	 if(status == "success"){					
					 if(data.status){
						 selected=[];						 
		            	 oTable.api().draw();
		            	 handleAlerts("回复成功. " ,"success","#alert");
					 }
					 else{
						 handleAlerts("回复失败. " ,"danger","#alert");
					 }
				}             	 
             },
             "error":function(XMLHttpRequest, textStatus, errorThrown){
            	 alert(errorThrown);
             }
           });
			$('#hf_modal').modal('hide');
        });

		// 全选
		$(".group-checkable").on('change', function() {
			var set = jQuery(this).attr("data-set");
			var checked = jQuery(this).is(":checked");
			selected = [];
			if (checked) {
				var api = oTable.api();
				jQuery(set).each(function() {
					var data = api.row($(this).parents('tr')).data();
					var id = data.commendId;
					var index = $.inArray(id, selected);
					selected.push(id);
					$(this).attr("checked", true);
					$(this).parents('tr').addClass("active");
					$(this).parents('span').addClass("checked");
				});
			} else {
				jQuery(set).removeAttr("checked");
				jQuery(set).parents('tr').removeClass("active");
				jQuery(set).parents('span').removeClass("checked");
			}
			jQuery.uniform.update(set);
		});

		// 单选
		table.on('change', 'tbody tr .checkboxes', function() {
			$(this).parents('tr').toggleClass("active");
			var data = oTable.api().row($(this).parents('tr')).data();
			var id = data.commendId;
			var index = $.inArray(id, selected);
			if (index === -1) {
				selected.push(id);
				$(this).parents('span').addClass("checked");
				$(this).attr("checked", "checked");
			} else {
				selected.splice(index, 1);
				$(this).parents('span').removeClass("checked");
				$(this).removeAttr("checked");
			}
		});

		/* handle show/hide columns */
		var tableColumnToggler = $('#column_toggler');
		$('input[type="checkbox"]', tableColumnToggler).change(function() {
			/*
			 * Get the DataTables object again - this is not a recreation, just
			 * a get of the object
			 */
			var iCol = parseInt($(this).attr("data-column"));
			var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
			oTable.fnSetColumnVis(iCol, (bVis ? false : true));
		});

	};

	// 提示信息处理方法（是在页面中指定位置显示提示信息的方式）
	var handleAlerts = function(msg, msgType, position) {
		Metronic.alert({
			container : position, // alerts parent container(by default placed
									// after the page breadcrumbs)
			place : "prepent", // append or prepent in container
			type : msgType, // alert's type (success, danger, warning, info)
			message : msg, // alert's message
			close : true, // make alert closable
			reset : true, // close all previouse alerts first
			focus : false, // auto scroll to the alert after shown
			closeInSeconds : 10, // auto close after defined seconds, 0 never
									// close
			icon : "warning" // put icon before the message, use the font
								// Awesone icon (fa-[*])
		});

	};
	return {
		// main function to initiate the module
		init : function(rootPath) {
			rootURI = rootPath;
			handleTable();

		}

	};

}();