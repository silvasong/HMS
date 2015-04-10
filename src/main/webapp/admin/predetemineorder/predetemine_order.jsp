<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<meta charset="utf-8"/>
<title>HMS | 预定订单</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="../../assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="../../assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css">
<link href="../../assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../../assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
<!-- END GLOBAL MANDATORY STYLES -->
<link
	href="../../assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css" />
<!-- BEGIN THEME STYLES -->
<link href="../../assets/global/css/components-rounded.css" id="style_components" rel="stylesheet" type="text/css">
<link href="../../assets/global/css/plugins.css" rel="stylesheet" type="text/css">
<link href="../../assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css">
<link href="../../assets/admin/layout/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color">
<link href="../../assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css">
<!-- END THEME STYLES -->
<!-- <link rel="shortcut icon" href="favicon.ico"/> -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-menu-fixed" class to set the mega menu fixed  -->
<!-- DOC: Apply "page-header-top-fixed" class to set the top menu fixed  -->
<body>
<!-- BEGIN HEADER -->
<c:import url="/admin/common/head"/>
<!-- END HEADER -->
<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
	<!-- BEGIN PAGE HEAD -->
	<div class="page-head">
		<div class="container">
			<!-- BEGIN PAGE TITLE -->
			<div class="page-title">
				<h1>预定管理 <small>预定订单</small></h1>
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
				<li>
					<a href="#">Home</a><i class="fa fa-circle"></i>
				</li>
				<li>
					<a href="layout_blank_page.html">Features</a>
					<i class="fa fa-circle"></i>
				</li>
				<li class="active">
					 Blank Page Layout
				</li>
			</ul>
			<!-- END PAGE BREADCRUMB -->
			<!-- BEGIN PAGE CONTENT INNER -->
			<div class="row">
				<div id="alert"></div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="portlet light">
						<div class="portlet-body">
							<!-- BEGIN SEARCH FORM -->
				<div class="portlet-body">
					<form id="searchForm" name="searchForm" action="adminuserlist1" class="form-horizontal" method="post">
					  
					<div class="row">
									
						<div class="col-md-12">	
							<div class="form-group">
								<label class="col-md-3 control-label">状态</label>
								<div class="col-md-9">
									<div class="radio-list">
										<label class="radio-inline">
										<input type="radio" name="status" value="0" checked/>待确认 </label>
										<label class="radio-inline">
										<input type="radio" name="status" value="2"/>待入住 </label>
										<label class="radio-inline">
										<input type="radio" name="status" value="3"/>已入住 </label>
										<label class="radio-inline">
										<input type="radio" name="status" value="4"/>离店 </label>
										<label class="radio-inline">
										<input type="radio" name="status" value="1"/>取消 </label>
									</div>									
								</div>
							</div>
						</div>
					</div>
				    
					</form>
				</div>
				<!-- END SEARCH FORM -->
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					 <div class="portlet light">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-cogs font-green-sharp"></i> <span
										class="caption-subject font-green-sharp bold uppercase">预定订单</span>
								</div>
								<div class="actions btn-set">
								    <a
										class="btn green-haze btn-circle " data-toggle="modal"
										id="qr_btn">确认 </a>
									<a
										class="btn green-haze btn-circle" data-toggle="modal"
										id="qx_btn">取消 </a>
									<div class="btn-group">

										
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
							</div>
				</div>
			</div>
			
			
			<div class="modal fade" id="qx_modal" tabindex="-1" role="basic"
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
							<button type="button" class="btn blue" id="qx_com">取消</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			
			<div class="modal fade" id="qr_modal" tabindex="-1" role="basic"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">确认订单</h4>
						</div>
						<div class="modal-body">确认选中订单？</div>
						<div class="modal-footer">
							<button type="button" class="btn blue" id="qr_com">确认</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- END PAGE CONTENT INNER -->
		</div>
	</div>
	<!-- END PAGE CONTENT -->
</div>
<!-- END PAGE CONTAINER -->

<!-- BEGIN FOOTER -->
<c:import url="/admin/common/footer"/>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="../../assets/global/plugins/respond.min.js"></script>
<script src="../../assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
<script src="../../assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="../../assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<script
		src="../../assets/global/plugins/datatables/media/js/jquery.dataTables.js"
		type="text/javascript"></script>
	<script
		src="../../assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"
		type="text/javascript"></script>
<script src="../../assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="../../assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="../../assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="../../static/admin/js/predetemine_order.js" type="text/javascript"></script>
<script>
      jQuery(document).ready(function() {    
      Metronic.init(); // init metronic core components
      Layout.init(); // init current layout
      Demo.init(); // init demo features
      PredetemineOrder.init("<c:url value="/"/>");
      });
   </script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>