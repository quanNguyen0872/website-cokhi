<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- css here  -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/authen-form.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/base.css">

</head>
<body>

	<div class="authentication-form">
		<div class="authentication-form__container">
		
			<!-- Header form-->
			<div class="authentication-form__header">
				<h3 class="authentication-form__heading">Quên mật khẩu</h3>
			</div>
			
			<h3 class="error-text">${error }</h3>

			<!-- Form -->
			<form:form action="processForgotPassword" method="post" class="authentication-form__form">
				<div class="authentication-form__group">
					<input type="text" name="userName"class="authentication-form__input" placeholder="Nhập tên tài khoản của bạn">
				</div>

				<div class="authentication-form__group">
					<input type="email" name="email" class="authentication-form__input" placeholder="Nhập email của bạn">
				</div>

				<!-- authentication-form__group: input submit and input back -->
				<div class="authentication-form__control">
					<a href="${pageContext.request.contextPath }/showMyLoginPage" class="btn">Trở lại</a>
					<input type="submit" class="btn btn--primary" value="GỬI" style="margin-left: 20px">
				</div>
			</form:form>
		</div>
	</div>
	<!-- End login form -->
</body>
</html>