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
<title>메모 리스트_자세히보기</title>
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
	background-color: #000000e0;
}

#content {
	flex: 1;
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
}

#hs_list {
	border: 1px solid transparents;
	margin: 5px;
	text-decoration: none;
	padding: 3px;
	margin-top: 160px;
	font-weight: 500;
	text-align: center;
	font-size: 20px;
}

#hs_list a {
	color: #393939;
}
.input_memo div p{
	font-weight: 600;
	margin-bottom: 30px;	
}
.input_memo {
	width: 400px;
	height: 500px; 
	border: 1px solid #ffd2e1;
	padding: 15px;
	background-color: #ffff95;
	margin: 10px auto;
}
#hs_content {
	flex: 1;
	margin: 30px 0 10px 0;
	text-align: center;
}
#hs_content:hover {
}
section a {
	color: black;
	text-decoration: none;
}

.hs_btn:hover {
	background-color: #504848;
	border-radius: 40px;
	color: #eee;
	padding: 8px;
}

section a:nth-of-type(2) {
	margin-left: 190px;
}
img {
	width: 300px;
	max-height: 300px;
	margin: 10px auto;
	margin-bottom: 10px;
}
#hs_up {
	text-align: right;
	font-weight: 800;
	font-size: 14px;
	color: gray;
}
footer { 
	margin: 0 auto;
}
</style>
</head>
<body>
	<div id="content">
		<section class="input_memo">
			<div id="hs_up">${M_MEMO.m_date}</div>
			<div id="hs_content">
				<p>${M_MEMO.m_memo}</p>
				<c:if test="${not empty M_MEMO.m_up_image}">
				<img src="${rootPath}/upload/${M_MEMO.m_up_image}">
				</c:if>
				<div>
					<a class="hs_btn" href="${rootPath}/memo/${M_MEMO.m_seq}/update">수정</a>
					<a class="hs_btn" href="${rootPath}/memo/${M_MEMO.m_seq}/delete">삭제</a>
				</div>
			</div>
			<div id="hs_list">
				<a href="${rootPath}">리스트로</a>
			</div>
		</section>
	</div>
	<footer>
		<address>CopyWrite &copy;ppuniKim</address>
	</footer>
</body>
</html>