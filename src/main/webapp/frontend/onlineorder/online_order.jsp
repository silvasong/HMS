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
			<div class="note note-success">
				<h4 class="block">在线预定</h4>
				<div class="row">
					<div class="col-md-5">
						<div class="form-group">
							<label class="control-label col-md-3">入住时间</label>
							<div class="col-md-4">
								<div class="input-group input-large date-picker input-daterange"
									data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
									<input type="text" class="form-control" name="from"> <span
										class="input-group-addon"> to </span> <input type="text"
										class="form-control" name="to">
								</div>
								<!-- /input-group -->

							</div>
						</div>
					</div>
					<div class="col-md-1">
						<button type="button" class="btn btn-primary">预定</button>
					</div>

				</div>

			</div>

			<div class="portlet light bordered form-fit">
				
				<div class="portlet-body form">
					<table class="table table-hover table-light">
								<thead>
								<tr class="uppercase font-green-haze">
									<th colspan="2" class="font-green-haze"  width="30%">
										 房型
									</th>
									<th class="font-green-haze" width="20%">
										早餐
									</th>
									<th class="font-green-haze" width="20%">
										取消政策
									</th>
									<th class="font-green-haze" width="20%">
										日均价
									</th>
									<th class="font-green-haze" width="10%">
										
									</th>
								</tr>
								</thead>
								<tbody>
								<tr>
									<td class="fit" rowspan="2">
										<img  src="../static/frontend/image/room.jpg">
										
									</td>
									<td>
										豪华单间
									</td>
									<td>
										双早
									</td>
									<td>
										限时取消
									</td>
									<td>
										 530.00
									</td>
									
									<td>
										<button type="button" class="btn btn-primary">预定</button>
									</td>
								</tr>
								<tr>
									<td colspan="5">床型：双床1.3米     最多入住人数：2人     楼层：3层-6层     上网方式：宽带[免费]</td>
								</tr>
								
								
									<tr>
									<td class="fit" rowspan="2">
										<img src="../static/frontend/image/room.jpg">
										
									</td>
									<td>
										豪华单间
									</td>
									<td>
										双早
									</td>
									<td>
										限时取消
									</td>
									<td>
										 530.00
									</td>
									
									<td>
										<button type="button" class="btn btn-primary">预定</button>
									</td>
								</tr>
								<tr>
									<td colspan="5">床型：双床1.3米     最多入住人数：2人     楼层：3层-6层     上网方式：宽带[免费]</td>
								</tr>
								
								<tr>
									<td class="fit" rowspan="2">
										<img  src="../static/frontend/image/room.jpg">
										
									</td>
									<td>
										豪华单间
									</td>
									<td>
										双早
									</td>
									<td>
										限时取消
									</td>
									<td>
										 530.00
									</td>
									
									<td>
										<button type="button" class="btn btn-primary">预定</button>
									</td>
								</tr>
								<tr>
									<td colspan="5">床型：双床1.3米     最多入住人数：2人     楼层：3层-6层     上网方式：宽带[免费]</td>
								</tr>
								
								
								
								
								
								</tbody>
								</table>
					
				</div>
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
	<script type="text/javascript">
		jQuery(document).ready(function() {
			Metronic.init();
			Layout.init();
			Layout.initOWL();
			RevosliderInit.initRevoSlider();
			//Layout.initTwitter();
			OnlineOrder.init();
		});
	</script>
	<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>