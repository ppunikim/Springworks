<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>독후감 자세히보기</title>
<style>
table tr td {
	cursor: pointer;
}
.hs_scroll{
	overflow-y: scroll;
	height: 500px;
}
label {
}
.hs_how {
	display: flex;
}
</style>
<link rel="stylesheet" href="${rootPath}/static/css/api.css?ver=002" />
<link rel="stylesheet" href="${rootPath}/static/css/modal.css?ver=002" />
<script>
	const rootPath= '${rootPath}'
</script>
<script src="${rootPath}/static/js/api.js?ver=006"></script>
</head>
<body>
<!-- 구현하고자 하는 것 
 	1. 한줄 클릭하면 modal box 로 그 라인만 크게 보이게 하는 것, (detail)설명란 추가
 	2. pageNation 구현하기
 -->
	<header>
		<form:form>
			<select name="cat">
				<option value="Place">장소검색</option>
				<option value="Food">음식검색</option>
			</select>
			<input name="search" placeholder="검색어를 입력하세요." />
			<button>검색</button>
		</form:form>
	</header>
	<nav >
		<div class="hs_how">
			<c:forEach items="${RANDOM}" var="random">
				<label for="this"><a href="${rootPath}/api/${UC_SEQ}/api-look" ></a></label>
				<div><img src="${random.MAIN_IMG_THUMB}" id="this"/></div>
			</c:forEach>
		</div>
		<div class="hs_scroll">
		<table class="hs_detail">
			<colgroup>
				<col width="15%">
				<col width="10%">
				<col width="15%">
				<col width="15%">
				<col width="20%">
				<col width="30%">
			</colgroup>
			<thead>
				<tr>
					<th>음식점이름</th>
					<th>구 위치</th>
					<th>음식점위치</th>
					<th>전화번호</th>
					<th>운영시간</th>
					<th>이미지</th>
				</tr>
			</thead>
			<tbody class="hs_scroll">
				<c:if test="${empty api}">
					<tr>
						<td></td>
						<td>검색</td>
						<td>결과가</td>
						<td>없습니다</td>
						<td></td>
						<td></td>
					</tr>
				</c:if>
				<c:forEach items="${api}" var="aapi">
					<input type="hidden" />
					<tr data-seq="${aapi.UC_SEQ}">
						<td>${aapi.MAIN_TITLE}</td>
						<td>${aapi.GUGUN_NM}</td>
						<td>${aapi.ADDR1}</td>
						<td>${aapi.CNTCT_TEL}</td>
						<td>${aapi.USAGE_DAY_WEEK_AND_TIME}</td>
						<td><img src="${aapi.MAIN_IMG_THUMB}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</nav>
	<div class="hs_div">
		<a href="${rootPath}" class="hs_home">홈으로</a>
	</div>
	<section class="modal" id="modal_box">
	
	</section>
</body>
</html>