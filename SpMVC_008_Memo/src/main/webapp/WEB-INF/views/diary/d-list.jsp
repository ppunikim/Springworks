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
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/memo_detail.js?ver=8"></script>
<link rel="stylesheet" href="${rootPath}/static/css/diary_list.css?ver=2" />
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