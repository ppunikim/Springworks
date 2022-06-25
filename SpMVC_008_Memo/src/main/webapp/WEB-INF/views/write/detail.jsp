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
<title>리스트_자세히보기</title>
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
}

header {
	border: 1px solid black;
	margin: 10px;
}

section {
	flex: 1;
}

section a {
	border: 1px solid black;
	margin: 5px;
	color: #fff;
	text-decoration: none;
	background-color: black;
}

img {
	width: 500px;
	margin: 10px 30px;
}

footer {
	margin: 0 auto;
}
</style>
</head>
<body>
	<header>
		<p>작성일자 : ${D_MEMO.m_date}</p>
		<p>메모 : ${D_MEMO.m_memo}</p>
		<p><img src="${rootPath}/upload/${D_MEMO.m_image}"></p>
	</header>
	<section>
		<div>
			<a href="${rootPath}">리스트로</a> 
			<a href="${rootPath}/write/${D_MEMO.m_seq}/update">수정</a> 
			<a href="${rootPath}/write/${D_MEMO.m_seq}/delete">삭제</a>
		</div>
	</section>
	<footer>
		<address>CopyWrite &copy;ppuniKim</address>
	</footer>
</body>
</html>