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
<title>메모 리스트 보여주기</title>
<style>
	table{
		border: 1px solid black;
		border-collapse: collapse;
	}
	table tr td, table tr th {
		border-collapse: collapse;
		border: 1px solid black;
		padding: 4px;
	}
</style>
</head>
<body>
	<h3>메모하는 습관을 들이자.</h3>
	<section>
		<table>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>작성시각</th>
				<th>메모내용</th>
				<th>이미지파일</th>
			</tr>
			<c:forEach items="${MEMOLIST}" var="memo"  varStatus="INDEX">
				<tr>
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
</body>
</html>