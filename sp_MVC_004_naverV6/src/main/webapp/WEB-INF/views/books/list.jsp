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
<title>books.list</title>
<style>
* {
	margin: 0;
	padding: 0;
	list-style: none;
}

h1 {
	text-align: center;
	/*top: 0;
	position: fixed;
	left: 0;*/
	width: 80%;
	height: 60px;
	line-height: 55px; 
	padding: 30px; 
	margin: 30px auto;
	background-color: inherit;
	padding: 10px;
	/*transition: all 0.1s;
	border-radius: 5px;*/
}

table, table tr td, table tr th {
	border: 1px solid transparent;
	border-collapse: collapse;
	padding: 7px;
}

table {
	text-align: center;
	margin-top: 30px;
	margin: 10px auto;
	margin-bottom: 30px;
	width: 80%;
}

table th {
	background-color: #d9d7d7; 
}

div {
	padding: 10px;
	text-align: right;
}

a {
	text-decoration: none;
	border-radius: 10px;
	padding: 10px;
	margin-right: 100px;
}

#last-a {
	box-shadow: -6px -6px 14px rgba(255, 255, 255, 0.7),
          -6px -6px 10px rgba(255, 255, 255, 0.5),
          6px 6px 8px rgba(255, 255, 255, 0.075),
          6px 6px 10px rgba(0, 0, 0, 0.15);
}
colgroup {
	width: 120px;
}
</style>
<link rel="stylesheet" href="./scroll.css" />
<script >
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/books.js?ver=2022-06-08-002"></script>
</head>
<body>
	<header>
		<h1>읽고싶은 책들</h1>
	</header>
	<table class="books">
		<colgroup>
			<col width="10%">
			<col width="15%">
			<col width="25%">
			<col width="20%">
			<col width="10%">
			<col width="20%">
		</colgroup>
		<thead>
			<tr>
				<th>No.</th>
				<th>ISBN</th>
				<th>도서명</th>
				<th>출판사</th>
				<th>저자</th>
				<th>출판일자</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="INDEX" value="1"></c:set>
			<c:forEach items="${BOOKS}" var="BOOK" varStatus="INDEX">
				<tr data-isbn="${BOOK.isbn}"> 
					<td>${INDEX.count}</td>
					<td>${BOOK.isbn}</td>
					<td>${BOOK.title}</td>
					<td>${BOOK.publisher}</td>
					<td>${BOOK.author}</td>
					<td>${BOOK.pubdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a href="${rootPath}/books/insert" id="last-a">도서정보추가</a>
	</div>
</body>
</html>