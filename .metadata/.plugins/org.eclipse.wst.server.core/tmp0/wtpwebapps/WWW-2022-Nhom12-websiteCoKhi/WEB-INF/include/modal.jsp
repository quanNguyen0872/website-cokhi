<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal">
	<div class="modal__overlay"></div>

	<div class="modal__body js-modalContainer">
		<!-- logout confirm  -->
		<div style="width: 400px;padding:20px;">
			<form:form action="${pageContext.request.contextPath }/logout" method="POST">
				<p align="center">Bạn có chắc muốn đăng xuất?</p>
				
				<div style="display: flex; margin-top:10px; justify-content: center; ">
					<a href="#" class="btn cancelBtn">Không</a>
					<input type="submit" value="Đăng xuất" class="btn btn--primary">
				</div>
			</form:form>
		</div>
	</div>
</div>
<!-- END MODAL -->

<script>
        const btnLogout = document.querySelector('.logoutBtn');
        const modalConstainer = document.querySelector('.js-modalContainer');

        // add event click listener for btnLogin when
        // click on btnLogin, show modal
        btnLogout.addEventListener('click', () => {
            const modal = document.querySelector('.modal');
            modal.classList.add('modal--show');
        });

        //close modal when click  modal__overlay
        const modalOverlay = document.querySelector('.modal__overlay');
        modalOverlay.addEventListener('click', () => {
            const modal = document.querySelector('.modal');
            modal.classList.remove('modal--show');
        });
        
        const btnCancel = document.querySelector('.cancelBtn');
        btnCancel.addEventListener('click', () => {
            const modal = document.querySelector('.modal');
            modal.classList.remove('modal--show');
        })
    </script>