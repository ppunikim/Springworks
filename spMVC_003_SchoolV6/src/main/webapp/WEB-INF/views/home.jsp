<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>학사관리</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	width: 100vw;
	height: 100vh;
	display: flex;
	flex-direction: column; /* 위에서 아래로 배치 */
}

header {
	background-color: skyblue !important;
	/* important : 어떤 태그 속성보다 강제 적용하라 */
	padding: 2rem;
	font-weight: 999;
}

header h1 {
	text-align: center;
	text-shadow: 5px 2px 1px black;
	color: white;
}

header p {
	text-align: center;
}

/* a tag의 color속성은 부모 tag의 color속성을 상속받지 않는다.
		만약 a tag에 부모의 color 속성을 상속받고자 한다면 
		color: inherit 속성을 부여하면 된다.
	*/
header a {
	color: inherit;
}

nav {
	background-color: pink;
	color: red;
}

nav ul {
	list-style: none;
	display: flex;
	border: 2px solid #fff;
}

nav li {
	padding: 12px 16px;
}

nav li:nth-of-type(4) {
	margin-left: auto;
}

nav li:hover {
	cursor: pointer;
	background-color: white;
	font-weight: bold;
}

section.main {
	flex: 1; /* 여백 없이 최대로 만든다. */
	padding: 4px;
	display: flex;
}

section.main article {
	flex: 1;
	margin: 0 4px;
	border: 1px solid skyblue;
}

footer {
	background-color: skybule;
	color: red;
	text-align: right;
	padding: 0.6rem;
}

button {
	margin: 5px solid;
	border: none;
	outline: none;
	padding: 6px;
	border-radius: 4px;
}
button:hover {
	box-shadow: 5px 4px 8px rgba(0,0,0,0.9);
}
button.btn-pink {
	background-color: pink;
}
button.btn-yellow {
	background-color: yellow;
}
button.btn-glass {
	background-color: transparent;
	border: 1px solid black;
}

</style>
<script>
	// jsp의 속성(변수) 값을 JS 로 보내기 위해
	// JS 변수로 선언
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/nav.js?ver=2022-05-10-001"></script>

</head>
<body>
	<header>
		<h1>학사관리 시스템</h1>
		<p>대한고교 학사관리 시스템 2022</p>
	</header>
	<nav>
		<ul>
			<li>HOME</li>
			<li>학생정보</li>
			<li>성적정보</li>
			<li>로그인</li>
			<li>회원가입</li>
		</ul>
	</nav>
	<section class="main">
		<c:choose>
			<c:when test="${LAYOUT == 'ST_LIST'}">
				<article>
					<%@ include file="/WEB-INF/views/student/list.jsp"%>
				</article>
			</c:when>
			<c:when test="${LAYOUT eq 'ST_INPUT'}">
				<article>
					<%@ include file="/WEB-INF/views/student/input.jsp"%>
				</article>
			</c:when>
			<c:otherwise>
				<article></article>
				<article></article>
				<article></article>
			</c:otherwise>
		</c:choose>
	</section>
	<footer>
		<address>CopyRright &copy;yd62322@naver.com</address>
	</footer>



</body>





























</html>