<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cua Hang</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@100;200;300;400;500&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/all.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/grid.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/base.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/shop-page.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/footer.css">

</head>
<body>
	<div class="wrapper">
		<!-- header -->
		<jsp:include page="/WEB-INF/include/header.jsp" />
		<!-- end header -->

		<div class="content">
			<div class="grid wide">
				<div class="row">
					<c:forEach var="tempProduct" items="${products}">					
						<div class="col l-4">
							<div class="product-container">
								<form:form action="saveOrderDetail" method="POST">
									<c:url var="showProductDetail" value="/showProductDetail">
										<c:param name="productId" value="${tempProduct.id}"/>
									</c:url>
									<a href="${showProductDetail}" class="productCardContent">
										<input type="hidden" name="productId" value="${tempProduct.id}" />
										<div class="productCardContent__img" style="background-image: url('/WWW-2022-Nhom12-websiteCoKhi/resources/uploads/${tempProduct.image}');"></div>
										<%-- <img class = "productCardContent__img" src="${pageContext.request.contextPath }/resources/uploads/${tempProduct.image}" alt="" /> --%>
										<h1 class="productCardContent__name">${tempProduct.name}</h1>
										<p class="productCardContent__price">
											<fmt:setLocale value = "vi_VN"/>
											<fmt:formatNumber type = "currency" value = "${tempProduct.price}" />
										</p>
										<p class="productCardContent__content">${tempProduct.productContent}</p> 														
										<div class="productCardContent__button-wrapper">
											<input class="btn btn--primary productCardContent__button" value="Add to Cart" type="submit" />
										</div>
									</a>
								</form:form>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>
		</div>
		
		<!-- header -->
		<jsp:include page="/WEB-INF/include/footer.jsp" />
		<!-- end header -->
		
		<!-- MODAL -->
    	<jsp:include page="/WEB-INF/include/modal.jsp" />
		
	</div>
</body>
</html>