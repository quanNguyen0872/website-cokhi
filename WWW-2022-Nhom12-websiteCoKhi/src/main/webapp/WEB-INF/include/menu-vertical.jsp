<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<div class="menu">
			<ul>
				<li>
					<a href="${pageContext.request.contextPath }/manager/product/list">Sản phẩm</a>
					
					<ul class="sub-menu">
						<li>
							<a href="${pageContext.request.contextPath }/manager/product/list"">Danh sách sản phẩm</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/manager/product/showFormForAdd">Thêm sản phẩm</a>
						</li>
					</ul>
					<!-- end sub menu  -->	
				</li>
				<!-- end menu item -->
				
				<li>
					<a href="${pageContext.request.contextPath }/manager/category/list"">Loại sản phẩm</a>
					
					<ul class="sub-menu">
						<li>
							<a href="${pageContext.request.contextPath }/manager/category/list">Danh sách loại sản phẩm</a></li>
						<li>
							<a href="${pageContext.request.contextPath }/manager/category/showFormForAdd">Thêm loại sản phẩm</a>
						</li>
					</ul>	
					<!-- end sub menu  -->	
				</li>
				<!-- end menu item -->
			</ul>
			<!-- end menu -->
			
			<form:form action="${pageContext.request.contextPath }/logout" method="POST">
				<input type="submit" value="Đăng xuất" class="btn">
			</form:form>
		</div>