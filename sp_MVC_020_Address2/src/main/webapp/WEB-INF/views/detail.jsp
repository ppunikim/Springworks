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
<title>detail</title>
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

div {
	display: flex;
	justify-content: center;
	margin-top: 100px;
}

.ani {
	animation-name: move;
	animation-duration: 5s;
	animation-iteration-count: infinite;
	animation-direction: alternate;
}

.ani:active {
	animation-play-state: running;
}

.ani:hover {
	animation-play-state: paused;
}

@keyframes move { 
25% {
	transform: rotate(5deg) scale(1.1);
	}

50% { 
	transform:rotate(0deg)scale(1);
	}
75% {
	transform:rotate(-5deg)scale(1.1);
	}
}
div label {
	padding: 10px;
	background-color: #eee;
	border-radius: 10px;
	box-shadow: 0px 0px 5px #444;
}

div p {
	padding: 10px;
	border-bottom: 2px solid black;
}

section div {
	text-align: center;
	margin: 100px auto;
}

section div a {
	text-decoration: none;
	color: #493f3f;
	margin-left: 50px;
}
.box {
	flex: 1;
}
</style>
</head>
<body>
	<%
	// detail은 한 사람의 데이터이기 때문에 controller의 model값을 그냥 가져오면 된다.
	%>
	
	<div>
		<label>이름</label>
		<p>${address.a_name}</p>
		<label>전화번호</label>
		<p>${address.a_tel}</p>
		<label>주소</label>
		<p>${address.a_address}</p>
	</div>
	<section>
		<div class="ani">
			<a href="${rootPath}/update?seq=${address.a_seq}">수정</a> <a
				href="${rootPath}">홈으로</a> <a
				href="${rootPath}/delete?seq=${address.a_seq}">삭제</a>
		</div>
	</section>
</body>
</html>