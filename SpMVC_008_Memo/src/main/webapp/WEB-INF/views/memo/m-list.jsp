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
}
.hs_all {
	width: 60%;
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

.scroll {
	overflow-y: scroll;
	height: 200px;
}

</style>
</head>
<body>
	<div id="first">
		<section class="scroll">
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
	</div>

</body>
</html>