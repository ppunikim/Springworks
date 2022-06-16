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
<title>home(기본값 페이지)</title>
</head>

<body>
<h1>햇살이의 게시판♥ </h1>
<img src="${rootPath}/upload/${FILE}" alt="이미지 로딩 전">
<a href="${rootPath}/bbs/write">게시판 글쓰기</a>
</body>
</html>