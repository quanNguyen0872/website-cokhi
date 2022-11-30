<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login here</title>

<!-- css here  -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/authen-form.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/base.css">

</head>
<body>

	<!-- Login form -->
	<div class="authentication-form">
		<div class="authentication-form__container">
			<!-- Header form-->
			<div class="authentication-form__header">
				<h3 class="authentication-form__heading">Đăng nhập</h3>
			</div>

			<c:if test="${param.error != null }">
				<i class="error-text">Sorry!You entered invalid username/password.</i>
			</c:if>

			<!-- Form -->
			<form:form action="${pageContext.request.contextPath }/authenticateTheUser" method="post" class="authentication-form__form">
				<div class="authentication-form__group">
					<input type="text" name="username"class="authentication-form__input" placeholder="Nhập tên tài khoản của bạn">
				</div>

				<div class="authentication-form__group">
					<input type="password" name="password" class="authentication-form__input" placeholder="Nhập mật khẩu của bạn">
				</div>

				<div class="authentication-form__aside">
					<div class="authentication-form__help">
						<a href="${pageContext.request.contextPath }/showForgotPasswordPage" class="authentication-form__help-link authentication-form__help-forgot">Quên mật khẩu</a>
						<span class="seperate"></span>
						 <a href="${pageContext.request.contextPath }/register/showRegistrationForm" class="authentication-form__help-link">Chưa có tài khoản?</a>
					</div>
				</div>

				<!-- authentication-form__group: input submit and input back -->
				<div class="authentication-form__control">
					<a href="${pageContext.request.contextPath }/" class="btn">Trở lại</a>
					<input type="submit" class="btn btn--primary" value="ĐĂNG NHẬP" style="margin-left: 20px">
				</div>
			</form:form>
		</div>
	</div>
	<!-- End login form -->
</body>
</html>