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
<title>메인 화면</title>
<style>
* {
	background-color: #f2eddc;
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html {
	width: 100vw;
	height: 100vh;
} 

body {
	width: 85%;
	height: 100%;
	display: flex;
	flex-direction: column;
	margin: auto;
}

.hs_block {
	display: none;
}

.hs_flex {
	display: flex;
}
.hs_sa {
	justify-content: space-between;  
	margin-top: 10px;
}
.z_log {
	line-height: 50px;
	margin-left: auto;
	color: #3f4338;
	text-decoration: none;
	font-weight: 500;
	font-size: 20px;
}
.z_log:hover {
	display: block;	
} 
section {
	flex: 1;
	font-size: larger;
	text-align: center;
	margin: 250px 0 150px 0;
	line-height: 40px; 
}
section h3 {
	font-weight: 500;
}

footer{
	text-align: center;
}

footer a {
	line-height: 100px;
	font-size: 30px;
}

</style>
</head>
<body>
	<header class="hs_flex hs_sa">
		<c:if test="${empty USERNAME}">
		<img src="static/images/logo.jpg"  width="50vw" >
			<h4 class="z_log">
				<a href="${rootPath}/user/login" class="z_log">login</a>
			</h4>
		</c:if>
		<c:if test="${not empty USERNAME}">
			<img src="static/images/logo.jpg"  width="50vw">   
			<div class="z_log">
				<a href="" class="z_log">about</a>
				<div class="hs_block">
					<a href="${rootPath}/user/logout" class="z_log">logout</a>
				</div>
			</div>
		</c:if>
	</header>
	<section>
			<h1>sunny's web page</h1>
			<h3>diary, memo, books.. etc</h3>
	</section>
	<footer>
		<a>▼</a>  
	</footer>
</body>
</html>