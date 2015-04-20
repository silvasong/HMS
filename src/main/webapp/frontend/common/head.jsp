<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!-- BEGIN TOP BAR -->
    <div class="pre-header">
        <div class="container">
            <div class="row">
                <!-- BEGIN TOP BAR LEFT PART -->
                <div class="col-md-6 col-sm-6 additional-shop-info">
                    <ul class="list-unstyled list-inline">
                        <li><i class="fa fa-phone"></i><span>${phone}</span></li>
                        <li><i class="fa fa-envelope-o"></i><span>${email}</span></li>
                    </ul>
                </div>
                <!-- END TOP BAR LEFT PART -->
                <!-- BEGIN TOP BAR MENU -->
                <div class="col-md-6 col-sm-6 additional-nav">
                    <ul class="list-unstyled list-inline pull-right">
                        <c:if test="${empty name }">
                        	<li><a href="<c:url value="/"/>frontend/login">登录</a></li>
                            <li><a href="<c:url value="/"/>frontend/signup">注册</a></li>
                        </c:if>
                         <c:if test="${not empty name }">
                        	<li>${name}</li>
                            <li><a href="<c:url value="/"/>frontend/loginout">退出</a></li>
                        </c:if>
                        
                    </ul>
                </div>
                <!-- END TOP BAR MENU -->
            </div>
        </div>        
    </div>
    <!-- END TOP BAR -->
    <!-- BEGIN HEADER -->
    <div class="header">
      <div class="container">
        <a class="site-logo" href="<c:url value="/"/>"><img src="<c:url value="/"/>assets/frontend/layout/img/logos/0logo-blue.png" alt="Metronic FrontEnd"></a>

        <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>

        <!-- BEGIN NAVIGATION -->
        <div class="header-navigation pull-Left font-transform-inherit">
          <ul>
              <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="" data-target="#" href="<c:url value="/"/>">
                          首页 
              </a>
             </li>
             <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="" data-target="#" href="<c:url value="/"/>frontend/online_order">
                 
                          在线预定
              </a>
            </li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="" data-target="#" href="<c:url value="/"/>frontend/personal_center">
                 
                          个人中心
              </a>
            </li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="" data-target="#" href="<c:url value="/"/>frontend/news">
                 
                          酒店新闻
              </a>
            </li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="" data-target="#" href="<c:url value="/"/>frontend/about">
                 
                         关于我们
              </a>
            </li>
            </ul>
        </div>
        <!-- END NAVIGATION -->
      </div>
    </div>