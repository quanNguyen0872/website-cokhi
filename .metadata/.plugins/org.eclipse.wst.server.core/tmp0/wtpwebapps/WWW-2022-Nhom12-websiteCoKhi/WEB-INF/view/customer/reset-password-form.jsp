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
<title>change password</title>

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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/information-user.css">
</head>

<body>
	<div class="wrapper">
		<!-- header -->
		<jsp:include page="/WEB-INF/include/header.jsp" />
		<!-- end header -->
		<div class="main-content">
			<div class="grid wide">
				<div class="row">
					<div class="col l-12">
						<!-- title -->
						<div class="main-content__title" style="margin-top: 200px">
							<h1>NHẬP LẠI MẬT KHẨU</h1>
							<hr />
						</div>
					</div>
					
					<div class="col l-12">
						<p class="error-text">${error }</p>
					</div>
					
					<div class="col l-12">
						<div class="col l-8"
							style="text-align: center; margin-left: 230px">
							<div class="card user-card-full">
								<div class="row">
									<div class="card-block">
										<div class="row">
											<form:form action="processResetPassword" method="post">
												<div class="col l-12" style="margin-left: 200px">
													<p class="f-w-600 inputContain">
														<label class="labelInput">Mật khẩu mới</label> 
														<input type="password" name="password" class="form-control" placeholder="Nhập mật khẩu mới" />
													</p>
													<p class="f-w-600 inputContain">
														<label class="labelInput">Nhập lại mật khẩu</label>
														<input type="password" name="repeatPassword"class="form-control" placeholder="Nhập lại mật khẩu" />
													</p>
												</div>
												<a style="margin-left: 250px" href="${pageContext.request.contextPath }/showInfomationUserPage" class="btn">TRỞ LẠI</a>
												<input style="margin-left: 10px" type="submit" class="btn btn--primary" value="XÁC NHẬN">
											</form:form>
										</div>
									</div>
								</div>
							</div>
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