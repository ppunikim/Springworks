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
<title>일기 자세히보기</title>
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
	width: 70%; 
	border : 1px solid black;
	margin: 10px auto;
	padding: 10px;
	font-weight: 800;
	border: 1px solid black;
}
#hs_head {
	display: flex;
	justify-content: space-around; 
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
		<h2>다이어리</h2>
	</div>
	<header>
	<div id="hs_head">
		<p>작성일자<br> ${D_DIARY.d_date}</p>
		<p>작성시간 <br> ${D_DIARY.d_time}</p>
		<p>날씨<br> ${D_DIARY.d_weather}</p>
	</div>
	<br>
		<p>제목 :  ${D_DIARY.d_title}</p>
		<p>내용 :  ${D_DIARY.d_content}</p>
	<br>
		<p>아침에 어떤 일 하고싶고, 어떤 의도로 하고싶은가<br>${D_DIARY.d_good1}</p>
	<br>
		<p>낮의 기분 기록 <br> ${D_DIARY.d_good2}</p>
	<br>
		<p>저녁의 기분 기록 <br> ${D_DIARY.d_good3}</p>
	<br>	 
		<p>하루 돌아보기 <br> ${D_DIARY.d_advice}</p>
	<br>
		<div>
			<a href="${rootPath}/record/${D_DIARY.d_seq}/update">수정</a> 
			<a href="${rootPath}/record/${D_DIARY.d_seq}/delete">삭제</a>
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