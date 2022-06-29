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
<title>로그인 화면</title>
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
		height: 80%;
		display: flex;
		justify-content: center;
		align-items: center;
		background-color: #efefef;
	}
	form {
		width: 50%;
		text-align: center;
	}
	input {
		padding: 1rem;
		width: 100%;
		box-shadow: -6px -6px 14px rgba(255, 255, 255, 0.7),
          -6px -6px 10px rgba(255, 255, 255, 0.5),
          6px 6px 8px rgba(255, 255, 255, 0.075),
          6px 6px 10px rgba(0, 0, 0, 0.15);
        border-radius: 20px;
       border:none;
       
	}
</style>
</head>
<body>
	<form method="POST">
		<input name="username" placeholder="USERNAME 입력 후 Enter" 
			autofocus="autofocus" autocomplete="off">
	</form>
	<section></section>
</body>
</html>