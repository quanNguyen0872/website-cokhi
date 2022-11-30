<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add and update product</title>

<!-- import here -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@100;200;300;400;500&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/all.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/grid.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/base.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/menu-vertical.css">

</head>
<body>

	<div class="main">
		<div class="sidebar">
			<jsp:include page="/WEB-INF/include/menu-vertical.jsp" />
		</div>
		<div class="content">
			<div class="grid wide">
				<div class="row">
					<div class="col l-12">
						<h3 style="margin-left:52px;">SAVE PRODUCT</h3>
					</div>
					<div class="col l-12">
						<form:form method="POST" action="saveProduct"
							modelAttribute="product" enctype="multipart/form-data">

							<form:hidden path="id" />
							<table class="styled-table">
								<tbody>
									<tr>
										<td><label>Tên:</label></td>
										<td><form:input path="name" /></td>
									</tr>
									<tr>
										<td><label>Nội dung:</label></td>
										<td><form:textarea path="productContent" /></td>
									</tr>
									<tr>
										<td><label>Tồn kho:</label></td>
										<td><form:input path="inventoryNumber" /></td>
									</tr>
									<tr>
										<td><label>Giá:</label></td>
										<td><form:input path="price" /></td>
									</tr>
									<tr>
										<td><label>Nhà sản xuất:</label></td>
										<td><form:input path="manufacture" /></td>
									</tr>
									<tr>
										<td><label>Loại:</label></td>
										<td><form:select path="categoryName">
												<form:option value="NONE"> --SELECT--</form:option>
												<form:options items="${listOfCategories}"></form:options>
											</form:select></td>
									</tr>
									<tr>
										<td><label>Image:</label></td>
										<td><input type="file" name="file" /></td>
									</tr>
									<tr>
										<td><label></label></td>
										<td><input type="submit" value="Save"
											class="btn btn--add" /></td>
									</tr>
								</tbody>
							</table>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>