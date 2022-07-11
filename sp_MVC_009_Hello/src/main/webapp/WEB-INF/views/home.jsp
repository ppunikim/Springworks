<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"  />
<%
/*

*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>home.jsp</title>
</head>
<body>
<h3>${ppuni}</h3>
<%/* controller에서 data를 담아 보낼 때 사용하는 것은, model.addAttribute이다. */%>

<form method="POST" action="${rootPath}/">
	<input name="puppy" placeholder="강아지 이름"/>
	<input name="age" placeholder="강아지 나이"/>
	<button>전송!</button>
</form>
</body>
</html>