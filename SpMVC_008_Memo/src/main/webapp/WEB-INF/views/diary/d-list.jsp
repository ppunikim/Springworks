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
	background-color: #efd0d6; 
}

section>div {
	width: 80%;
	margin: 15px auto;
	border: 2px solid #4e4b4b;
	padding: 15px 0 15px 0;
	border-radius: 15px;
	max-width: 800px; 
	background-image:url(${rootPath}/static/images/texture.PNG);
}

section .hs_content {
	border-bottom: 1px solid black;
	padding: 10px 0 10px 20px;
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
	border-collapse: collapse;
	margin-bottom: 10px;
}

table tr td, table tr th {
	border-collapse: collapse;
	padding: 4px;
}

table tr td {
	
	padding: 12px 20px;
	border-bottom: 2.25px solid #908a8a82;
	cursor: pointer;
}

img {
	width: 100px;
	transform: rotate(10deg);
}
#hs_img {
	margin-right: 25px;
}
.hs_left {
	margin-left: auto
}

.add_btn {
	color: #262525f2;
	text-decoration: none;
	margin-left: 10px;
	font-size: 17px;
	line-height: 25px;
	font-weight: 530;
}
.add_btn:hover {
	cursor: pointer;
	font-weight: 650;
}
.home {
	margin-left: auto;
	margin-right: 10px;
	color: #9a9a9a;
	text-decoration: none;
	
	
}
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/memo_detail.js?ver=8"></script>
</head>
<body>
	<section>
		<div>
			<div class="hs_flex hs_content">
				<h3>제목</h3>
				<a class="add_btn" href="${rootPath}/diary/d-add">오늘은 일기쓰는 날</a>
				<a href="${rootPath}" class="home">홈으로</a>
			</div>
			<table class="memos scroll">
				<colgroup>
					<col width="25%">
					<col width="25%">
					<col width="25%">
					<col width="25%">
				</colgroup>
				<c:if test="${empty MEMOLIST}">
					<tr>
						<td colspan="6" class="hs_blank">작성한 내용이 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${DAIRYLIST}" var="memo" varStatus="INDEX">
					<tr>
						<td>${diary.d_date}</td>
						<td>${diary.d_mor}</td>
						<td>${diary.d_aft}</td>
						<td>${diary.d_din}</td>
					</tr>
				</c:forEach>
			</table>
			<div id="hs_img" class="hs_flex">
				<div class="hs_left"></div>
				<img src="${rootPath}/static/images/good.png">
			</div>
		</div>
	</section>

</body>
</html>