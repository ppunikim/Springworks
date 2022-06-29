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
	width: 100%;
	height: 100%;
	display: flex;
	align-items: center; 
	flex-direction: column;
}
.hs_div {
	margin-top: 50px;
	justify-content: center;
	line-height: 40px;
}
img {
	width: 300px;
}
</style>
</head>
<body>
	<div class="hs_div">
		<div>작성자: ${book.b_author}</div>
		<div>작성일자: ${book.b_date}</div>
		<div>작성시간: ${book.b_time}</div>
		<div>장르: ${book.b_genre}</div>
		<div>책 제목: ${book.b_title}</div>
		<div>책 내용: ${book.b_content}</div>
		<div>한줄평: ${book.b_eval}</div>
		<div><img src="${rootPath}/upload/${book.b_up_image}"
				alt="${book.b_image}" width="300px">
		</div>
	</div>

	<div class="hs_div">
		<a href="${rootPath}/book/${book.b_seq}/update">수정</a> <a
			href="${rootPath}/book/${book.b_seq}/delete">삭제</a> <a
			href="${rootPath}">홈으로</a>
	</div>
</body>
</html>