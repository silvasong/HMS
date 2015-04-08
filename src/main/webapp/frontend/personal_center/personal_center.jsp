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

<!-- Head BEGIN -->
<head>
<meta charset="utf-8">
<title>个人中心</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="shortcut icon" href="favicon.ico">

<!-- Global styles START -->
<link
	href="../../assets/global/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="../../assets/global/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Global styles END -->
<link
	href="../../assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css" />
<!-- Page level plugin styles START -->
<link
	href="../../assets/global/plugins/fancybox/source/jquery.fancybox.css"
	rel="stylesheet">
<link
	href="../../assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css"
	rel="stylesheet">
<link
	href="../../assets/global/plugins/slider-revolution-slider/rs-plugin/css/settings.css"
	rel="stylesheet">
<!-- Page level plugin styles END -->
<link href="../../assets/admin/pages/css/profile-old.css"
	rel="stylesheet" type="text/css" />
<!-- Theme styles START -->
<link href="../../assets/global/css/components.css" rel="stylesheet">
<link href="../../assets/frontend/layout/css/style.css" rel="stylesheet">
<link href="../../assets/frontend/pages/css/style-revolution-slider.css"
	rel="stylesheet">
<!-- metronic revo slider styles -->
<link href="../../assets/frontend/layout/css/style-responsive.css"
	rel="stylesheet">
<link href="../../assets/frontend/layout/css/themes/red.css"
	rel="stylesheet" id="style-color">
<link href="../../assets/frontend/layout/css/custom.css"
	rel="stylesheet">
