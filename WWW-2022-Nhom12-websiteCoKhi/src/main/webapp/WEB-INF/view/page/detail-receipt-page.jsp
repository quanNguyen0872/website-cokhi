<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Receipt</title>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/all.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/grid.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/base.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/responsive.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/home-page.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/manager.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/footer.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/authen-form.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/receipt.css">
</head>
<body>
	<div class=authentication-form">

		<div class="page-header">
			<h1>Bạn đã đặt hàng thành công</h1>
		</div>
		<div style="margin-left: 420px; width: 1200px">
			<div class="row">
				<div class="col l-6 body-main">
					<div class="col l-12">
						<div class="row" style="text-align: center;">
							<div class="col l-4">
								<img class="img" alt=""
									src="http://pngimg.com/uploads/shopping_cart/shopping_cart_PNG59.png" />
							</div>
							<div class="col l-8 text-right"
								style="text-align: left; padding-left: 100px">
								<h4 style="color: #F81D2D;">
									<strong>${order.customer.lastName } ${order.customer.firstName }</strong>
								</h4>
								<p>${order.customer.address }</p>
								<p>${order.customer.phoneNumber }</p>
								<p>${order.customer.email }</p>
							</div>
						</div>
						<div class="row">
							<div class="col l-12" style="text-align: center;">
								<h2>Cơ khí Q&L</h2>
								<h5>0769220162</h5>
							</div>
						</div>
						<div>
							<table class="table">
								<thead>
									<tr>
										<th>
											<h5 style="padding-right: 250px; font-size: 13px">Tên sản phẩm</h5>
										</th>
										<th>
											<h5>Thành tiền</h5>
										</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="tempOrderDetail" items="${orderDetails }">
										<tr>
											<td class="col-md-9">${tempOrderDetail.product.name }</td>
											<td class="col-md-3"><i area-hidden="true">${tempOrderDetail.getUnitPrice() }</i></td>
										</tr>
									</c:forEach>
									<tr style="color: #F81D2D;">
										<td class="text-right">
											<h4>
												<strong>Tổng tiền:</strong>
											</h4>
										</td>
										<td class="text-left">
											<h4>
												<strong><i area-hidden="true"></i>${total }</strong>
											</h4>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="authentication-form__control" style="float: left;margin-top: 0; margin-left: 360px">
			<a href="${pageContext.request.contextPath }/" class="btn">Về trang chủ</a>
		</div>
	</div>

</body>
</html>