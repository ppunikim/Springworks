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
	width: 250px;
	height: 40px;
}
</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div style="display:flex">
	<div class="w3-ul w3-card-4 w3-margin w3-padding-large hs_div">
		<label class="w3-text-pink w3-margin">음식점이름</label>
		<div class="w3-large w3-border-bottom w3-padding">${VO.MAIN_TITLE}</div>
		<label class="w3-text-pink w3-margin">구 위치</label>
		<div class="w3-large w3-border-bottom w3-padding">${VO.GUGUN_NM}</div>
		<label class="w3-text-pink w3-margin">음식점위치</label>
		<div class="w3-large w3-border-bottom w3-padding">${VO.ADDR1}</div>
		<label class="w3-text-pink w3-margin">전화번호</label>
		<div class="w3-large w3-border-bottom w3-padding">${VO.CNTCT_TEL}</div>
		<label class="w3-text-pink w3-margin">운영시간</label>
		<div class="w3-large w3-border-bottom w3-padding">${VO.USAGE_DAY_WEEK_AND_TIME}</div>
		<label class="w3-text-pink w3-margin">설명</label>
		<div class="w3-large w3-border-bottom w3-padding">${VO.ITEMCNTNTS}</div>
		<div><img src ="${VO.MAIN_IMG_THUMB}" class="w3-padding"></div> 
	</div>
	<a href="${rootPath}/api/api-detail" class="w3-button w3-indigo">이전</a>
</div>
</body>
</html>