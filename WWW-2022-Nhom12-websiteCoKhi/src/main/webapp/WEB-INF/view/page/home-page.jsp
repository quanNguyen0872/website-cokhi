<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>website bán đồ cơ khí </title>

    <!-- import here -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@100;200;300;400;500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
    integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/grid.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/responsive.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/home-page.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/authen-form.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/shop-page.css">
</head>
<body>
    <div class="wrapper">
    	<!-- header -->
        <jsp:include page="/WEB-INF/include/header.jsp" />  
		<!-- end header -->
		
        <div class="h-content">
            <!-- SLIDER -->
            <div class="grid">
                <div class="slider">
                
                </div>
            </div>
            <!-- END SLIDER -->
            <%int i = 0;%>
            <div class="grid wide">
					<div class="row">
						<c:forEach var="tempProduct" items="${products}">
							<%request.setAttribute("i", i++);%>				
							<c:if test="${i lt 3}">
								<div class="col l-4">
									<div class="product-container">
										<c:url var="showProductDetail" value="/showProductDetail">
											<c:param name="productId" value="${tempProduct.id}"/>
										</c:url>
										<a href="${showProductDetail}" class="productCardContent">
											<%-- <input type="hidden" name="productId" value="${tempProduct.id}" /> --%>
											<div class="productCardContent__img" style="background-image: url('/WWW-2022-Nhom12-websiteCoKhi/resources/uploads/${tempProduct.image}');"></div>
											<h1 class="productCardContent__name">${tempProduct.name}</h1>
											<p class="productCardContent__price">
												<fmt:setLocale value = "vi_VN"/>
												<fmt:formatNumber type = "currency" value = "${tempProduct.price}" />
											</p>
											<p class="productCardContent__content">${tempProduct.productContent}</p> 														
										</a>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>

            <h3 style="text-align:center;font-size:4rem;line-height:4rem;color:#4f4a4a;">Sản phẩm hiện tại</h3>

            <div class="content-section">
            <%int j = 0;%>
                <div class="grid wide">
					<div class="row">
						<c:forEach var="tempProduct" items="${products}">
							<%request.setAttribute("j", j++);%>				
							<c:if test="${j lt 8}">
								<div class="col l-3">
									<div class="product-container">
										<c:url var="showProductDetail" value="/showProductDetail">
											<c:param name="productId" value="${tempProduct.id}"/>
										</c:url>
										<a href="${showProductDetail}" class="productCardContent">
											<%-- <input type="hidden" name="productId" value="${tempProduct.id}" /> --%>
											<div class="productCardContent__img" style="background-image: url('/WWW-2022-Nhom12-websiteCoKhi/resources/uploads/${tempProduct.image}');"></div>
											<h1 class="productCardContent__name">${tempProduct.name}</h1>
											<p class="productCardContent__price">
												<fmt:setLocale value = "vi_VN"/>
												<fmt:formatNumber type = "currency" value = "${tempProduct.price}" />
											</p>
											<p class="productCardContent__content">${tempProduct.productContent}</p> 														
										</a>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
            </div>

        </div>
        
        <!-- footer -->
        <jsp:include page="/WEB-INF/include/footer.jsp" />
		<!-- end footer -->
        
    </div>
    <!-- END WRAPPER -->
    
    <security:authorize access="hasRole('MANAGER')">
    	<c:redirect url = "/manager/product/list"/>
	</security:authorize>

    <!-- MODAL -->
    <jsp:include page="/WEB-INF/include/modal.jsp" />  
</body>
</html>