<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>api/student</title>
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
nav {
	flex: 1;
	overflow-y: scroll;
}
table {
	height: 500px;
	border: 1px solid black;
}

</style>
</head>
<body>
<header><h3>학생정보</h3></header>
<nav>
	<table>
		<thead>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>전공</th>
				<th>학년</th>
				<th>전번</th>
				<th>주소</th>
				<th>삭제여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${LIST}" var="list">
			<tr>
				<td>${list.st_num}</td>
				<td>${list.st_name}</td>
				<td>${list.st_dept}</td>
				<td>${list.st_grade}</td>
				<td>${list.st_tel}</td>
				<td>${list.st_addr}</td>
				<td><a href="${rootPath}/student/${list.st_num}/delete">삭제</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</nav>
<footer>
	<address>CopyWrite &copy; ppunikim</address>
</footer>
</body>
</html>