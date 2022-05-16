<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"  />
<style>
	h1 {
		padding: 10px 0 2px 10px;;
		margin-bottom: 8px;
	}
	form {
		width: 80%;
		
	}
	form div {
		width: 50%;
		background-color: black;
		color: white;
		margin-left: 20px;
		display: flex;
		margin: 5px auto;
	}
	form label, form input {
		padding: 8px;
	}
	form label {
		flex: 1;
		width: 30%;
		text-align: right;
	}
	form input {
		flex: 3;
		width: 65%;
		margin-left: 5px;
	}
	form div:nth-of-type(7) {
		justify-content: flex-end;		
	}
	form div:first-of-type div {
		flex:3;
		margin:0px;
	}
	form div:first-of-type input {
		flex: 2;
		margin : 0px;
	}
	form div:first-of-type button {
		flex: 1;
		border: 1px solid transparent;
	}
	form button {
		padding: 15px;
		border: 1px solid #fff;
		background-color: #fff;
		margin-right: auto;
	} 
	
</style>
<!-- 콜백함수가 들어가는 함수로, 함수 선언부가 위쪽이어야 한다. -->
<script src="${rootPath}/static/js/std_input_save.js?ver=2022-05-16-004"></script>
<script src="${rootPath}/static/js/std_input.js?ver=2022-05-16-006"></script>
<h1>학생 정보 등록</h1>
<form method="POST">
	<div>
		<label>학번</label>
		<div>
		<input type = "text" name = "st_num">
		<button type="button" class ="btn-pink std-num-check">중복 검사</button>
		</div>
	</div>
	<div>
		<label>이름</label>
		<input type = "text" name = "st_name">
	</div>
	<div>
		<label>학과</label>
		<input type = "text" name = "st_dept">
	</div>
	<div>
		<label>학년</label>
		<input type = "text" name = "st_grade">
	</div>
	<div>
		<label>전화번호</label>
		<input type = "text" name = "st_tel">
	</div>
	<div>
		<label>주소</label>
		<input type = "text" name = "st_addr">
	</div>
	<div>
		<button type = "button" class="std-save">저장</button>
	</div>
</form>