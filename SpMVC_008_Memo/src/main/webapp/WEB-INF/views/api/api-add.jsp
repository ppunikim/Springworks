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
<title>독후감_도서정보 추가</title>
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
	width: 70%;
	text-align: center;
}

input {
	padding: 0.8rem;
	width: 100%;
	margin-bottom: 10px;
}
textarea {
	padding: 1.3rem;
	width: 100%;
}
img {
width:  280px;
margin-bottom: 30px;
} 

</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/function.js?ver=6"></script>
</head>
<body>
	<form method="POST" enctype="multipart/form-data" >
		<input name="b_seq" hidden="hidden" value='<c:out value="${BOOK.b_seq}" default="0" />'>
		<input name="b_author" hidden="hidden"/>
		<input name="b_title" placeholder="책 제목" 
			   value="${BOOK.b_title}" autocomplete="off" required="required"/> 
		<textarea name="b_content" placeholder="책 내용을 입력하세요." 
			    autocomplete="off"  required="required" >${BOOK.b_content}</textarea> 
		<input name="b_genre" placeholder="책 장르" value="${BOOK.b_genre}" 
				autocomplete="off" required="required"/> 
		<input name="b_eval" placeholder="한줄평을 입력하세요." 
				value="${BOOK.b_eval}" autocomplete="off"  required="required"/>
		<input type="file" name="file" accept="images/*" 
		onchange="setThumbnail(event)" multiple
			value="${rootPath}/upload/${BOOK.b_up_image}" />
		<div class="img-box">
		<img src="${rootPath}/upload/${BOOK.b_up_image}"  class="img-img"
		alt="이미지를 등록하세요!"
		onerror="this.onerror=null;this.src='${rootPath}/static/images/add.png'">
		</div>
		<button>저장</button>
	</form>
</body>
</html>