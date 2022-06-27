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

</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<section class="main">
	<form:form modelAttribute="memoVO" enctype="multipart/form-data" class="w3-container w3-card-4">
		<h3>오늘의 할일</h3>
			<form:input path="m_seq" type="hidden"/>
			<form:input path="m_author" readonly="readonly" type="hidden"/>
			<form:input path="m_memo" 
						class="w3-input w3-border" 
						placeholder="메모를 입력하세요." 
						autofocus="autofocus" 
						required="required" 
						value="${M_MEMO.m_memo}"/>
			<br>
			<input type="file" name="file" accept="images/*"
				   value="${rootPath}/upload/${M_MEMO.m_image}"/>
			<br>
			<br>
			<input type="reset"class="w3-button w3-indigo"> 
			<input type="submit" placeholder="전송" value="저장" class="w3-button w3-amber">
	</form:form>
</section>
</body>
</html>