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
<title>首页</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="shortcut icon" href="favicon.ico">

<!-- Global styles START -->
<link href="assets/global/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="assets/global/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Global styles END -->

<!-- Page level plugin styles START -->
<link href="assets/global/plugins/fancybox/source/jquery.fancybox.css"
	rel="stylesheet">
<link
	href="assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css"
	rel="stylesheet">
<link
	href="assets/global/plugins/slider-revolution-slider/rs-plugin/css/settings.css"
	rel="stylesheet">
<!-- Page level plugin styles END -->

<!-- Theme styles START -->
<link href="assets/global/css/components.css" rel="stylesheet">
<link href="assets/frontend/layout/css/style.css" rel="stylesheet">
<link href="assets/frontend/pages/css/style-revolution-slider.css"
	rel="stylesheet">
<!-- metronic revo slider styles -->
<link href="assets/frontend/layout/css/style-responsive.css"
	rel="stylesheet">
<link href="assets/frontend/layout/css/themes/red.css" rel="stylesheet"
	id="style-color">
<link href="assets/frontend/layout/css/custom.css" rel="stylesheet">
<!-- Theme styles END -->
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="corporate">

	<c:import url="/frontend/common/head" />
	<!-- Header END -->

	<c:import url="/frontend/common/page_slider"/>

	<div class="main">
		<div class="container">
			<!-- BEGIN SERVICE BOX -->
			<div class="row service-box margin-bottom-40">
				<div class="col-md-4 col-sm-4">
					<div class="service-box-heading">
						<em><i class="fa fa-location-arrow blue"></i></em> <span>Location
							</span>
					</div>
					<p>   繁华都市中的宁静栖息地，是为热爱生活和讲求生活品质的客人准备的旅途居所，不追求奢华的装饰与接待的繁文缛节，提供的是亲近自然的环境、细致周到的服务，致力于为客人提供一个放松身心轻松自在的家外之家。</p>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="service-box-heading">
						<em><i class="fa fa-check red"></i></em> <span>Service</span>
					</div>
					<p>酒店以真诚为本、亲切于心的传统为尊，为客人提供精致优雅的住宿环境和无微不至的优良服务。</p>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="service-box-heading">
						<em><i class="fa fa-compress green"></i></em> <span>
							Facilities</span>
					</div>
					<p>宽敞的厅堂、温馨的大堂吧、绿色人文景观、现代化的会议设施、充分满足客人的个性化的需求；装饰简洁、色调淡雅的客房，温馨舒适，丰盛的商务早餐和时尚的健身中心为繁忙的商务人士提供细致周到的服务。</p>
				</div>
			</div>
			<!-- END SERVICE BOX -->
			<!-- BEGIN CLIENTS -->
			<div class="row margin-bottom-40 our-clients">
				<div class="col-md-3">
					<h2>
						<a href="#">Our Clients</a>
					</h2>
					<p>Lorem dipsum folor margade sitede lametep eiusmod psumquis
						dolore.</p>
				</div>
				<div class="col-md-9">
					<div class="owl-carousel owl-carousel6-brands">
						<div class="client-item">
							<a href="#"> <img
								src="assets/frontend/pages/img/clients/client_1_gray.png"
								class="img-responsive" alt=""> <img
								src="assets/frontend/pages/img/clients/client_1.png"
								class="color-img img-responsive" alt="">
							</a>
						</div>
					</div>
				</div>
			</div>
			<!-- END CLIENTS -->
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
	<script src="assets/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="assets/global/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="assets/frontend/layout/scripts/back-to-top.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
	<script
		src="assets/global/plugins/fancybox/source/jquery.fancybox.pack.js"
		type="text/javascript"></script>
	<!-- pop up -->
	<script
		src="assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js"
		type="text/javascript"></script>
	<!-- slider for products -->

	<!-- BEGIN RevolutionSlider -->

	<script
		src="assets/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.revolution.min.js"
		type="text/javascript"></script>
	<script
		src="assets/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.tools.min.js"
		type="text/javascript"></script>
	<script src="assets/frontend/pages/scripts/revo-slider-init.js"
		type="text/javascript"></script>
	<!-- END RevolutionSlider -->

	<script src="assets/frontend/layout/scripts/layout.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			Layout.init();
			Layout.initOWL();
			RevosliderInit.initRevoSlider();
			Layout.initTwitter();

		});
	</script>
	<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>