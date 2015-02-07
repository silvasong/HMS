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
<title>HMS</title>

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

	<!-- BEGIN SLIDER -->
	<div class="page-slider margin-bottom-40">
		<div class="fullwidthbanner-container revolution-slider">
			<div class="fullwidthabnner">
				<ul id="revolutionul">
					<!-- THE NEW SLIDE -->
					<li data-transition="fade" data-slotamount="8"
						data-masterspeed="700" data-delay="9400"
						data-thumb="assets/frontend/pages/img/revolutionslider/thumbs/thumb2.jpg">
						<!-- THE MAIN IMAGE IN THE FIRST SLIDE --> <img
						src="assets/frontend/pages/img/revolutionslider/bg9.jpg" alt="">
					</li>

					<!-- THE FIRST SLIDE -->
					<li data-transition="fade" data-slotamount="8"
						data-masterspeed="700" data-delay="9400"
						data-thumb="assets/frontend/pages/img/revolutionslider/thumbs/thumb2.jpg">
						<!-- THE MAIN IMAGE IN THE FIRST SLIDE --> <img
						src="assets/frontend/pages/img/revolutionslider/bg9.jpg" alt="">
					</li>

					<!-- THE SECOND SLIDE -->
					<li data-transition="fade" data-slotamount="7"
						data-masterspeed="300" data-delay="9400"
						data-thumb="assets/frontend/pages/img/revolutionslider/thumbs/thumb2.jpg">
						<img src="assets/frontend/pages/img/revolutionslider/bg9.jpg"
						alt="">
					</li>

					<!-- THE THIRD SLIDE -->
					<li data-transition="fade" data-slotamount="8"
						data-masterspeed="700" data-delay="9400"
						data-thumb="assets/frontend/pages/img/revolutionslider/thumbs/thumb2.jpg">
						<img src="assets/frontend/pages/img/revolutionslider/bg9.jpg"
						alt="">
					</li>

					<!-- THE FORTH SLIDE -->
					<li data-transition="fade" data-slotamount="8"
						data-masterspeed="700" data-delay="9400"
						data-thumb="assets/frontend/pages/img/revolutionslider/thumbs/thumb2.jpg">
						<!-- THE MAIN IMAGE IN THE FIRST SLIDE --> <img
						src="assets/frontend/pages/img/revolutionslider/bg9.jpg" alt="">

					</li>
				</ul>
				<div class="tp-bannertimer tp-bottom"></div>
			</div>
		</div>
	</div>
	<!-- END SLIDER -->

	<div class="main">
		<div class="container">
			<!-- BEGIN SERVICE BOX -->
			<div class="row service-box margin-bottom-40">
				<div class="col-md-4 col-sm-4">
					<div class="service-box-heading">
						<em><i class="fa fa-location-arrow blue"></i></em> <span>Multipurpose
							Template</span>
					</div>
					<p>Lorem ipsum dolor sit amet, dolore eiusmod quis tempor
						incididunt ut et dolore Ut veniam unde nostrudlaboris. Sed unde
						omnis iste natus error sit voluptatem.</p>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="service-box-heading">
						<em><i class="fa fa-check red"></i></em> <span>Well
							Documented</span>
					</div>
					<p>Lorem ipsum dolor sit amet, dolore eiusmod quis tempor
						incididunt ut et dolore Ut veniam unde nostrudlaboris. Sed unde
						omnis iste natus error sit voluptatem.</p>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="service-box-heading">
						<em><i class="fa fa-compress green"></i></em> <span>Responsive
							Design</span>
					</div>
					<p>Lorem ipsum dolor sit amet, dolore eiusmod quis tempor
						incididunt ut et dolore Ut veniam unde nostrudlaboris. Sed unde
						omnis iste natus error sit voluptatem.</p>
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