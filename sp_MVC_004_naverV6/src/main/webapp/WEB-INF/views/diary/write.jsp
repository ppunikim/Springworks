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
<style>
.table {
	display: flex;
	
	
}
.thead {
	
}
</style>
</head>
<body>
	<form method="POST" class="w3-container join w3-card-4">

		<h2>일기장</h2>
		<div class="table">
			<label class="">날짜</label> 
			<input type="date" id="day" placeholder="날짜" class="w3-input w3-border thead "> 
			<label class="">요일</label> 
			<input name="day-week" id="day-week" placeholder="요일" class="w3-input w3-border thead"> 
			<label class="">날씨</label> 
			<input name="weather" id="weather" placeholder="날씨" class="w3-input w3-border thead">
		</div>

		<label class="w3-text-gray">제목</label> <input name="title" id="title" placeholder="제목" class="w3-input w3-border"> 
		<label class="w3-text-gray">내용</label> <input name="content" id="content" placeholder="내용" class="w3-input w3-border">  
		<label class="w3-text-gray">좋았던 일</label> 
		<input name="good1" id="good1" placeholder="Good1" class="w3-input w3-border">
		<input name="good2" id="good2" placeholder="Good2" class="w3-input w3-border">
		<input name="good3" id="good3" placeholder="Good3" class="w3-input w3-border">

		<label class="w3-text-gray">오늘 하루 advice</label> 
		<input name="advice" id="advice" placeholder="오늘 하루 이야기" class="w3-input w3-border">

		<button class="w3-button w3-gray" id="btn_join" type="reset">다시 입력</button>
		<button class="w3-button w3-yellow" id="btn_join" type="button">저장</button>
	</form>

</body>
</html>