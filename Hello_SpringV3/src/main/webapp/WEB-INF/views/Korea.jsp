<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>korea파일</title>
</head>
<body>
	<h1>대한민국 만세</h1>
	<form>
		<div><input name = "st_name" placeholder= "이름을 입력하시오"></div>
		<div>${ result } 님 반갑습니다.</div> <!--  빨간글씨는 이클립스 버그이다. -->
		
	</form> <!--  form태그만 method를 선택가능 -->
	<div><a href="?st_name=둘리">둘리</a></div> <!--  a 태그를 써서 날아가는 방식은 무조건 get방식--> 
	<div><a href="?st_name=또치">또치</a></div>
	<div><a href="?st_name=도우너">도우너</a></div>
</body>
</html>