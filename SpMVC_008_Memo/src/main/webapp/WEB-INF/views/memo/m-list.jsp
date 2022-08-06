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
<title>JSP 파일</title>
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
	text-align: center;
}

.hs_flex {
	display: flex;
}

img {
	width: 120px;
}

.add_btn {
	color: #e0e0e0e8;
	font-weight: 500;
	text-decoration: none;
	margin-left: 5px;
	padding-right: 20px;
	padding-top: 20px;
	padding-bottom: 20px;
	font-size: 17px;
}

.add_btn:hover {
	cursor: pointer;
	font-weight: bolder;
}
header div {
	background-color: gray;
}
header div h3 {
	padding-left: 15px;
	color: #eeee;
}

.hs_memo {
	border: 1px solid transparent;
	z-index: 100;
	background-color: yellow;
	width: 300px;
	height: 400px;
	margin: 10px;
}
</style>
<link rel="stylesheet" href="${rootPath}/static/css/w3css.css">
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/memo_detail.js?ver=8"></script>
</head>
<body>
	<header>
		<div class="hs_flex">
			<h3>메모장</h3>
			<a class="add_btn" href="${rootPath}/memo/m-add">+ 추가</a>
		</div>
	</header>
	<section>
		<div>
			<c:if test="${empty MEMOLIST}">
				<tr>
					<td colspan="6">작성한 내용이 없습니다.</td>
				</tr>
			</c:if>

			<c:forEach items="${MEMOLIST}" var="memo" varStatus="INDEX">
				<div class="w3-col m4 w3-container w3-margin w3-card-4 w3-yellow ">
					<h3>${INDEX.count}</h3>
					<br>
					<h4>${memo.m_date}</h4>
					<br>
					<h4>${memo.m_memo}</h4>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>