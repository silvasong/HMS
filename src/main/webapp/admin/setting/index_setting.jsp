<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>HMS | 首页设置</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link
	href="../../assets/global/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="../../assets/global/plugins/simple-line-icons/simple-line-icons.min.css"
	rel="stylesheet" type="text/css">
<link href="../../assets/global/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="../../assets/global/plugins/uniform/css/uniform.default.css"
	rel="stylesheet" type="text/css">
<!-- END GLOBAL MANDATORY STYLES -->
<link rel="stylesheet" type="text/css"
	href="../../assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.css" />
<link rel="stylesheet" type="text/css"
	href="../../assets/global/plugins/select2/select2.css" />
<link rel="stylesheet" type="text/css"
	href="../../assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css" />
<link rel="stylesheet" type="text/css" href="../../assets/global/plugins/bootstrap-editable/bootstrap-editable/css/bootstrap-editable.css"/>
<!-- BEGIN THEME STYLES -->
<link href="../../assets/global/css/components-rounded.css"
	id="style_components" rel="stylesheet" type="text/css">
<link href="../../assets/global/css/plugins.css" rel="stylesheet"
	type="text/css">
<link href="../../assets/admin/layout/css/layout.css" rel="stylesheet"
	type="text/css">
<link href="../../assets/admin/layout/css/themes/default.css"
	rel="stylesheet" type="text/css" id="style_color">
<link href="../../assets/admin/layout/css/custom.css" rel="stylesheet"
	type="text/css">
<!-- END THEME STYLES -->
<!-- <link rel="shortcut icon" href="favicon.ico"/> -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-menu-fixed" class to set the mega menu fixed  -->
<!-- DOC: Apply "page-header-top-fixed" class to set the top menu fixed  -->
<body>
	<!-- BEGIN HEADER -->
	<c:import url="/admin/common/head" />
	<!-- END HEADER -->
	<!-- BEGIN PAGE CONTAINER -->
	<div class="page-container">
		<!-- BEGIN PAGE HEAD -->
		<div class="page-head">
			<div class="container">
				<!-- BEGIN PAGE TITLE -->
				<div class="page-title">
					<h1>
						系统设置 <small>首页设置</small>
					</h1>
				</div>
				<!-- END PAGE TITLE -->
				<!-- BEGIN PAGE TOOLBAR -->

				<!-- END PAGE TOOLBAR -->
			</div>
		</div>
		<!-- END PAGE HEAD -->
		<!-- BEGIN PAGE CONTENT -->
		<div class="page-content">
			<div class="container">
				<!-- BEGIN PAGE BREADCRUMB -->
				<ul class="page-breadcrumb breadcrumb hide">
					<li><a href="#">Home</a><i class="fa fa-circle"></i></li>
					<li><a href="layout_blank_page.html">Features</a> <i
						class="fa fa-circle"></i></li>
					<li class="active">Blank Page Layout</li>
				</ul>
				<!-- END PAGE BREADCRUMB -->
				<!-- BEGIN PAGE CONTENT INNER -->
				<div class="row margin-top-10">
					<div class="col-md-12">
						<div class="portlet light">
							<div class="portlet-title">
								<div class="caption caption-md">
									<span class="caption-subject theme-font bold uppercase">首页图片设置(注：最佳1920*445)</span>
								</div>
							</div>
                            <div class="portlet-body">
                            	<div id="tab_images_uploader_container"
								class="text-align-reverse margin-bottom-10">
								<a id="tab_images_uploader_pickfiles" href="javascript:;"
									class="btn yellow"> <i class="fa fa-plus"></i> 选择图片
								</a> <a id="tab_images_uploader_uploadfiles" href="javascript:;"
									class="btn green"> <i class="fa fa-share"></i> 上传图片
								</a>
							</div>
							<div class="row">
								<div id="tab_images_uploader_filelist"
									class="col-md-6 col-sm-12"></div>
							</div>
							<table class="table table-bordered table-hover" id="remove_bg">
								<thead>
									<tr role="row" class="heading">
										<th width="80%">图片</th>

										<th width="20%">操作</th>
									</tr>
								</thead>
								<tbody>
								    <c:forEach var="b" items="${bg}">
								    	<tr>
										<td>
											<div class="fileinput thumbnail" >
												<img src="${b.value}"  alt="" style="height: 150px;" width="100%"/>
											</div>
										</td>
										<td><a class="btn default btn-sm remove"><i class="fa fa-times"></i> Remove</a>
										    <input class="hide" value="${b.key}"/>
										</td>
									   </tr>
								    </c:forEach>
							   </tbody>
							</table>
                            </div>
							
							
							
						</div>
					</div>
				</div>
				<div class="row margin-top-10">
					<div class="col-md-12">
					<div class="portlet light">
				
				    <div class="portlet-title">
								<div class="caption caption-md">
									<span class="caption-subject theme-font bold uppercase">首页信息设置</span>
								</div>
					</div>
					<div class="portlet-body">
					<div class="row">
						<div class="col-md-12">
						    <button id="enable" class="btn blue">Enable / Disable</button>
							<hr>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<table id="setting" class="table table-bordered table-striped">
							<tbody>
							<tr>
								<td style="width:15%">
									 电话
								</td>
								<td style="width:50%">
									<a href="javascript:;" id="index_phone" data-type="text" data-pk="1" data-original-title="Enter Phone" class="editable editable-click editable-disabled">
									${phone}</a>
								</td>
								<td style="width:35%">
									<span class="text-muted">
									电话设置</span>
								</td>
							</tr>
							<tr>
								<td style="width:15%">
									 邮箱
								</td>
								<td style="width:50%">
									<a href="javascript:;" id="index_email" data-type="text" data-pk="1" data-original-title="Enter Email" class="editable editable-click editable-disabled">
									${email}</a>
								</td>
								<td style="width:35%">
									<span class="text-muted">
									邮箱设置</span>
								</td>
							</tr>
							  </tbody>
							</table>
						</div>
					</div>
					</div>
				
			</div>
					
					
				    </div>
			   </div>
				
				
				<!-- END PAGE CONTENT INNER -->
			</div>
		</div>
		<!-- END PAGE CONTENT -->
	</div>
	<!-- END PAGE CONTAINER -->

	<!-- BEGIN FOOTER -->
	<c:import url="/admin/common/footer" />
	<!-- END FOOTER -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<!--[if lt IE 9]>
