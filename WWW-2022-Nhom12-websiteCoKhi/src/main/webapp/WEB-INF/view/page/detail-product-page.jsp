<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>detail product</title>

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
	href="${pageContext.request.contextPath }/resources/css/shop-page.css">
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
						<div class="main-content__title" style="margin-top: 230px">
							<h1>${product.name}</h1>
							<hr />

						</div>
					</div>
					<div class="row" style="margin-left: 200px; width: 700px">

						<div class="col l-6">
							<br>
							<div class="productCardContent__img"
								style="background-image: url('/WWW-2022-Nhom12-websiteCoKhi/resources/uploads/${product.image}');">
							</div>
						</div>
						<!-- Form -->
						<div class="col l-6">
							<form:form action="saveOrderDetail" method="post"
								class="authentication-form__form" modelAttribute="product">
								<input type="hidden" name="productId" value="${product.id }">
								<div class="col l-12 textRecommendStudent "
									style="margin-top: 50px; text-align: justify; padding-right: 20px; font-size: 15px">
									<p>Công dụng sản phẩm: ${product.productContent}</p>
									<p>Giá thành: ${product.price}</p>
									<p>Nhà sản xuất: ${product.manufacture}</p>
									<p>Loại sản phẩm: ${product.category.categoryName}</p>
									<div class="authentication-form__control" style="display: flex; flex-direction: row; justify-content: center;">
										<a href="${pageContext.request.contextPath }/showShopPage" class="btn" >Back</a>
										<input class="btn btn--primary productCardContent__button" value="Add to Cart" type="submit" />
									</div>
								</div>
							</form:form>
						</div>

					</div>
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