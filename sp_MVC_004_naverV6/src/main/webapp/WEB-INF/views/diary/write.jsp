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
<title>일기 쓰는 공간</title>
</head>
<body>
<form method="POST" class="w3-container join w3-card-4">

	<h2>일기장</h2>
	<label class="w3-text-gray">날짜</label>
	<input type="date" id="day" placeholder="날짜" class="w3-input w3-border">
	<label class="w3-text-gray">요일</label>
	<input name="day-week" id="day-week" placeholder="요일" class="w3-input w3-border">
	<label class="w3-text-gray">날씨</label>
	<input name="weather" id="weather" placeholder="날씨" class="w3-input w3-border">

	<label class="w3-text-gray">제목</label>
	<input name="email" id="email" placeholder="EMAIL" class="w3-input w3-border">
	<label class="w3-text-gray">내용</label>
	<input name="name" id="name" placeholder="NAME" class="w3-input w3-border">

	<label class="w3-text-gray">좋았던 일 1</label>
	<input name="nickname" id="nickname" placeholder="NICKNAME" class="w3-input w3-border">
	<label class="w3-text-gray">좋았던 일 2</label>
	<input name="nickname" id="nickname" placeholder="NICKNAME" class="w3-input w3-border">
	<label class="w3-text-gray">좋았던 일 3</label>
	<input name="nickname" id="nickname" placeholder="NICKNAME" class="w3-input w3-border">
	
	<label class="w3-text-gray">오늘 하루 advice</label>
	<input name="nickname" id="nickname" placeholder="NICKNAME" class="w3-input w3-border">
	
	<button class="w3-button w3-yellow" id="btn_join" type="button" >입력</button>
</form>

</body>
</html>