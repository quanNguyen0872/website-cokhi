<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>products list</title>
<!-- import here -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@100;200;300;400;500&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/grid.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/base.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/menu-vertical.css">

</head>
<body>

	<div class="main">
		<!-- sidebar -->
		<div class="sidebar">
			<jsp:include page="/WEB-INF/include/menu-vertical.jsp" />
		</div>
		<!-- end sidebar -->


		<div class="content">
			<div class="grid">
				<div class="row">
					<div class="col l-12">
						<input type="button" value="Thêm sản phẩm"
							onclick="window.location.href='showFormForAdd'; return false;"
							class="btn btn--add" style="margin-left: 52px"/>
					</div>

					<div class="col l-12" style="margin-top: 20px;">
						<table class="styled-table">
							<thead>
								<tr>
									<th>#</th>
									<th>Tên</th>
									<th>Nội dung</th>
									<th>Tồn kho</th>
									<th>Giá</th>
									<th>Nhà sản xuất</th>
									<th>Loại sản phẩm</th>
									<th>Hình ảnh</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								int id = 1;
								%>
								<c:forEach var="tempProduct" items="${products }">
									<c:url var="updateLink"
										value="/manager/product/showFormForUpdate">
										<c:param name="productId" value="${tempProduct.id}" />
									</c:url>
									<c:url var="deleteLink" value="/manager/product/delete">
										<c:param name="productId" value="${tempProduct.id}" />
									</c:url>
									<tr>
										<td><%=id++%></td>
										<td>${tempProduct.name }</td>
										<td>${tempProduct.productContent }</td>
										<td>${tempProduct.inventoryNumber }</td>
										<td><fmt:setLocale value="vi_VN" /> <fmt:formatNumber
												type="currency" value="${tempProduct.price}" /></td>
										<td>${tempProduct.manufacture }</td>
										<td>${tempProduct.category.categoryName }</td>
										<td><img
											src="${pageContext.request.contextPath }/resources/uploads/${tempProduct.image}"
											alt="" width="50px" height="50px" /></td>
										<td><a href="${updateLink }">Update</a>|<a
											href="${deleteLink }"
											onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>