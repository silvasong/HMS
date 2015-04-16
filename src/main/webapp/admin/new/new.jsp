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
<title>HMS | 新闻列表</title>
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
<link href="../../assets/global/plugins/select2/select2.css"
	rel="stylesheet" type="text/css" />
<link
	href="../../assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css" />

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
						新闻管理<small>新闻列表</small>
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
				<div class="row">
					<div class="col-md-12">
						<div class="portlet light">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-cogs font-green-sharp"></i> <span
										class="caption-subject font-green-sharp bold uppercase">列表</span>
								</div>
								<div class="actions btn-set">
									<a class="btn green-haze btn-circle" data-toggle="modal"
										href="#add_modal">添加 </a> <a class="btn green-haze btn-circle"
										data-toggle="modal" href="#edit_modal" id="edit_btn">编辑 </a> <a
										class="btn green-haze btn-circle" data-toggle="modal"
										id="delete_btn">删除 </a>
									<div class="btn-group">

										<a class="btn green-haze btn-circle" href="javascript:;"
											data-toggle="dropdown"> <!--<i class="fa fa-check-circle"></i>-->
											Columns <i class="fa fa-angle-down"></i>
										</a>
										<ul class="dropdown-menu pull-right" id="column_toggler">
											<li><label><input type="checkbox" checked
													data-column="0">CheckBox</label></li>
											<li><label><input type="checkbox" checked
													data-column="1">ID</label></li>
											<li><label><input type="checkbox" checked
													data-column="2">类型</label></li>
											<li><label><input type="checkbox" checked
													data-column="3">原价</label></li>
											<li><label><input type="checkbox" checked
													data-column="4">优惠价</label></li>
											<li><label><input type="checkbox" checked
													data-column="5">入住人数</label></li>
											<li><label><input type="checkbox" checked
													data-column="6">早餐</label></li>

										</ul>
									</div>

								</div>
							</div>
							<div class="portlet-body">
								<table class="table table-striped table-bordered table-hover"
									id="table">
									<thead>

									</thead>

								</table>
							</div>

							<div class="modal fade" id="add_modal" tabindex="-1" role="basic"
								aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true"></button>
											<h4 class="modal-title">添加新闻</h4>
										</div>
										<div class="modal-body">
											<div class="portlet light">
												<div class="portlet-body form">
													<div id="info"></div>
													<form class="form-horizontal" role="form" id="add_from">
														<div class="form-body">
															<div class="form-group">
																<label class="col-md-2 control-label">标题</label>
																<div class="col-md-5">
																	<input type="text" class="form-control" name="newTitle">
																</div>
															</div>
															<div class="form-group">
																<label class="col-md-2 control-label">来源</label>
																<div class="col-md-5">
																	<input type="text" class="form-control" name="newAuthor">
																</div>
															</div>
															<div class="form-group">
																<label class="col-md-2 control-label">栏目</label>
																<div class="col-md-5">
																	<select class="form-control input-large"
																		name="newType">
																		<c:forEach var="n" items="${newType}">
																			<option value="${n.key}">${n.value}</option>
																		</c:forEach>

																	</select>
																</div>
															</div>
															<div class="form-group">
																<label class="col-md-2 control-label">内容</label>
																<div class="col-md-10">
																	<textarea class="form-control" rows="10" name="newContent"></textarea>
																</div>
															</div>
														</div>
														<div class="form-actions right1">
															<button type="button" class="btn default"
																data-dismiss="modal">取消</button>
															<button type="submit" class="btn green">提交</button>
														</div>
													</form>
												</div>
											</div>
										</div>

									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>

							<div class="modal fade" id="delete_modal" tabindex="-1"
								role="basic" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true"></button>
											<h4 class="modal-title">删除新闻</h4>
										</div>
										<div class="modal-body">确认删除选中？</div>
										<div class="modal-footer">
											<button type="button" class="btn default"
												data-dismiss="modal">取消</button>
											<button type="button" class="btn blue" id="delete_com">确认</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>

							<div class="modal fade" id="edit_modal" tabindex="-1"
								role="basic" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true"></button>
											<h4 class="modal-title">编辑新闻</h4>
										</div>
										<div class="modal-body">
											<div class="portlet light">
												<div class="portlet-body form">
													<div id="info"></div>
													<form class="form-horizontal" role="form" id="edit_from">
														<div class="form-body">
														    <div class="form-group">
																<input type="text" class="form-control hidden"
																	placeholder="" name="newId">
															</div>
															<div class="form-group">
																<label class="col-md-2 control-label">标题</label>
																<div class="col-md-5">
																	<input type="text" class="form-control" name="newTitle">
																</div>
															</div>
															<div class="form-group">
																<label class="col-md-2 control-label">来源</label>
																<div class="col-md-5">
																	<input type="text" class="form-control" name="newAuthor">
																</div>
															</div>
															<div class="form-group">
																<label class="col-md-2 control-label">栏目</label>
																<div class="col-md-5">
																	<select class="form-control input-large"
																		name="newType">
																		<c:forEach var="n" items="${newType}">
																			<option value="${n.key}">${n.value}</option>
																		</c:forEach>

																	</select>
																</div>
															</div>
															<div class="form-group">
																<label class="col-md-2 control-label">内容</label>
																<div class="col-md-10">
																	<textarea class="form-control" rows="10" name="newContent"></textarea>
																</div>
															</div>
														</div>
														<div class="form-actions right1">
															<button type="button" class="btn default"
																data-dismiss="modal">取消</button>
															<button type="submit" class="btn green">提交</button>
														</div>
													</form>
												</div>
											</div>
										</div>

									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
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
	<script
		src="../../assets/global/plugins/jquery-validation/js/jquery.validate.min.js"
		type="text/javascript">
		
	</script>
	<script src="../../assets/global/plugins/select2/select2.min.js"
		type="text/javascript"></script>
	<script
		src="../../assets/global/plugins/datatables/media/js/jquery.dataTables.js"
		type="text/javascript"></script>
	<script
		src="../../assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"
		type="text/javascript"></script>
	<script
		src="../../assets/global/plugins/plupload/js/plupload.full.min.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<script src="../../assets/global/scripts/metronic.js"
		type="text/javascript"></script>
	<script src="../../assets/admin/layout/scripts/layout.js"
		type="text/javascript"></script>
	<script src="../../assets/admin/layout/scripts/demo.js"
		type="text/javascript"></script>
	<script src="../../static/admin/js/new.js" type="text/javascript"></script>
	<script>
		jQuery(document).ready(function() {
			Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			Demo.init(); // init demo features
			New.init("<c:url value="/"/>");
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>