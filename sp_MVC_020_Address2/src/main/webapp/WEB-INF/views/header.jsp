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
<title>header</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html {
	width: 100vw;
	height: 100vh;
}

body {
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
	background-color: #f3cabb;
}

header {
	border-bottom: 1.4px solid black;
}

header div ul {
	display: flex;
	justify-content: space-around;
}

header div ul li {
	list-style: none;
	padding: 30px;
}
header div ul li a {
	text-decoration: none;
	color: black;
}
header div ul li:hover {
	cursor: progress;
	color: #fff;
}
header div ul li a:hover {
	color: #fff;
	cursor: e-resize;
}
header div ul  li:nth-of-type(4) {
	margin-left: auto;
}
</style>
</head>
<body>
	<header>
		<div>
			<ul>
				<li><a href="${rootPath}">HOME</a></li>
				<li><a href="${rootPath}/insert">Add</a></li>
				<li><a href="${rootPath}/about">About</a></li>
				<li>join</li>
				<li>login</li>
			</ul>
		</div>
	</header>

</body>
</html>