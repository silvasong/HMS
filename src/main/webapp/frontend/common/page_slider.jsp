<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!-- BEGIN SLIDER -->
	<div class="page-slider margin-bottom-40">
		<div class="fullwidthbanner-container revolution-slider">
			<div class="fullwidthabnner">
				<ul id="revolutionul">
					<!-- THE NEW SLIDE -->
					
					<c:forEach var="i" items="${img}">
						<li data-transition="fade" data-slotamount="8" data-masterspeed="700" data-delay="9400">
						<!-- THE MAIN IMAGE IN THE FIRST SLIDE --> <img
						src="${i}" alt="">
					    </li>
					</c:forEach>

					

					
				</ul>
				<div class="tp-bannertimer tp-bottom"></div>
			</div>
		</div>
	</div>
	<!-- END SLIDER -->