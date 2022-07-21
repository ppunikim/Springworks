<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html {
	width: 100vw;
	height: 100vh;
}

body {
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
	background-color: #f3cabb;
}

nav {
	flex: 1;
	justify-content: center;
	margin: 10px auto;
}

nav div h4 {
	font-size: 20px;
	text-align: center;
	margin: 10px 0;
}

nav div form {
	margin-top: 150px;
	line-height: 30px;
	display: flex;
	flex-direction: column;
	padding: 10px;
	width: 500px;
}

nav div form input {
	padding: 5px;
	border-radius: 10px;
}

nav div form button {
	margin-top: 10px;
	padding: 4px;
	cursor: se-resize;
	background-color: black;
	color: #fff;
	border-radius: 20px;
}

nav div table {
	text-align: center;
}

nav div table tr th, nav div table tr td {
	padding:
}

nav div table tr th {
	font-size: 17.5px;
	padding: 10px 0;
}

nav div table tr th {
	background-color: #f9e4e0;
}

nav div table tr td {
	background-color: #ffefedc9;
	padding: 5px;
}

nav div table tr td a {
	text-decoration: none;
	color: inherit;
}
.block {
	display: none;
	color: tomato;
}
.block, .block2, .block3{
	display: none;
	color: tomato;
}
</style>
<script src="${rootPath}/static/js/insert3.js?20220720_07"></script>
</head>
<body>
	<nav>
		<div>
			<form method="POST" class="join">
				<input name="a_seq" type="hidden"value='<c:out value="${address.a_seq}" default="0" />' /> 
				<label>이름</label>
				<div class="block"> * 이름을 입력하세요. </div>
				<input name="a_name" id="a_name" placeholder="이름 입력해라"value="${address.a_name}" autocomplete="off" autofocus="autofocus" /> 
				<label>전화번호</label> 
				<div class="block2"> * 전화번호를 입력하세요. </div>
				<input name="a_tel"	id="a_tel" placeholder="전화번호 입력해라" value="${address.a_tel}"	autocomplete="off" /> 
				<label>집주소</label> 
				<div class="block3"> * 집주소를 입력하세요. </div>
				<input name="a_address"	id="a_address" placeholder="집주소 입력해라" value="${address.a_address}"autocomplete="off" />
				<button id="btn_join" type="button">저장</button>
			</form>
		</div>
	</nav>
</body>
</html>