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
		<div id="hs_flex">
		<form:input path="d_seq" type="hidden" />
		<div id="hs_flex_only">
			<form:input path="d_author"  value="${D_DIARY.d_author}" readonly="true"/>
			<form:input path="d_date" readonly="true"/>
			<form:input path="d_time" type="hidden"/>
			<form:input path="d_weather" placeholder="오늘의 날씨" autofocus="autofocus" 
					  	maxlength="8" value="${D_DIARY.d_weather}"/>
		</div>
		<div class="d_inner"> * 8자 이하로 작성하세요. </div>
		<label>제목</label>
		<form:input path="d_title" placeholder="제목을 입력하세요." required="required"
					value="${D_DIARY.d_title}"/>
		<label>내용</label>
		<textarea name="d_content" placeholder="내용을 입력하세요." required="required">${D_DIARY.d_content}</textarea>
		<label>아침에는 어떤 일을 하고싶고, 어떤 의도를 가지고 싶은가?</label>
		<form:input path="d_good1" placeholder="아침 기록" value="${D_DIARY.d_good1}"/>
		<label>낮의 기분</label>
		<form:input path="d_good2" placeholder="낮 기분 기록" value="${D_DIARY.d_good2}"/>
		<label>저녁 기분</label>
		<form:input path="d_good3" placeholder="저녁 기분 기록" value="${D_DIARY.d_good3}"/>
		<label>밤: 뭐가 제일 좋았는지, 나에게 해주고 싶은 말</label>
		<form:input path="d_advice" placeholder="하루 돌아보기" value="${D_DIARY.d_advice}"/>
		<input class="btn btn-light" type="reset"  value="다시쓰기">
		<input class="btn" type="submit" value="저장">
	</div>
	</form:form>
</section>
</body>
</html>

