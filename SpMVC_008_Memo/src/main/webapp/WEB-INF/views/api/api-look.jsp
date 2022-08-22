<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>api-look</title>
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
<c:forEach items="VO" var="vo">
	<div>음식점이름 : ${vo.MAIN_TITLE}</div>
	<div>구 위치 : ${vo.GUGUN_NM}</div>
	<div>음식점위치 : ${vo.ADDR1}</div>
	<div>전화번호 : ${vo.CNTCT_TEL}</div>
	<div>운영시간 : ${vo.USAGE_DAY_WEEK_AND_TIME}</div>
	<div>설명 : ${vo.ITEMCNTNTS}</div>
	<div><img src ="${vo.MAIN_IMG_THUMB}"></div>
</c:forEach>
</body>
</html>