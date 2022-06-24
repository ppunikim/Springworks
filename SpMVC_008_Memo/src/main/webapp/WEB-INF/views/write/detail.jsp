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
<title>리스트_자세히보기</title>
<style>
	section div:nth-of-type(1) {
		border: 1px solid black;
		margin: 10px;
	}
	section div:nth-of-type(2) a {
		border: 1px solid black;
		margin: 5px;
}
	img {
		width: 500px;
	}
</style>
</head>
<body>
	<section>
		<div>
			<p>작성일자 : ${D_MEMO.m_date} </p>
			<p>메모 : ${D_MEMO.m_memo}</p>
			<p>이미지<img src="${rootPath}/upload/${D_MEMO.m_image}"></p>
		</div>
		<div>
			<a href="${rootPath}">리스트로</a>
			<a href="${rootPath}/write/${D_MEMO.m_seq}/update">수정</a>
			<a>삭제</a>
		</div>	
	</section>
</body>
</html>