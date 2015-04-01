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
<title>在线预定</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="shortcut icon" href="favicon.ico">

<!-- Global styles START -->
<link
	href="../assets/global/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="../assets/global/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Global styles END -->

<!-- Page level plugin styles START -->
<link
	href="../assets/global/plugins/fancybox/source/jquery.fancybox.css"
	rel="stylesheet">
<link
	href="../assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css"
	rel="stylesheet">
<link
	href="../assets/global/plugins/slider-revolution-slider/rs-plugin/css/settings.css"
	rel="stylesheet">
<!-- Page level plugin styles END -->
<link rel="stylesheet" type="text/css"
	href="../assets/global/plugins/bootstrap-datepicker/css/datepicker3.css" />
<link rel="stylesheet" type="text/css"
	href="../assets/global/plugins/bootstrap-timepicker/css/bootstrap-timepicker.min.css" />
<link rel="stylesheet" type="text/css"
	href="../assets/global/plugins/bootstrap-colorpicker/css/colorpicker.css" />
<link rel="stylesheet" type="text/css"
	href="../assets/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" />
<link rel="stylesheet" type="text/css"
	href="../assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" />
<!-- Theme styles START -->
<link href="../assets/global/css/components.css" rel="stylesheet">
<link href="../assets/frontend/layout/css/style.css" rel="stylesheet">
<link href="../assets/frontend/pages/css/style-revolution-slider.css"
	rel="stylesheet">
<!-- metronic revo slider styles -->
<link href="../assets/frontend/layout/css/style-responsive.css"
	rel="stylesheet">
<link href="../assets/frontend/layout/css/themes/red.css"
	rel="stylesheet" id="style-color">
