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
<title>input.jsp</title>
<style>
	form.bbs_write {
		width: 80%;
		margin: 10px auto;
	}
	form.bbs_write h2, form.bbs_write input, form.bbs_write textarea {
		width: 90%;
		margin: 5px auto;
		padding: 8px;
	}
</style>
</head>
<body>
	<form method="POST" class="bbs_write">
		<h2>햇살이의 게시판 글쓰기</h2>
		<input name="b_date" type="date" value="${BBS.b_date}" >  
		<input name="b_time" type="time" value="${BBS.b_time}" > 
		<input name="b_writer" placeholder="작성자" value="${BBS.b_writer}" readonly="readonly">
		<input name="b_subject" placeholder="제목">
		<textarea rows="5" cols="20" name="b_content" placeholder="내용"></textarea>
		<input type="file" name="file" accept="image/*">
		<button>저장</button>
	</form>
</body>
</html>