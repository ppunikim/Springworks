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
<title>student/list</title>
<style>
</style>
</head>
<body>
	<div class="student body">
		<ul class="student list">
			<li class="student stnum">학번</li>
			<li class="student stname">이름</li>
			<li class="student stdept">학과</li>
			<li class="student sttel">전번</li>
			<li class="student staddr">주소</li>
		</ul>
		<c:forEach items="${STUDENTS}" var="ST">
			<ul class="student list" data-stnum="${ST.st_num}">
				<li class="student stnum">${ST.st_num}</li>
				<li class="student stname">${ST.st_name}</li>
				<li class="student stdept">${ST.st_dept}</li>
				<li class="student sttel">${ST.st_tel}</li>
				<li class="student staddr">${ST.st_addr}</li>
			</ul>
		</c:forEach>
	</div>
</body>
</html>