<!--Author: Minh Quan-->
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
                    <form:form action="${pageContext.request.contextPath}/register/processCustomerRegistrationForm" modelAttribute="customer">
                        
                        <!-- User name -->
                        <input type="hidden" name="username" value="${crmUser.userName }" />

                        <!-- first name -->
                        <div class="authentication-form__group">
                            <form:input path="firstName" placeholder="first name" class="authentication-form__input" />      
                            <span  class="error-text" ><form:errors path="firstName" cssClass = "error"/></span>
                        </div>

                        <!-- Last name -->
                        <div class="authentication-form__group">
                            <form:input path="lastName" placeholder="last name" class="authentication-form__input" />
                            <span  class="error-text" ><form:errors path="lastName" cssClass = "error"/></span>
                        </div>
                        
                        <!-- email -->
                        <div class="authentication-form__group">
                            <form:input path="email" placeholder="email" class="authentication-form__input" />
                            <span  class="error-text" ><form:errors path="email" cssClass = "error"/></span>
                        </div>
                        
                        <!-- address -->
                        <div  class="authentication-form__group">
                            <form:input path="address" placeholder="address" class="authentication-form__input" />
                            <span  class="error-text" ><form:errors path="address" cssClass = "error"/></span>
                        </div>
                        
                        <!-- phone number -->
                        <div  class="authentication-form__group">
                            <form:input path="phoneNumber" placeholder="phone number" class="authentication-form__input" />
                            <span  class="error-text" ><form:errors path="phoneNumber" cssClass = "error"/></span>
                        </div>
                        
                        <div class="authentication-form__control">
                            <a href="${pageContext.request.contextPath}/register/showRegistrationForm" 
                               class="btn" role="button" aria-pressed="true">Cancel</a>
                            <button type="submit" class="btn btn--primary">Register</button>                 
                        </div>
                        2 / 2
                    </form:form>
		</div>
	</div>
    
    
    
   
    </body>
</html>