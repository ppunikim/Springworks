<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org"
	            xmlns:layout="http://www.ultraq.nz/thymeleaf/layout">

<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"  />

<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>2022 예문여고 성적처리</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${rootPath}/static/css/main.css?ver=12">
<link rel="stylesheet" href="${rootPath}/static/css/student_list.css?ver=8">
<link rel="stylesheet" href="${rootPath}/static/css/student_detail.css?ver=2">
<script th:inline="javascript">
	const rootPath = /* "[[@{}]]"*/ /
</script>
<script src="${rootPath}/static/js/main.js?ver=3"></script>
<script src="${rootPath}/static/js/student_list.js?ver=4"></script>
</head>