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
	form div:first-of-type input {
		flex: 2;
		margin-rigth: 10px;
	}
	form div:first-of-type button {
		flex: 1;
		border: 1px solid transparent;
	}
	form button {
		padding: 16px;
		border: 1px solid #fff;
		background-color: #fff;
	}
	
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/std_input.js?ver=2022-05-10-013"></script>
<h1>학생 정보 등록</h1>
<form method="POST">
	<div>
		<label>학번</label>
		<input type = "text" name = "st_num">
		<button type="button" class ="btn-pink std-num-check">중복 검사</button>
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