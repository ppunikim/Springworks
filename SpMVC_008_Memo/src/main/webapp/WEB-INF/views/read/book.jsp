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
	justify-content: center;
	align-items: center;
}

form {
	width: 50%;
	text-align: center;
}

input {
	padding: 1rem;
	width: 100%;
}
</style>
</head>
<body>
	<form method="POST" enctype="multipart/form-data" >
		<input name="b_seq" hidden="hidden" value='<c:out value="${BOOK.b_seq}" default="0" />'>
		<input name="b_author" hidden="hidden"/>
		<input name="b_title" placeholder="책 제목" value="${BOOK.b_title}"/> 
		<input name="b_content" placeholder="책 내용을 입력하세요." value="${BOOK.b_content}"/> 
		<input name="b_genre" placeholder="책 장르" value="${BOOK.b_genre}"/> 
		<input name="b_eval" placeholder="한줄평을 입력하세요." value="${BOOK.b_eval}"/>
		<input type="file" name="file" accept="images/*" />
		<button>저장</button>
	</form>
</body>
</html>