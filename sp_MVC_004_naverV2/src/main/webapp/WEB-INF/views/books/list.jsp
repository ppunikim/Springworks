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
	width: 100%;
	height: 60px;
	line-height: 60px;
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
	color: white;
	background-color: #777;
	border-radius: 10px;
	padding: 10px;
	margin-right: 40px;
}

colgroup {
	width: 120px;
}
</style>
<link rel="stylesheet" href="./scroll.css" />
<script src="./scroll.js"></script>
</head>
<body>
	<header>
		<h1>내가 읽은 책들</h1>
	</header>
	<table>
		<colgroup>
			<col width="10%">
			<col width="15%">
			<col width="25%">
			<col width="20%">
			<col width="10%">
			<col width="20%">
		</colgroup>
		<tr>
			<th>No.</th>
			<th>ISBN</th>
			<th>도서명</th>
			<th>출판사</th>
			<th>저자</th>
			<th>출판일자</th>
		</tr>
		<c:forEach items="${BOOKS}" var="BOOK">
			<tr>
				<td>${BOOK.isbn}</td>
				<td>${BOOK.title}</td>
				<td>${BOOK.publisher}</td>
				<td>${BOOK.author}</td>
				<td>${BOOK.pubdate}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="${rootPath}/books/insert">도서정보추가</a>
	</div>
</body>
</html>