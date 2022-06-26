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
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
}

</style>
</head>
<body>
<section>
	<form:form modelAttribute="diaryVO" >
		<h3>오늘의 일기</h3>
		<form:input path="d_seq" type="hidden"/>
		<form:input path="d_author" type="hidden"/>
		<form:input path="d_date" readonly="readonly"/>
		<form:input path="d_time" type="hidden"/>
		<form:input path="d_weather" placeholder="오늘의 날씨" autofocus="autofocus" />
		<label>제목</label>
		<form:input path="d_title" placeholder="제목을 입력하세요." required="required"/>
		<label>내용</label>
		<form:input path="d_content" placeholder="내용을 입력하세요." required="required"/>
		<label>아침에는 어떤 일을 하고싶고, 어떤 의도를 가지고 싶은가?</label>
		<form:input path="d_good1" placeholder="아침 기록"/>
		<label>낮 지금 나의 기분</label>
		<form:input path="d_good2" placeholder="낮 기분 기록"/>
		<label>저녁 지금 나의 기분</label>
		<form:input path="d_good3" placeholder="저녁 기분 기록"/>
		<label>밤: 뭐가 제일 좋았는지, 나에게 해주고 싶은 말</label>
		<form:input path="d_advice" placeholder="하루 돌아보기"/>
		<input type="reset"  value="다시쓰기">
		<input type="submit" value="저장">
	</form:form>
</section>
</body>
</html>

