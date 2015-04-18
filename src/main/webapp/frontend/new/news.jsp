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
<title>酒店新闻</title>

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
<style>
.page-content {
	background: #eff3f8;
	padding: 15px 0 15px;
}
</style>
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="corporate page-content">

	<c:import url="/frontend/common/head" />
	<!-- Header END -->



	<div class="main ">
		<div class="container portlet light">
			<div class="row">
				<div class="col-md-7">
					 <div class="page-slider margin-top-10">
						<div class="fullwidthbanner-container revolution-slider">
							<div class="fullwidthabnner">
								<ul id="revolutionul">
									<!-- THE NEW SLIDE -->

									<%-- <c:forEach var="i" items="${img}">
										<li data-transition="fade" data-slotamount="8"
											data-masterspeed="700" data-delay="9400">
											<!-- THE MAIN IMAGE IN THE FIRST SLIDE --> <img src="${i}"
											alt="">
										</li>
									</c:forEach> --%>
									<li data-transition="fade" data-slotamount="8"
											data-masterspeed="700" data-delay="9400">
											<!-- THE MAIN IMAGE IN THE FIRST SLIDE --> <img src="http://localhost:8080/HMS/upload/admin/setting/index_bg/88f9f4cd11.jpg"
											alt="">
									</li>
									<li data-transition="fade" data-slotamount="8"
											data-masterspeed="700" data-delay="9400">
											<!-- THE MAIN IMAGE IN THE FIRST SLIDE --> <img src="http://localhost:8080/HMS/upload/admin/setting/index_bg/88f9f4cd11.jpg"
											alt="">
									</li>
                                </ul>
								<div class="tp-bannertimer tp-bottom"></div>
							</div>
						</div>
					</div> 
					
				</div>
				
				<div class="col-md-3">
					<h2 class="no-top-space">Categories</h2>
                  <ul class="nav sidebar-categories margin-bottom-40">
                    <li><a href="#">London (18)</a></li>
                    <li><a href="#">Moscow (5)</a></li>
                    <li ><a href="#">Paris (12)</a></li>
                    <li><a href="#">Berlin (7)</a></li>
                    <li><a href="#">Istanbul (3)</a></li>
                  </ul>
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
    <script src="../assets/global/plugins/respond.min.js"></script>
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

	<script src="../assets/frontend/layout/scripts/layout.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			Layout.init();
			Layout.initOWL();
			RevosliderInit.initRevoSlider();

		});
	</script>
	<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>