<link href="../assets/frontend/layout/css/custom.css" rel="stylesheet">
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
			<div class="note note-success">
				<h4 class="block">在线预定</h4>
				<div class="row">
					<div class="col-md-5">
						<div class="form-group">
							<label class="control-label col-md-3">入住时间</label>
							<div class="col-md-4">
								<div class="input-group input-large date-picker input-daterange"
									data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
									<input type="text" class="form-control" name="start"
										value="${start}"> <span class="input-group-addon">
										to </span> <input type="text" class="form-control" name="end"
										value="${end}">
								</div>
								<!-- /input-group -->

							</div>
						</div>
					</div>
					<div class="col-md-1">
						<button type="button" class="btn btn-primary">搜索</button>
					</div>

				</div>

			</div>

			<div class="portlet light bordered form-fit">

				<div class="portlet-body form">
					<table class="table table-hover table-light" id="predetemine">
						<thead>
							<tr class="uppercase font-green-haze">
								<th colspan="2" class="font-green-haze" width="30%">房型</th>
								<th class="font-green-haze" width="20%">早餐</th>
								<th class="font-green-haze" width="20%">取消政策</th>
								<th class="font-green-haze" width="20%">日均价</th>
								<th class="font-green-haze" width="10%"></th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="roomType" items="${roomTypeMap }">
								<tr>
									<td class="fit" rowspan="2"><img
										src="../static/frontend/image/room.jpg"></td>
									<td>${roomType.value[0]}</td>
									<td>${roomType.value[1]}</td>
									<td>${roomType.value[2]}</td>
									<td>${roomType.value[3]}</td>

									<td><c:if test="${empty login}">
											<button type="button" class="btn btn-primary">预定</button>
										</c:if> <c:if test="${not empty login}">
											<a href="<c:url value="/"/>frontend/login">请先登录</a>
										</c:if> <input type="text" value="${roomType.key}" class="hidden" />
									</td>
								</tr>
								<tr>
									<td colspan="5">床型： ${roomType.value[4]} 最多入住人数：
										${roomType.value[5]} 楼层： ${roomType.value[6]} 上网方式：
										${roomType.value[7]}${roomType.value[8]}</td>
								</tr>
							</c:forEach>





						</tbody>
					</table>

				</div>
			</div>

			<div class="modal fade" id="predetemine_modal" tabindex="-1"
				role="basic" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">填写订单信息</h4>
						</div>
						<div class="modal-body">
							<div class="portlet light">
								<div class="portlet-body form">
									<div id="info"></div>

									<div class="row">
										<div class="col-md-12 col-sm-12">
											<form class="form-horizontal" role="form" id="register_form"
												method="post" >
												<fieldset>
												    <input type="text" value="" class="hidden" name="roomTypeId"/>
													<legend></legend>
													<div class="form-group">
														<label class="col-lg-4 control-label">房间数量 </label>
														<div class="col-lg-8">
															<select class="form-control input-xsmall" name="number" id="count">
																<option value="1">1间</option>
																<option value="2">2间</option>
																<option value="3">3间</option>
																<option value="4">4间</option>
																<option value="5">5间</option>
																<option value="6">6间</option>
																<option value="7">7间</option>
																<option value="8">8间</option>
																<option value="9">9间</option>
																<option value="10">10间</option>
															</select>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">入住时间 </label>
														<div class="col-lg-8">
															<label class="control-label" id="time"></label>
															<input type="text" class="hidden" name="time" value=""/>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">房间费用 </label>
														<div class="col-lg-8">
															<label class="control-label font-red-flamingo font-lg" id="price">  <span class="font-sm font-grey-mint">(预订免费，入住后酒店前台付款，注：如需发票，请从酒店前台索取)</span></label>
															<input type="text" class="hidden" name="price" value=""/>
														</div>
													</div>




												</fieldset>
												<fieldset>
													<legend>入住信息</legend>
													<div class="form-group">
														<label class="col-lg-4 control-label">入住人姓名 <span
															class="require">*</span>
														</label>
														<div class="col-lg-4">
															<input type="text" class="form-control" name="name" id="pass">
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">身份证号码 <span
															class="require">*</span>
														</label>
														<div class="col-lg-6">
															<input type="text" class="form-control" name="idCard" id="pass">
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">联系电话<span
															class="require">*</span>
														</label>
														<div class="col-lg-6">
															<input type="text" class="form-control" name="phone" id="pass">
														</div>
													</div>

												</fieldset>

												<div class="row">
													<div
														class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
														<input type="submit" class="btn btn-primary" value="完成预定">

													</div>
												</div>
											</form>
										</div>

									</div>

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
    <script src="assets/global/plugins/respond.min.js"></script>
    <![endif]-->
	<script src="../assets/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="../assets/global/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<script src="../assets/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="../assets/frontend/layout/scripts/back-to-top.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
	<script
		src="../assets/global/plugins/fancybox/source/jquery.fancybox.pack.js"
		type="text/javascript"></script>
	<!-- pop up -->
	<script
		src="../assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js"
		type="text/javascript"></script>
	<!-- slider for products -->
	<script type="text/javascript"
		src="../assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript"
		src="../assets/global/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script type="text/javascript"
		src="../assets/global/plugins/bootstrap-timepicker/js/bootstrap-timepicker.min.js"></script>
	<script type="text/javascript"
		src="../assets/global/plugins/clockface/js/clockface.js"></script>
	<script type="text/javascript"
		src="../assets/global/plugins/bootstrap-daterangepicker/moment.min.js"></script>
	<script type="text/javascript"
		src="../assets/global/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
	<script type="text/javascript"
		src="../assets/global/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>
	<script type="text/javascript"
		src="../assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<!-- BEGIN RevolutionSlider -->

	<script
		src="../assets/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.revolution.min.js"
		type="text/javascript"></script>
	<script
		src="../assets/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.tools.min.js"
		type="text/javascript"></script>
	<script src="../assets/frontend/pages/scripts/revo-slider-init.js"
		type="text/javascript"></script>
	<!-- END RevolutionSlider -->
	<script src="../assets/global/scripts/metronic.js"
		type="text/javascript"></script>
	<script src="../assets/frontend/layout/scripts/layout.js"
		type="text/javascript"></script>
	<script src="../static/frontend/js/online_order.js"
		type="text/javascript"></script>
	<script src="../assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			Metronic.init();
			Layout.init();
			Layout.initOWL();
			RevosliderInit.initRevoSlider();

			OnlineOrder.init("<c:url value="/"/>");
		});
	</script>
	<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>