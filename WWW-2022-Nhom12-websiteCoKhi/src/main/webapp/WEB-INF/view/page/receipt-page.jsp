<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>list receipt</title>

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
	href="${pageContext.request.contextPath }/resources/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/footer.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/recommend.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/authen-form.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/cardProduct.css">
</head>


<body>
	<div class="wrapper">
		<!-- header -->
		<jsp:include page="/WEB-INF/include/header.jsp" />
		<!-- end header -->
		<div class="col l-12">
			<!-- title -->
			<div class="main-content__title" style="margin-top: 200px">
				<h1>Danh sách hóa đơn</h1>
				<hr />

			</div>
		</div>
		<div class="grid wide">
			<div class="row">
				<div class="col l-12" style="margin-top: 20px;">
					<table class="styled-table">
						<thead>
							<tr>
								<th>#</th>
								<th>Ngày đặt hàng</th>
								<th>Tổng tiền</th>
							</tr>
						</thead>
						<tbody>
							<%
							int id = 1;
							%>
							<c:forEach var="tempOrder" items="${orders }">
								<tr>
									<td><%=id++%></td>
									<td>${tempOrder.orderDate }</td>
									<td>${tempOrder.total }</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- footer -->
		<jsp:include page="/WEB-INF/include/footer.jsp" />
		<!-- end footer -->

	</div>
	<!-- END WRAPPER -->

	<!-- MODAL -->
	<jsp:include page="/WEB-INF/include/modal.jsp" />
</body>

</html>