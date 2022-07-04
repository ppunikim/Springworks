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
<title>메인 화면</title>
<style>
* {
	background-color: #f2eddc;
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

section:nth-of-type(1) {
	overflow-y: scroll;
	height: 200px;
}

h3 {
	color: #262424;
	font-weight: 540;
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

section a {
	color: #383737bf;
	font-weight: 300;
	text-decoration: none;
	margin-left: 5px;
	padding-right: 20px;
	padding-top: 20px;
	padding-bottom: 20px;
	font-size: 15px;
}

img {
	width: 120px;
}

h5 a:hover {
	font-weight: bolder;
}

#hs_img img {
	width: 80px;
}
.hs_info {
	border: 1px solid black;
	background-color: black;
	width: 40%;
}
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/memo_detail.js?ver=8"></script>
<script src="${rootPath}/static/js/diary_detail.js?ver=5"></script>
<script src="${rootPath}/static/js/book_detail.js?ver=4"></script>
</head>
<body>
	<div class="hs_flex">
		<div class="hs_all">
			<div class="hs_flex">
				<c:if test="${empty USERNAME}">
					<h2>로그인 해야 글쓰기 가능 ( •́ ̯•̀ )</h2>
					<h4 id="z_log">
						<a href="${rootPath}/user/login">login</a>
					</h4>
				</c:if>
				<c:if test="${not empty USERNAME}">
					<h2>${USERNAME}메모하는습관을 들이자 ٩̋(ˊ•͈ ꇴ •͈ˋ)و</h2>
					<h4 id="z_logout">
						<a href="${rootPath}/user/logout">logout</a>
					</h4>
				</c:if>
			</div>

			<div id="first">
				<section>
					<div class="hs_flex">
						<h3>메모장</h3>
						<c:if test="${not empty USERNAME}">
							<h5>
								<a href="${rootPath}/memo/m-add"> + 추가</a>
							</h5>
						</c:if>
					</div>
					<table class="memos">
						<colgroup>
							<col width="10%">
							<col width="10%">
							<col width="15%">
							<col width="15%">
							<col width="25%">
							<col width="25%">
						</colgroup>
						<tr>
							<th>번호</th>
							<th>작성자</th>
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
								<td>${memo.m_author}</td>
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
			<hr>
			<div id="second">
				<section>
					<div class="hs_flex">
						<h3>일기장</h3>
						<c:if test="${not empty USERNAME}">
							<h5>
								<a href="${rootPath}/diary/d-add"> + 추가</a>
							</h5>
						</c:if>
					</div>
					<table class="diarys">
						<colgroup>
							<col width="10%">
							<col width="15%">
							<col width="15%">
							<col width="25%">
							<col width="35%">
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
							<c:if test="${empty DIARYLIST}">
								<tr>
									<td colspan="6">작성한 내용이 없습니다.</td>
								</tr>
							</c:if>
							<c:forEach items="${DIARYLIST}" var="diary" varStatus="INDEX">
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
			</div>
			<hr>
			<div id="third">
				<section>
					<div class="hs_flex">
						<h3>독후감</h3>
						<c:if test="${not empty USERNAME}">
							<h5>
								<a href="${rootPath}/book/b-add"> + 추가</a>
							</h5>
						</c:if>
					</div>
					<table class="books">
						<colgroup>
							<col width="10%">
							<col width="10%">
							<col width="15%">
							<col width="15%">
							<col width="25%">
							<col width="25%">
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
							<c:if test="${empty BOOKLIST}">
								<tr>
									<td colspan="6">작성한 내용이 없습니다.</td>
								</tr>
							</c:if>
							<!-- data-seq는 book을 눌렀을 때 detail화면으로 넘어가기 위해 적은 것이다. -->
							<c:forEach items="${BOOKLIST}" var="book" varStatus="INDEX">
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
			</div>
		</div>
		<div class="hs_info">
			<div> 
				<p>정보 창</p>
			</div>
		</div>
	</div>
</body>
</html>