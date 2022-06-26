<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>메인 화면</title>
<style>
* {
	background-color: #f2eddc; 
}
	div h2{
		color: #291515;
		font-weight: 200;
	}
	
	section:nth-of-type(1) {
		overflow-y: scroll;
		height: 200px;
	}
	h3 {
		color: #262424;
		font-weight: 300;
	}
	table{
		border: 1px solid black;
		border-collapse: collapse;
		margin-bottom: 10px;
	}
	table tr td, table tr th {
		border-collapse: collapse;
		border: 1px solid black;
		padding: 4px;
	}
	table tr td {
		cursor: pointer;
	}
	section a {
		color: #fff;
		background-color: #231f1f;
		padding: 3px;
		border-radius: 8px;
		text-decoration: none;
	}
</style> 
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/memo_detail.js?ver=4"></script>
<script src="${rootPath}/static/js/diary_detail.js?ver=1"></script>
</head>
<body>
<div>
	<h2>메모하는 습관을 들이자.</h2>
</div>
<div id="first">
	<section>
	<h3>메모장</h3>
		<table class="memos">
			<colgroup>
				<col width="10px">
				<col width="30px">
				<col width="20px">
				<col width="20px">
				<col width="500px">
				<col width="300px">
			</colgroup>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>작성일자</th>
					<th>작성시각</th>
					<th>메모내용</th>
					<th>이미지파일</th>
				</tr>
			<c:forEach items="${MEMOLIST}" var="memo"  varStatus="INDEX">
				<tr data-seq="${memo.m_seq}">
					<td>${INDEX.count}</td>
					<td>${memo.m_author}</td>
					<td>${memo.m_date}</td>
					<td>${memo.m_time}</td>
					<td>${memo.m_memo}</td>
					<td>${memo.m_image}</td>
				</tr>
			</c:forEach>
		</table>
	</section>
	<section>
		<a href="${rootPath}/write/memo">추가</a>
	</section>
</div>
<hr>
<div id="second">
	<h3>일기장</h3>
	<section>
		<table class="diarys">
			<colgroup>
				<col width="10px">
				<col width="30px">
				<col width="20px">
				<col width="20px">
				<col width="500px">
				<col width="300px">
			</colgroup>
			<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>작성시각</th>
				<th>제목</th>
				<th>이미지파일</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${DIARYLIST}" var="diary"  varStatus="INDEX">
				<tr data-seq="${diary.d_seq}">
					<td>${INDEX.count}</td>
					<td>${diary.d_author}</td>
					<td>${diary.d_date}</td>
					<td>${diary.d_time}</td>
					<td>${diary.d_title}</td>
					<td>${diary.d_image}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</section>
	<section>
		<a href="${rootPath}/record/diary">추가</a>
	</section>
</div>
<hr>
<div id="third">

</div>
</body>
</html>