<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>diary 쓰기</title>
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
	display: flex;
	width: 100%;
	height: 100%;
	flex-direction: column;
}
#hs_flex_only {
	display: flex;
	width: 100px;
}
h3 {
	margin: 8px auto;
	font-weight: 800;	
	font-size: 19px;
}
section {
	width: 70%; 
	margin: 55px auto;
	text-align: center;
} 
#hs_flex {
	display:flex;
	flex-direction: column;
}
input {
	padding-left: 6px;
}
textarea{
	height: 100px;
	padding: 7px;
}
form input {
	height: 33px; 
	margin: 5px;
}
.btn {
	background-color: #706c6c;
	color: #fff;
	border-radius: 10px;
	
}
.btn-light {
	background-color: #d4d3d3;
	color: black;
}
.d_inner {
	margin-bottom: 10px;
	color: red;
	margin-left: 5px; 
	text-align: left;
	display: none; 
} 
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/diary_detail.js?ver=9"></script>
</head>
<body>
<section>
	<form:form modelAttribute="diaryVO" >
		<h3>오늘의 일기</h3>
		<br>
		<form:input path="d_date" readonly="true" type="hidden"/>
	<div>
		<label>1. 아침 기록</label>
		<form:select path="d_mor">
	 		<form:option value="bad" label="꿀꿀" />
	 		<form:option value="soso" label="그냥저냥" />
	 		<form:option value="good" label="넘나좋아" />
	 	</form:select>
	 	<form:input path="d_mwrite" placeholder="기분을 글로 표현해보세요."/>
	</div>	
	<div>
		<label>2. 점심 기록</label>
		<form:select path="d_aft">
	 		<form:option value="bad" label="꿀꿀" />
	 		<form:option value="soso" label="그냥저냥" />
	 		<form:option value="good" label="넘나좋아" />
	 	</form:select>
	 	<form:input path="d_awrite" placeholder="기분을 글로 표현해보세요." />
	</div>
	<div>
		<label>3. 저녁 기록</label>
		<form:select path="d_din" lang="지금의 기분">
	 		<form:option value="bad" label="꿀꿀" />
	 		<form:option value="soso" label="그냥저냥" />
	 		<form:option value="good" label="넘나좋아" />
	 	</form:select>
	 	<form:input path="d_dwrite" placeholder="기분을 글로 표현해보세요." />
	</div>
	<div>
		<label>4. 밤: 내일 할일 정리하기</label>
		<form:input path="d_tom" placeholder="내일 할 일을 정리해보세요."/>
	</div>
	<div>
		<label>5. 오늘 하루 가장 좋았던 것 3가지</label>
		<form:input path="d_happy" placeholder="오늘 하루 있었던 일 중, 가장 좋았던 일 3가지를 기록해보세요." value="${D_DIARY.d_happy}"/>
	</div>
	<div>
		<label>하루평가</label>
		<form:select path="d_today">
	 		<form:option value="bad" label="하" />
	 		<form:option value="soso" label="중" />
	 		<form:option value="good" label="상" />
	 	</form:select>
	</div>
	<div>
		<a>리스트로</a>
		<input class="btn btn-light" type="reset"  value="다시쓰기">
		<input class="btn" type="submit" value="저장">
	</div>
	</form:form>
</section>
</body>
</html>