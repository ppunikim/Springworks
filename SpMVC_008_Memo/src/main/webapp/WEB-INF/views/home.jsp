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
<script src="${rootPath}/static/js/diary_detail.js?ver=3"></script>
<script src="${rootPath}/static/js/book_detail.js?ver=2"></script>
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
			<c:if test ="${empty MEMOLIST}" >
 				<tr><td colspan="6">작성한 내용이 없습니다.</td></tr>
 			</c:if>
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
				<col width="200px">
				<col width="200px">
				<col width="440px">
			</colgroup>
			<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>작성시각</th>
				<th>제목</th>
			</tr>
			</thead>
			<tbody>
			<c:if test ="${empty DIARYLIST}" >
 				<tr><td colspan="6">작성한 내용이 없습니다.</td></tr>
 			</c:if>
			<c:forEach items="${DIARYLIST}" var="diary"  varStatus="INDEX">
				<tr data-seq="${diary.d_seq}">
					<td>${INDEX.count}</td>
					<td>${diary.d_author}</td>
					<td>${diary.d_date}</td>
					<td>${diary.d_time}</td>
					<td>${diary.d_title}</td>
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
	<h3>독후감</h3>
	<br>
	<c:if test="${empty USERNAME}">
		<h4>로그인 하세요.</h4>
	</c:if>
	<c:if test="${not empty USERNAME}">
		<h4>${USERNAME} 님 반가워요.</h4>
	</c:if>
	<section>
		<table class="books">
			<colgroup>
				<col width="10px">
				<col width="30px">
				<col width="100px">
				<col width="100px">
				<col width="300px">
				<col width="340px">
			</colgroup>
			<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>작성시각</th>
				<th>책 제목</th>
				<th>한줄평</th>
			</tr>
			</thead>
			<tbody>
 			<c:if test ="${empty BOOKLIST}" >
 				<tr><td colspan="6">작성한 내용이 없습니다.</td></tr>
 			</c:if>
 			<!-- data-seq는 book을 눌렀을 때 detail화면으로 넘어가기 위해 적은 것이다. -->
 			<c:forEach items="${BOOKLIST}" var="book"  varStatus="INDEX">
				<tr data-seq="${book.b_seq}">
					<td>${INDEX.count}</td>
					<td>${book.b_author}</td>
					<td>${book.b_date}</td>
					<td>${book.b_time}</td>
					<td>${book.b_title}</td>
					<td>${book.b_eval}</td>
				</tr>
			</c:forEach> 
			</tbody>
			</table>
	</section>
	<section>
		<c:if test="${empty USERNAME}">
			<a href="${rootPath}/user/login">로그인하기</a>
		</c:if>
		<c:if test="${not empty USERNAME}">
			<a href="${rootPath}/read/book">추가</a>
			<a href="${rootPath}/user/logout">로그아웃</a>
		</c:if>	
	</section>
</div>
</body>
</html>