<script src="../../assets/global/plugins/respond.min.js"></script>
<script src="../../assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
	<script src="../../assets/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="../../assets/global/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script
		src="../../assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js"
		type="text/javascript"></script>
	<script src="../../assets/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="../../assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
		type="text/javascript"></script>
	<script
		src="../../assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<script src="../../assets/global/plugins/jquery.blockui.min.js"
		type="text/javascript"></script>
	<script src="../../assets/global/plugins/jquery.cokie.min.js"
		type="text/javascript"></script>
	<script src="../../assets/global/plugins/uniform/jquery.uniform.min.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- START  PLUGINS -->
	<script type="text/javascript"
		src="../../assets/global/plugins/select2/select2.min.js"></script>
	<script type="text/javascript"
		src="../../assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="../../assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
	<script
		src="../../assets/global/plugins/plupload/js/plupload.full.min.js"
		type="text/javascript"></script>
	<script type="text/javascript" src="../../assets/global/plugins/bootstrap-editable/bootstrap-editable/js/bootstrap-editable.js"></script>
	<!-- END  PLUGINS -->
	<script src="../../assets/global/scripts/metronic.js"
		type="text/javascript"></script>
	<script src="../../assets/admin/layout/scripts/layout.js"
		type="text/javascript"></script>
	<script src="../../assets/admin/layout/scripts/demo.js"
		type="text/javascript"></script>
		
	<script src="../../static/admin/js/index_setting.js"
		type="text/javascript"></script>
	<script>
		jQuery(document).ready(function() {
			Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			Demo.init(); // init demo features
			IndexSetting.init("<c:url value="/"/>");
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>