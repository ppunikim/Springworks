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

#z_log {
	margin-left: auto;
	margin-right: 20px;
}

#z_logout a {
	text-decoration: none;
	border-radius: 50px;
	padding: 8.5px;
	color: #858484d9;
	box-shadow: -6px -6px 14px rgba(255, 255, 255, 0.7), -6px -6px 10px
		rgba(255, 255, 255, 0.5), 6px 6px 8px rgba(255, 255, 255, 0.075), 6px
		6px 10px rgba(0, 0, 0, 0.15);
}

#z_logout {
	margin-left: auto;
	margin-right: 20px;
}

#z_log a {
	background-color: #838282a1;
	text-decoration: none;
	border-radius: 50px;
	padding: 7px;
	color: #fff9e5;
	box-shadow: -6px -6px 14px rgba(255, 255, 255, 0.7), -6px -6px 10px
		rgba(255, 255, 255, 0.5), 6px 6px 8px rgb(255 229 229/ 14%), 6px 6px
		10px rgba(0, 0, 0, 0.15);
}

div h2 {
	color: #291515;
	font-weight: 200;
	margin-left: 10px;
}

table {
	border: 1px solid black;
	border-collapse: collapse;
	margin-bottom: 10px;
}

table tr td, table tr th {
	border-collapse: collapse;
	padding: 4px;
}

table tr th {
	background-color: #8d8d8d;
	border: 1px solid #f2eddc;
	border-radius: 4px;
}

table tr td {
	cursor: pointer;
	padding: 12px;
	border-bottom: 2.25px solid #908a8a82;
	border-left: 1px solid #f2eddc;
	border-right: 1px solid #f2eddc;
}

img {
	width: 120px;
}

.add_btn {
	color: #383737bf;
	font-weight: 300;
	text-decoration: none;
	margin-left: 5px;
	padding-right: 20px;
	padding-top: 20px;
	padding-bottom: 20px;
	font-size: 15px;
}

.add_btn:hover {
	cursor: pointer;
	font-weight: bolder;
}
.hs_info {
	border: 1px solid black;
	width: 40%;
	padding: 10px;
}
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/memo_detail.js?ver=8"></script>
<script src="${rootPath}/static/js/aJax.js?ver=4"></script>
</head>
<body>
	<section>
		<div class="hs_flex">
			<h3>메모장</h3>
			<c:if test="${not empty USERNAME}">
				<div class="add_btn">+ 추가</div>
			</c:if>
		</div>
		<table class="memos scroll">
			<colgroup>
				<col width="10%">
				<col width="20%">
				<col width="20%">
				<col width="25%">
				<col width="25%">
			</colgroup>
			<tr>
				<th>번호</th>
				<th>작성일자</th>
				<th>작성시각</th>
				<th>메모내용</th>
				<th>이미지파일</th>
			</tr>
			<c:if test="${empty MEMOLIST}">
				<tr>
					<td colspan="6">작성한 내용이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${MEMOLIST}" var="memo" varStatus="INDEX">
				<tr data-seq="${memo.m_seq}">
					<td>${INDEX.count}</td>
					<td>${memo.m_date}</td>
					<td>${memo.m_time}</td>
					<td>${memo.m_memo}</td>
					<td id="hs_img"><c:if test="${ not empty memo.m_up_image}">
							<img src="${rootPath}/upload/${memo.m_up_image}">
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</section>
	<aside>
		<div class="hs_info">
			<div class="hs_last1"></div>
		</div>
	</aside>
</body>
</html>