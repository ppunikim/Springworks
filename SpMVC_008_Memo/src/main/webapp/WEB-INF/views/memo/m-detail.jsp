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
<title>메모 리스트_자세히보기</title>
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
#content {	
	margin: 20px auto;
}

header {
	width: 500px;
	margin: 10px auto;
	border : 1px solid black; 
	margin: 10px auto;
	padding: 10px;
	font-weight: 800;
	border: 1px solid black;
}
header p {
	font-size: 18px;
}
header div {
	text-align: center;
	margin-top: 5px;
}
header a {
	color: black;
	text-decoration: none;
}
header a:nth-of-type(1){
	margin-right: 10px;
}
header a:hover {
	padding: 4px;
	background-color: #bbb;
}
section {
	flex: 1;
}
section div {
	margin: 0 auto;
}
section a {
	border: 1px solid black;
	margin: 5px;
	color: #fff;
	text-decoration: none;
	background-color: black;
}
.input_memo {
	width: 500px;
	height: 50%; 
	border: 1px solid #ffd2e1;
	padding: 40px;
	background-color:#ffd2e1;
}
img {
	width: 300px;
	margin: 10px 30px;
}

footer {
	margin: 0 auto;
}
</style>
</head>
<body>
	<div id="content">
	</div>
	<header class="input_memo">
		<p>작성일자 : ${M_MEMO.m_date}</p>
		<p>메모 : ${M_MEMO.m_memo}</p>
		<div>
			<img src="${rootPath}/upload/${M_MEMO.m_up_image}"
				 onerror="this.onerror=null; this.style.display='none'">
			<br>
			<a href="${rootPath}/memo/${M_MEMO.m_seq}/update">수정</a> 
			<a href="${rootPath}/memo/${M_MEMO.m_seq}/delete">삭제</a>
		</div>
	</header>
	<section>
		<div>
			<a href="${rootPath}">리스트로</a> 
		</div>
	</section>
	<footer>
		<address>CopyWrite &copy;ppuniKim</address>
	</footer>
</body>
</html>