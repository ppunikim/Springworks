<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>memo쓰기</title>
<style>
	.main {
		border: 1px solid black;
	}
</style>
</head>
<body>
<section class="main">
	<form:form modelAttribute="MEMO">
		<h3>오늘의 할일</h3>
			<form:input path="m_author" placeholder="ppuni@naver.com" readonly="readonly"/>
			<form:input path="m_memo" placeholder="메모를 입력하세요." autofocus="autofocus" required="required" />
			<input type="file" accept="*.jpg" />
			<input type="reset">
			<button>저장</button>
	</form:form>
</section>
</body>
</html>