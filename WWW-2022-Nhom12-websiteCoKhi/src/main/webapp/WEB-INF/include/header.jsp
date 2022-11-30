<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<header class="header">
                <!-- HEADER TOPBAR -->
                <div class="header__topbar">
                    <div class="grid wide">
                        <div class="row no-gutters">
                            <div class="col l-4 m-0 c-0 header__topbar-item">
                                <i class="header__topbar-icon fas fa-home"></i>
                                HOME: 12 Nguyễn Văn Bảo P.4 Quận Gò Vấp TP.HCM
                            </div>
    
                            <div class="col l-3 m-0 c-0 header__topbar-item">
                                <i class="header__topbar-icon fas fa-clock"></i>
                                Open Mon-Fri: 6:30AM to 7PM
                            </div>
    
                            <div class="col l-2 m-0 c-0 header__topbar-item" style="text-align: right;">
                                <i class="header__topbar-icon fas fa-envelope"></i>
                                nhom12www@gmail.com
                            </div>
         
                            <c:choose>
  								<c:when test="${pageContext.request.userPrincipal.name != null}">
                            		<div class="col l-3 m-0 c-0 header__topbar-item">
                                		<div class="header__topbar-viewUser">
                                			<a href="${pageContext.request.contextPath }/showInfomationUserPage" class="viewUserBtn">
                            					Tên tài khoản: <security:authentication property="principal.username"/>
                            				</a> /
                            				<i class="header__topbar-icon fas fa-arrow-right"></i>
                            				<a href="#" class="logoutBtn">Logout</a>
                                		</div>
                            		</div>
  								</c:when>
  								<c:otherwise>
  									<div class="col l-3 m-0 c-0 header__topbar-item" style="text-align: right;">
                                		<i class="header__topbar-icon fas fa-arrow-right"></i>
                                		<a href="${pageContext.request.contextPath }/showMyLoginPage" class="loginBtn">Đăng nhập</a>/
                                		<a href="${pageContext.request.contextPath }/register/showRegistrationForm" class="registerBtn">Đăng ký</a>
                            		</div>
  								</c:otherwise>
							</c:choose>
							
							<%-- <security:authorize access="!isAuthenticated()">
  								Login
							</security:authorize>
							<security:authorize access="isAuthenticated()">
  								Logout
							</security:authorize> --%>
                            
                        </div>
                        <!-- END ROW -->
                    </div>
                    
                </div>
                <!-- END HEADER TOPBAR -->

                <!-- HEADER MASTHEAD -->
                <div class="header__masthead">
                    <div class="grid wide">
                        <div class="row header__masthead-list">
                            <div class="col l-3 header__masthead-logo">
                                <a href="${pageContext.request.contextPath}/">
                                    <img src="${pageContext.request.contextPath }/resources/img/logo5.png" alt="logo" width="80" height="80">
                                </a>
                            </div>

                            <div class="col l-3 header__masthead-item">
                                <div class="header__masthead-item-wrap">
                                    <span class="phone-icon"><i class="fas fa-phone-volume"></i></span>
                                    <span style="color: #999; font-size: 1.4rem; font-weight: 400;">Call Us</span>
                                    <a href="tel:076 922 0162" id="tel">076 922 0162</a>
                                </div>
                            </div>

                            <div class="col l-3 header__masthead-item">
                                <div class="header__masthead-item-wrap">
                                    <a href="${pageContext.request.contextPath}/showCartPage" class="header__masthead-cart">
                                        <span >GIỎ HÀNG</span>
                                        <span class="cart-icon"><i class="fas fa-shopping-cart"></i></span>

                                        <!-- <div class="header__masthead-cart-list header__masthead-no-cart">
                                            <span class="text-no-cart">Chưa có sản phẩm trong giỏ hàng</span>
                                        </div> -->
                                    </a>
                                </div>
                            </div>

                            <div class="col l-3 header__masthead-item">
                                    <div class="header__masthead-item-wrap">
                                        <div class="search-wrapper">
                                            <div class="search-icon">
                                                <i class="fas fa-search"></i>                                          
                                            </div>

                                            <div class="search-input-wrapper">
                                                <input type="text" class="search-input" name="search" id="search" placeholder="Tìm kiếm...">   
                                                <a href="#" class="search-input-icon"><i class="fas fa-search"></i></a>                                           
                                            </div>
                                        </div>
                                    </div>
                            </div>
                        </div>
                        <!-- END ROW -->

                    </div>
                </div>
                <!-- END HEADER MASTHEAD -->

                <!-- HEADER NAVBAR -->
                <div class="header__navbar">
                    <div class="grid wide">
                        <div class="row">
                            <ul class="col l-12 header__navbar-list">
                                <li class="header__navbar-item">
                                    <a href="${pageContext.request.contextPath }/" class="header__navbar-link header__navbar-link--primary">TRANG CHỦ</a>
                                </li>

                                <li class="header__navbar-item">
                                    <a href="${pageContext.request.contextPath }/showRecommendPage" class="header__navbar-link">GIỚI THIỆU</a>
                                </li>

                                <li class="header__navbar-item">
                                    <a href="${pageContext.request.contextPath }/showShopPage" class="header__navbar-link">
                                        CỬA HÀNG
                                        <i class="fas fa-chevron-down"></i>
                                    </a>      
                                    
                                    <ul class="header__sub-navbar">
                                        <li class="header__sub-navbar-item">
                                            <a href="${pageContext.request.contextPath}/showCartPage" class="header__sub-navbar-link">Giỏ hàng</a>
                                        </li>
                                        <li class="header__sub-navbar-item">
                                            <a href="${pageContext.request.contextPath }/showReceiptList" class="header__sub-navbar-link">Hóa đơn</a>
                                        </li>
                                    </ul>
                                </li>

                            </ul>
                        </div>
                    </div>
                </div>
                <!-- END HEADER NAVBAR -->
 	</header>