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
	width: 80%;
	height: 100%;
	display: flex;
	flex-direction: column;
}
a {
	text-decoration: none;
	margin-top: 20px;
}
</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div style="display:flex">
	<div class="w3-ul w3-card-4 w3-margin w3-padding-large hs_div">
		<label class="">음식점이름</label>
		<div class="w3-large">${VO.MAIN_TITLE}</div>
		<label>구 위치</label>
		<div class="w3-large">${VO.GUGUN_NM}</div>
		<label>음식점위치</label>
		<div class="w3-large">${VO.ADDR1}</div>
		<label>전화번호</label>
		<div class="w3-large">${VO.CNTCT_TEL}</div>
		<label>운영시간</label>
		<div class="w3-large">${VO.USAGE_DAY_WEEK_AND_TIME}</div>
		<label>설명</label>
		<div class="w3-large">${VO.ITEMCNTNTS}</div>
		<div><img src ="${VO.MAIN_IMG_THUMB}" ></div>
	</div>
	<a href="${rootPath}/api/api-detail">이전</a>
</div>
</body>
</html>