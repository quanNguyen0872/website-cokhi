<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Giỏ hàng</title>

<!-- import here -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@100;200;300;400;500&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/grid.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/base.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/responsive.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/cart.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/footer.css">
</head>

<body>
	<div class="wrapper">
		<!-- header -->
        <jsp:include page="/WEB-INF/include/header.jsp" />
		<!-- end header -->

        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="grid wide">
                <div class="row">
                    <div class="col l-12">
                        <!-- title -->
                        <div class="main-content__title">
                            <h1>DANH SÁCH GIỎ HÀNG</h1>
                            <hr/>  
                        </div>
                    </div>
                    <div class="col l-12">
                        <!-- table -->
                        <table class="styled-table">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Hình ảnh</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
                                    <th>TỔNG</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            
                            <tbody class="product-table__body"> 
                            	<% int id = 1 ; %>	
                               	<c:forEach var="tempOrderDetail" items="${orderDetails}">
                            		<c:url var="deleteLink" value="/deleteOrderDetail">
                            			<c:param name="orderId" value="${tempOrderDetail.order.id}"></c:param>
                            			<c:param name="productId" value="${tempOrderDetail.product.id}"></c:param> 
                           		 	</c:url>
                                	 <tr>
                                        <td><%=id++ %></td>
                                    	<td>
                                    		<img src="${pageContext.request.contextPath }/resources/uploads/${tempOrderDetail.product.image}" alt="" width="50px" height="50px" />
                                    	</td>
                                    	<td>${tempOrderDetail.product.name}</td>
                                    	<td>
                                    		<fmt:setLocale value = "vi_VN"/>
											<fmt:formatNumber type = "currency" value = "${tempOrderDetail.product.price}" />
                                    	</td>
                                    	<td>${tempOrderDetail.quantity}</td>
                                    	<td>${tempOrderDetail.getUnitPrice()}</td>
                                    	<td>
                                            <a href="${deleteLink}">Delete</a>                    
                                        </td>
                                	</tr>
                            	</c:forEach>
                            </tbody>
                        </table>
                        
                        <form:form action="sendOrder" method="GET">
             				<input type="text" placeholder="Địa chỉ giao hàng" class="input_dilivery" name="addressDelivery"  />
            				<input type="submit" value="Gửi đơn hàng" class="btn btn--primary" />
        				</form:form>
                        
                    </div>
                </div>
            </div>
        </div>
        
	
		<!-- footer -->
        <jsp:include page="/WEB-INF/include/footer.jsp" />
		<!-- end footer -->
		
		<!-- MODAL  -->
		<jsp:include page="/WEB-INF/include/modal.jsp" />
		<!-- END MODAL  -->
	</div>
</body>

</html>