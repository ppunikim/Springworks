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
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</section>
	<section>
		<a href="${rootPath}/write/memo">추가</a>
	</section>
</body>
</html>