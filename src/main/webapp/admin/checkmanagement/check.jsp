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
<title>HMS | 入住办理</title>
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
	href="../../assets/global/plugins/clockface/css/clockface.css" />
<link rel="stylesheet" type="text/css"
	href="../../assets/global/plugins/bootstrap-datepicker/css/datepicker3.css" />
<link rel="stylesheet" type="text/css"
	href="../../assets/global/plugins/bootstrap-timepicker/css/bootstrap-timepicker.min.css" />
<link rel="stylesheet" type="text/css"
	href="../../assets/global/plugins/bootstrap-colorpicker/css/colorpicker.css" />
<link rel="stylesheet" type="text/css"
	href="../../assets/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" />
<link rel="stylesheet" type="text/css"
	href="../../assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" />
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
						入住管理 <small>入住办理</small>
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
										class="caption-subject font-green-sharp bold uppercase">办理入住</span>
								</div>
								<div class="actions btn-set">

									<div class="btn-group"></div>

								</div>
							</div>
							<div class="portlet-body">
								<form id="searchForm" name="searchForm" action="adminuserlist1"
									class="form-horizontal" method="post">

									<div class="row">

										<div class="col-md-12">
											<div class="form-group">
												<label class="col-md-2 control-label">入住类型</label>
												<div class="col-md-9">
													<div class="radio-list">
														<label class="radio-inline"> <input type="radio"
															name="ordertpye" value="1" checked />订单入住
														</label> <label class="radio-inline"> <input type="radio"
															name="ordertpye" value="0" />直接入住
														</label>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="row" id="predetemine">
										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-4 control-label">选择订单</label>
												<div class="col-md-8">
													<select class="form-control input-large">
														<option value="">选择订单</option>
														<c:forEach var="p" items="${predetemineOrder}">
															<option value="${p.key}">${p.value}</option>
														</c:forEach>

													</select>
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-3 control-label">订单是否完成</label>
												<div class="col-md-9">
													<div class="radio-list">
														<label class="radio-inline"> <input type="radio"
															name="flag" value="1" checked />是
														</label> <label class="radio-inline"> <input type="radio"
															name="flag" value="0" />否
														</label>
													</div>
												</div>
											</div>
										</div>

									</div>
									
									<div class="row">

										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-4 control-label">房间类型</label>
												<div class="col-md-8">
													<select class="form-control input-medium" name="roomType">
													    <option value="-1">选择订单</option>
														<c:forEach var="r" items="${roomType}">
															<option value="${r.key}">${r.value}</option>
														</c:forEach>

													</select>
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-3 control-label">房间号</label>
												<div class="col-md-9">
													<select class="form-control input-small" name="room">
														 <option value="-1">选择房号</option> 

													</select>
												</div>
											</div>
										</div>
									</div>
									<div class="row">

										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-4 control-label">入住日期</label>
												<div class="col-md-8">
													<div class="input-group input-medium date date-picker"
														data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
														<input type="text" class="form-control" readonly>
														<span class="input-group-btn">
															<button class="btn default" type="button">
																<i class="fa fa-calendar"></i>
															</button>
														</span>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-3 control-label">退房日期</label>
												<div class="col-md-9">
													<div class="input-group input-medium date date-picker"
														data-date-format="yyyy-mm-dd" data-date-start-date="+1d">
														<input type="text" class="form-control" readonly>
														<span class="input-group-btn">
															<button class="btn default" type="button">
																<i class="fa fa-calendar"></i>
															</button>
														</span>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">

										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-4 control-label">客人姓名</label>
												<div class="col-md-8">
													<input type="text" class="form-control" />
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-3 control-label">客人身份证</label>
												<div class="col-md-9">
													<input type="text" class="form-control" />
												</div>
											</div>
										</div>
									</div>
									<div class="row">

										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-4 control-label">客人姓名</label>
												<div class="col-md-8">
													<input type="text" class="form-control" />
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-3 control-label">客人身份证</label>
												<div class="col-md-9">
													<input type="text" class="form-control" />
												</div>
											</div>
										</div>
									</div>
									<div class="row">

										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-4 control-label">房间费用</label>
												<div class="col-md-8">
													<input type="text" class="form-control input-small" />
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-3 control-label">缴费</label>
												<div class="col-md-9">
													<input type="text" class="form-control input-small" />
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<div class="col-md-offset-3 col-md-9">
													<button type="submit" class="btn blue">确认</button>
													<button type="reset" class="btn grey-cascade">重置
													</button>
												</div>
											</div>
										</div>
									</div>
								</form>
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

	<script type="text/javascript"
		src="../../assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript"
		src="../../assets/global/plugins/bootstrap-timepicker/js/bootstrap-timepicker.min.js"></script>
	<script type="text/javascript"
		src="../../assets/global/plugins/clockface/js/clockface.js"></script>
	<script type="text/javascript"
		src="../../assets/global/plugins/bootstrap-daterangepicker/moment.min.js"></script>
	<script type="text/javascript"
		src="../../assets/global/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
	<script type="text/javascript"
		src="../../assets/global/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>
	<script type="text/javascript"
		src="../../assets/global/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script type="text/javascript"
		src="../../assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<!-- END CORE PLUGINS -->
	<script src="../../assets/global/scripts/metronic.js"
		type="text/javascript"></script>
	<script src="../../assets/admin/layout/scripts/layout.js"
		type="text/javascript"></script>
	<script src="../../assets/admin/layout/scripts/demo.js"
		type="text/javascript"></script>
	<script src="../../static/admin/js/check.js" type="text/javascript"></script>
	<script>
		jQuery(document).ready(function() {
			Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			Demo.init(); // init demo features
			Check.init("<c:url value="/"/>");
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>