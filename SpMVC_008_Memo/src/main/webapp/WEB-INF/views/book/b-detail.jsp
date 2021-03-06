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
<title>독후감 자세히보기</title>
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
	background-color: #efefef;
	width: 100%;
	height: 100%;
	display: flex;
	align-items: center;
	flex-direction: column;
}

.hs_div {
	margin-top: 50px;
	justify-content: center;
	line-height: 30px;   
	width: 650px;
	display: flex;
	flex-direction: column; 
} 
.hs_head {
	display: flex;
	justify-content: space-around;
}

.hs_div a {
	text-decoration: none;
	color: #544f4f;
	font-weight: 800;
}
.hs_f {
	font-size: 17px;
	margin: 3px;
}

.hs_b {
	border-bottom: 1px solid black;
	font-weight: 300;
	margin: 10px;
	padding: 4px 0;
	margin-left: 20px;  
}
img {
	width: 300px;
}
.btn-neo {
	padding: 30px;
	color: #444;
	font-size: 1rem;
	font-weight: 700;
	outline: none;
	border: none;
	box-shadow: -6px -6px 14px rgba(255, 255, 255, 0.7), -6px -6px 10px
		rgba(255, 255, 255, 0.5), 6px 6px 8px rgba(255, 255, 255, 0.075), 6px
		6px 10px rgba(0, 0, 0, 0.15);
}
.hs_home {
	text-align: center;
}
</style>
</head>
<body>
	<div class="hs_div btn-neo">
		<div class="hs_head">
			<div class="hs_f">작성자</div>
			<div class="hs_b">${book.b_author}</div>
			<div class="hs_f">작성일자</div>
			<div class="hs_b">${book.b_date}</div>
			<div class="hs_f">작성시간</div>
			<div class="hs_b">${book.b_time}</div>
		</div>
			<div class="hs_f">장르</div>
			<div class="hs_b">${book.b_genre}</div>
			<div class="hs_f">책 제목</div>
			<div class="hs_b">${book.b_title}</div>
			<div class="hs_f">책 내용</div>
			<div class="hs_b">${book.b_content}</div>
			<div class="hs_f">한줄평</div>
			<div class="hs_b">${book.b_eval}</div>
		<div>
			<img src="${rootPath}/upload/${book.b_up_image}"
				alt="${book.b_image}" width="300px">
		</div>
		<div class="hs_head">
			<a href="${rootPath}/book/${book.b_seq}/update">수정</a> 
			<a href="${rootPath}/book/${book.b_seq}/delete">삭제</a> 
		</div>
	</div>

	<div class="hs_div">
			<a href="${rootPath}" class="hs_home">홈으로</a>
	</div>
</body>
</html>