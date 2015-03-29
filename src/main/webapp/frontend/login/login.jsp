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
<title>登录</title>

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
		    	<div id="alert">
		    	</div>
		    </div>
			<div class="row margin-bottom-40">
				<!-- BEGIN CONTENT -->
				<div class="col-sm-2"></div>
				<div class="col-md-9 col-sm-9">
					<h1>登录</h1>
					<div class="content-form-page">
						<div class="row">
							<div class="col-md-7 col-sm-7">
								<form class="form-horizontal form-without-legend"
									role="form" id="login_form" method="post">
									
										
									<div class="form-group">
										<label class="col-lg-4 control-label">用户名 <span
											class="require">*</span></label>
										<div class="col-lg-8">
											<input type="text" class="form-control" placeholder="身份证号" name="idCard">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-4 control-label">密码 <span
											class="require">*</span></label>
										<div class="col-lg-8">
											<input type="password" class="form-control" name="password">
										</div>
									</div>
									<div class="row">
										<div class="col-lg-8 col-md-offset-4 padding-left-0">
											<a href="<c:url value="/"/>frontend/forgetPassword">忘记密码?</a>
										</div>
									</div>
									<div class="row">
										<div
											class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
											<button type="submit" class="btn btn-primary">登录</button>
										</div>
									</div>

								</form>
							</div>

						</div>
					</div>
				</div>
				<!-- END CONTENT -->
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
	<script src="../../assets/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="../../assets/global/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<script src="../../assets/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="../../assets/frontend/layout/scripts/back-to-top.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->

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
   <script src="../../assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
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
	<script src="../../static/frontend/js/login.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			Login.init("<c:url value="/"/>");
			Metronic.init();
         });
	</script>
	<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>