<!-- Theme styles END -->
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="corporate">

	<c:import url="/frontend/common/head" />
	<!-- Header END -->



	<div class="main">
		<div class="container">
			<div class="row">
				<div id="alert"></div>
			</div>
			<div class="row ">
				<div class="col-md-12">
					<!--BEGIN TABS-->

					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab_1_1" data-toggle="tab">
								订单管理 </a></li>
						<li class=""><a href="#tab_1_3" data-toggle="tab"> 个人资料 </a></li>

					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tab_1_1">
							<div class="row">
								<div class="col-md-6">
									<div class="portlet light">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa fa-cogs font-green-sharp"></i> <span
													class="caption-subject font-green-sharp bold uppercase">待确认</span>
											</div>
											<div class="actions btn-set">
												<a class="btn green-haze btn-circle" data-toggle="modal"
													id="qx_btn1">取消 </a>
												<div class="btn-group"></div>

											</div>
										</div>
										<div class="portlet-body">
											<table class="table table-striped table-bordered table-hover"
												id="table1">
												<thead>

												</thead>

											</table>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="portlet light">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa fa-cogs font-green-sharp"></i> <span
													class="caption-subject font-green-sharp bold uppercase">待入住</span>
											</div>
											<div class="actions btn-set">
												<a class="btn green-haze btn-circle" data-toggle="modal"
													id="qx_btn2">取消 </a>
												<div class="btn-group"></div>

											</div>
										</div>
										<div class="portlet-body">
											<table class="table table-striped table-bordered table-hover"
												id="table2">
												<thead>

												</thead>

											</table>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="portlet light">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa fa-cogs font-green-sharp"></i> <span
													class="caption-subject font-green-sharp bold uppercase">已入住订单</span>
											</div>
											<div class="actions btn-set">

												<div class="btn-group"></div>

											</div>
										</div>
										<div class="portlet-body">
											<table class="table table-striped table-bordered table-hover"
												id="table3">
												<thead>

												</thead>

											</table>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="portlet light">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa fa-cogs font-green-sharp"></i> <span
													class="caption-subject font-green-sharp bold uppercase">待评价</span>
											</div>
											<div class="actions btn-set">

												<div class="btn-group"></div>

											</div>
										</div>
										<div class="portlet-body">
											<table class="table table-striped table-bordered table-hover"
												id="table4">
												<thead>

												</thead>

											</table>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="portlet light">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa fa-cogs font-green-sharp"></i> <span
													class="caption-subject font-green-sharp bold uppercase">完成订单</span>
											</div>
											<div class="actions btn-set">

												<div class="btn-group"></div>

											</div>
										</div>
										<div class="portlet-body">
											<table class="table table-striped table-bordered table-hover"
												id="table5">
												<thead>

												</thead>

											</table>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="portlet light">
										<div class="portlet-title">
											<div class="caption">
												<i class="fa fa-cogs font-green-sharp"></i> <span
													class="caption-subject font-green-sharp bold uppercase">作废订单</span>
											</div>
											<div class="actions btn-set">

												<div class="btn-group"></div>

											</div>
										</div>
										<div class="portlet-body">
											<table class="table table-striped table-bordered table-hover"
												id="table6">
												<thead>

												</thead>

											</table>
										</div>
									</div>
								</div>

							</div>
						</div>
						<!--tab_1_2-->
						<div class="tab-pane" id="tab_1_3">
							<div class="row profile-account">
								<div class="col-md-3">
									<ul class="ver-inline-menu tabbable margin-bottom-10">
										<li class="active"><a data-toggle="tab" href="#tab_1-1"
											aria-expanded="false"> <i class="fa fa-cog"></i> 个人信息
										</a> <span class="after"> </span></li>
										<li class=""><a data-toggle="tab" href="#tab_3-3"
											aria-expanded="false"> <i class="fa fa-lock"></i> 修改密码
										</a></li>

									</ul>
								</div>
								<div class="col-md-9">
									<div class="tab-content">
										<div id="tab_1-1" class="tab-pane active">
											<form:form role="form" method="post" commandName="customer"
												id="edit_form">
												<div class="form-group">
													<label class="control-label">身份证</label>
													<form:input type="text" class="form-control" path="idCard"
														readonly="true" />
												</div>
												<div class="form-group">
													<label class="control-label">姓名</label>
													<form:input type="text" class="form-control" path="name" />
												</div>
												<%-- <div class="form-group">
													<label class="control-label">性别</label>
													<div class="radio-list">
														<label class="radio-inline"> <form:radiobutton
															path="sex" value="true" checked />男
														</label> <label class="radio-inline"> <form:radiobutton
															path="sex" value="false" />女
														</label>
													</div>
												</div> --%>
												<div class="form-group">
													<label class="control-label">电话</label>
													<form:input type="text" class="form-control" path="phone" />
												</div>
												<div class="form-group">
													<label class="control-label">邮箱</label>
													<form:input type="text" class="form-control" path="email" />
												</div>
												<div class="form-group">
													<label class="control-label">地址</label>
													<form:input type="text" class="form-control" path="address" />
												</div>


												<div class="margiv-top-10">
													<input type="submit" class="btn btn-primary" value="保存修改" />
												</div>
											</form:form>
										</div>

										<div id="tab_3-3" class="tab-pane">
											<form method="post" id="edit_password_form">
												<div class="form-group">
													<label class="control-label">当前密码</label> <input
														type="password" class="form-control" name="password">
												</div>
												<div class="form-group">
													<label class="control-label">新密码</label> <input
														type="password" class="form-control" name="newpassword"
														id="new_password">
												</div>
												<div class="form-group">
													<label class="control-label">重复新密码</label> <input
														type="password" class="form-control"
														name="confirm_password">
												</div>
												<div class="margin-top-10">
													<input type="submit" class="btn btn-primary" value="修改密码" />
												</div>
											</form>
										</div>

									</div>
								</div>
								<!--end col-md-9-->
							</div>
						</div>
						<!--end tab-pane-->
					</div>

				</div>
			</div>

			<div class="modal fade" id="qx_modal1" tabindex="-1" role="basic"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">取消订单</h4>
						</div>
						<div class="modal-body">确认取消选中订单？</div>
						<div class="modal-footer">
							<button type="button" class="btn blue" id="qx_com1">确认</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>

			<div class="modal fade" id="qx_modal2" tabindex="-1" role="basic"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">取消订单</h4>
						</div>
						<div class="modal-body">确认取消选中订单？</div>
						<div class="modal-footer">
							<button type="button" class="btn blue" id="qx_com2">确认</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>

			<div class="modal fade" id="pj_modal" tabindex="-1" role="basic"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">评价订单</h4>
						</div>
						<div class="modal-body">
							<div class="portlet light">
								<div class="portlet-body form">

									<form class="form-horizontal" role="form" id="px_from" method="post">
										<div class="form-body">
										    <input type="text" id="predetermineId" class="hidden" name="predetermineId"/>
											<div class="form-group">
												<label class="col-md-3 control-label">卫生程度</label>
												<div class="col-md-5">
													<div id="spinner1">
														<div class="input-group input-small">
															<input type="text" class="spinner-input form-control"
																maxlength="3" readonly name="score1">
															<div
																class="spinner-buttons input-group-btn btn-group-vertical">
																<button type="button" class="btn spinner-up btn-xs blue">
																	<i class="fa fa-angle-up"></i>
																</button>
																<button type="button"
																	class="btn spinner-down btn-xs blue">
																	<i class="fa fa-angle-down"></i>
																</button>
															</div>
														</div>
													</div>
												</div>
											</div>
                                            <div class="form-group">
												<label class="col-md-3 control-label">舒适度</label>
												<div class="col-md-5">
													<div id="spinner2">
														<div class="input-group input-small">
															<input type="text" class="spinner-input form-control"
																maxlength="3" readonly name="score2">
															<div
																class="spinner-buttons input-group-btn btn-group-vertical">
																<button type="button" class="btn spinner-up btn-xs blue">
																	<i class="fa fa-angle-up"></i>
																</button>
																<button type="button"
																	class="btn spinner-down btn-xs blue">
																	<i class="fa fa-angle-down"></i>
																</button>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-3 control-label">服务</label>
												<div class="col-md-5">
													<div id="spinner3">
														<div class="input-group input-small">
															<input type="text" class="spinner-input form-control"
																maxlength="3" readonly name="score3">
															<div
																class="spinner-buttons input-group-btn btn-group-vertical">
																<button type="button" class="btn spinner-up btn-xs blue">
																	<i class="fa fa-angle-up"></i>
																</button>
																<button type="button"
																	class="btn spinner-down btn-xs blue">
																	<i class="fa fa-angle-down"></i>
																</button>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-3 control-label">评语</label>
												<div class="col-md-9">
													<textarea class="form-control" rows="3" name="commendContend"></textarea>
												</div>
											</div>
                                        </div>
										<div class="form-actions right1">
											<button type="button" class="btn default"
												data-dismiss="modal">取消</button>
											<button type="button" class="btn green" id="pj">提交</button> 
											
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



	<!-- BEGIN FOOTER -->
	<c:import url="/frontend/common/footer" />

	<!-- END FOOTER -->

	<!-- Load javascripts at bottom, this will reduce page load time -->
	<!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
	<!--[if lt IE 9]>
    <script src="../../assets/global/plugins/respond.min.js"></script>
    <![endif]-->
	<script src="../../assets/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="../../assets/global/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<script src="../../assets/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="../../assets/frontend/layout/scripts/back-to-top.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<script
		src="../../assets/global/plugins/datatables/media/js/jquery.dataTables.js"
		type="text/javascript"></script>
	<script
		src="../../assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"
		type="text/javascript"></script>
	<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
	<script
		src="../../assets/global/plugins/fancybox/source/jquery.fancybox.pack.js"
		type="text/javascript"></script>
	<!-- pop up -->
	<script
		src="../../assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js"
		type="text/javascript"></script>
	<!-- slider for products -->

	<!-- BEGIN RevolutionSlider -->

	<script
		src="../../assets/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.revolution.min.js"
		type="text/javascript"></script>
	<script
		src="../../assets/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.tools.min.js"
		type="text/javascript"></script>
	<script src="../../assets/frontend/pages/scripts/revo-slider-init.js"
		type="text/javascript"></script>
	<!-- END RevolutionSlider -->
	<script src="../../assets/global/scripts/metronic.js"
		type="text/javascript"></script>
	<script src="../../assets/frontend/layout/scripts/layout.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="../../assets/global/plugins/fuelux/js/spinner.min.js"></script>
	<script src="../../static/frontend/js/personal.js"
		type="text/javascript"></script>
	<script
		src="../../assets/global/plugins/jquery-validation/js/jquery.validate.min.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			Metronic.init();
			Layout.init();
			Layout.initOWL();
			RevosliderInit.initRevoSlider();
			Personal.init("<c:url value="/"/>");
		});
	</script>
	<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>