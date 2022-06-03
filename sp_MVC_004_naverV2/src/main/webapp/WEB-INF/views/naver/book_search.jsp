<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<style>
	* {
		background-color: #fcee4826;
	}
	h2 {
		width: 300px;
		border-radius: 30px;
		margin: 10px auto;
		text-align: center;
		background-color: #fff;
		padding: 10px 0 15px 0;
	}
	table, table tr th, table tr td{
		border: 1px solid #dedede;
		border-collapse: collapse;
		background-color: #fff; 
		
	}
	table tr th, table tr td {
		padding: 6px;
		border-radius: 5px;
	}
	table {
		margin: 10px auto;
	}
</style>
<section class="modal-content">
	<article class="ch-container ch-teal">
		<span onclick="document.getElementById('close').style.display='none'" class="ch-button ch-display-top-right">&times;</span>
		<h2>네이버 검색 서비스</h2>
	</article>
	<article class="ch-container">
		<!-- 자기 이름_container 이런식으로 만들기 -->
		<table class="ch-table">
			<colgroup>
				<col width="500px">
				<col width="150px">
				<col width="80px" >
			</colgroup>
			<thead>
				<tr>
					<th>도서명</th>
					<th>출판사</th>
					<th>저자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${BOOKS}" var="BOOK">
					<tr>
						<td>${BOOK.title}</td>
						<td>${BOOK.publisher}</td>
						<td>${BOOK.author}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</article>
</section>