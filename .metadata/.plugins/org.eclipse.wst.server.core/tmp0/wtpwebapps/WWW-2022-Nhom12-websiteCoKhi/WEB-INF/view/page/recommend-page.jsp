<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>website bán đồ cơ khí</title>

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
	href="${pageContext.request.contextPath }/resources/css/recomment.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/authen-form.css">
</head>

<body>
	<div class="wrapper">
		<!-- header -->
		<jsp:include page="/WEB-INF/include/header.jsp" />
		<!-- end header -->
		<div class="content">
			<!-- SLIDER -->
			<div class="grid">
				<div class="container-fluid textRecomment">
					<i>Chào bạn, chúng tôi là Q&L Store!</i>
					<p class="textRecomment explore">
						EXPLORE <br> <br> &#8595;
					</p>
				</div>

			</div>
			<div class="grid" style="margin-top: 50px">
				<div class="row no-gutters">
					<div class="col l-6">
						<br> <img class="imgMatTien"
							src="${pageContext.request.contextPath }/resources/img/mat_tien_nha_E_2021.jpg"
							alt="">
					</div>
					<div class="col l-6 textRecommentStudent "
						style="margin-top: 50px;">
						<p>CHÚNG TÔI LÀ 3 THÀNH VIÊN NHÓM 12 MÔN LẬP TRÌNH WWW</p>
						<div class="row no-gutters">
							<div class="col l-12">
								<p>Thành Viên thứ 1: Đoàn Thị Mỹ Linh</p>
								<p>Thành Viên thứ 2: La Võ Minh Quân</p>
								<p>Thành Viên thứ 3: Nguyễn Hồng Quân</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="grid" style="margin-top: 50px">
				<div class="row no-gutters">
					<div class="col l-6 textRecommentStudent ">
						<p>SỨ MỆNH</p>
						<div class="row">
							<div class="col l-10 suMenh">
								<p>Giúp khách hàng mua hàng một cách nhanh chóng, tiện lợi
									và an toàn nhất. Những sản phẩm được bán trên website
									là những sản phẩm của các thương hiệu nổi tiếng trên
									thế giới và của Việt Nam. Cùng với hàng nghìn sản phẩm chất
									lượng khác với giá tốt nhất. Tất cả các sản phẩm được bán trên
									Q&L được kiểm tra chặt chẽ từ xuất xứ đến chất lượng nên
									bạn hoàn toàn yên tâm khi mua sắm. Một điều mà Q&L luôn tâm
									đắc đó là sản phẩm bán trên website tuyệt đối không ảnh hưởng
									sức khỏe của khách hàng. Triết lý kinh doanh và đạo đức của
									người lãnh đạo luôn đặt quyền lợi của khách hàng lên trên hết.</p>
							</div>
						</div>
					</div>
					<div class="col l-6">
						<br> <img class="imgSuMenh"
							src="${pageContext.request.contextPath }/resources/img/sumenh.jpg"
							alt="">
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