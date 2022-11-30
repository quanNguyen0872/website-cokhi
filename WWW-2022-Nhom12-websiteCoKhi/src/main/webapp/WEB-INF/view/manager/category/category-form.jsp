<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add and update category</title>

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
		<div class="sidebar">
			<jsp:include page="/WEB-INF/include/menu-vertical.jsp" />
		</div>
		<div class="content">
			<div class="grid wide">
				<div class="row">
					<div class="col l-12">
						<h3>SAVE CATEGORY</h3>
					</div>
					<div class="col l-12">
						<form:form method="POST" action="saveCategoty"
							modelAttribute="category">

							<form:hidden path="id" />
							<table class="styled-table">
								<tbody>
									<tr>
										<td><label>Tên loại:</label></td>
										<td><form:input path="categoryName" /></td>
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