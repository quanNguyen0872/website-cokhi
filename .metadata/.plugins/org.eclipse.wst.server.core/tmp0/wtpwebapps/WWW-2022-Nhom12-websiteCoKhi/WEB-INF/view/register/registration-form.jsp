<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

    <head>

        <title>Register New User Form</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Reference Bootstrap files -->
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

        <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <c:url var="pattern" value="/resources/img/bg.jpg" />
        <style>
            *{ margin: 0px auto; padding: 0px; }
            body{ 
                background-image: url(${pattern}); 
            }
        </style>
        <!-- css here  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@100;200;300;400;500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/all.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/authen-form.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/base.css">
    </head>

    <body>
    
    
    <!-- register form -->
	<div class="authentication-form">
		<div class="authentication-form__container">
			<!-- Header form-->
			<div class="authentication-form__header">
				<h3 class="authentication-form__heading">Đăng ký</h3>
			</div>

			<!-- Form -->
			<!-- Registration Form -->
                    <form:form action="${pageContext.request.contextPath}/register/processRegistrationForm" modelAttribute="crmUser">
                        <!-- Place for messages: error, alert etc ... -->
                        <div class="authentication-form__group">
   							<!-- Check for registration error -->
                               <c:if test="${registrationError != null}">
                                     <div class="error-text">
                                          ${registrationError}
                                     </div>
                              </c:if>
                        </div>

                        <!-- User name -->
                        <div class="authentication-form__group">          
                            <form:input path="userName" placeholder="username" class="authentication-form__input" />
                        </div>

                        <!-- Password -->
                        <div class="authentication-form__group">
                            <form:password path="password" placeholder="password" class="authentication-form__input" />
                        </div>
                        <div class="authentication-form__control">
                            <a href="${pageContext.request.contextPath}/" class="btn" role="button" aria-pressed="true" style="margin-right: 5px;">Cancel</a>
                            <button type="submit" class="btn btn--primary">Next</button>                 
                        </div>
                        1 / 2
                    </form:form>
		</div>
	</div>
    
    
    

      
    </body>
</html>