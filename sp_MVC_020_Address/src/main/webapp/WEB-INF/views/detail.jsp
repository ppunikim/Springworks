<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>detail</title>
<style>
	* {
		box-sizing: border-box;
		margin:0;
		padding:0;
	}
	html {
		width:100vw;
		height:100vh; 
	}
	body {
		width:100%;
		height:100%;
		display:flex;
		flex-direction: column;
	}
	header div {
		display: flex;
		justify-content: center;
		margin-top: 100px;
	}
	header div label {
		padding: 10px;
		background-color: #eee;
	}
	header div p {
		padding: 10px;
		
	}
</style>
</head>
<body>
<% // detail은 한 사람의 데이터이기 때문에 controller의 model값을 그냥 가져오면 된다. %>
	<header>
		<div>
			<label>번호</label>
			<p>${address.a_seq}</p>
			<label>이름</label>
			<p>${address.a_name}</p>
			<label>전화번호</label>
			<p>${address.a_tel}</p>
			<label>주소</label>
			<p>${address.a_address}</p>
		</div>
	</header>
	<section>
		<div>
			<a href="${rootPath}/update?seq=${address.a_seq}">수정</a>
			<a href="${rootPath}/delete?seq=${address.a_seq}">삭제</a>
		</div>
	</section>
</body>
</html>