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
	background-image: url(${rootPath}/static/images/gosim.jpeg);
	background-size: cover;
	background-position: center;
}

#content {
	margin: 20px auto;
	background-color: #ffffffb8;
	border-radius: 40px;
	padding: 10px;
}

header {
	margin-top: 30px;
	width: 70%;
	margin: 10px auto;
	padding: 30px;
	font-weight: 800;
	background-color: #f8f9f6;
	border-radius: 20px;
	border: 4px solid black;
}

#hs_head {
	display: flex;
	justify-content: space-around;
	margin-bottom: 10px;
}

.hs_f {
	font-size: 17px;
	margin: 3px;
}

.hs_b {
	font-weight: 300;
	margin: 10px;
}
#bs_btns {
	margin-top: 40px;
}
header a {
	text-decoration: none;
	font-size: 18px;
	background-color: black;
	color: #fff;
	padding: 10px;
	margin-right: 10px;
}
section {
	flex: 1;
	margin: 0 auto;
}

section a {
	margin: 5px;
	color: #fff;
	text-decoration: none;
	font-weight: 500;
}

footer {
	margin: 0 auto;
}
</style>
</head>
<body>
	<div id="content">
		<h2></h2>
	</div>
	<header>
		<div id="hs_head">
			<p class="hs_f">작성일자</p>
			<p class="hs_b">${D_DIARY.d_date}</p>
			<p class="hs_f">작성시간</p>
			<p class="hs_b">${D_DIARY.d_time}</p>
			<p class="hs_f">날씨</p>
			<p class="hs_b">${D_DIARY.d_weather}</p>
		</div>
		<br>
		<p class="hs_f">제목</p>
		<p class="hs_b">${D_DIARY.d_title}</p>
		<p class="hs_f">내용</p>
		<p class="hs_b">${D_DIARY.d_content}</p>
		<p class="hs_f">아침에 어떤 일 하고싶고, 어떤 의도로 하고싶은가</p>
		<p class="hs_b">${D_DIARY.d_good1}</p>
		<p class="hs_f">낮의 기분 기록</p>
		<p class="hs_b">${D_DIARY.d_good2}</p>
		<p class="hs_f">저녁의 기분 기록</p>
		<p class="hs_b">${D_DIARY.d_good3}</p>
		<p class="hs_f">하루 돌아보기</p>
		<p class="hs_b">${D_DIARY.d_advice}</p>
		<div id="bs_btns">
			<a href="${rootPath}/diary/${D_DIARY.d_seq}/update">수정</a> 
			<a href="${rootPath}/diary/${D_DIARY.d_seq}/delete">삭제</a>
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