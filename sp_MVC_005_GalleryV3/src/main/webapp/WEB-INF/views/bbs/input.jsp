<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>input.jsp</title>
<style>
	form#bbsVO {
		width: 60%;
		margin: 10px auto;
	}
	#bbsVO input, #bbsVO textarea {
		width: 90%;
		margin: 5px auto;
		padding: 8px;
	}
</style>
</head>
<body>
	<!-- 선생님 주석 보기 -->
	<form:form modelAttribute="bbsVO" enctype="multipart/form-data">
	<!-- form tag lib에 있는 form이다. 이것은 3번째 줄에서 가져온 것이다. -->
		<form:input path="b_date" type="hidden"/>
		<form:input path="b_time" type="hidden"/>
		<form:input path="b_writer" type="hidden"/>
		<form:input path="b_subject" placeholder="제목을 입력하세요."/>
		<form:textarea path="b_content" placeholder="내용을 입력하세요."/>
		<input name="up_file" type="file"/>
		<button>작성 완료</button>
	</form:form>
</body>
</html>