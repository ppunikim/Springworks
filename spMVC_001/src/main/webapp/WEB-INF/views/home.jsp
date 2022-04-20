<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>home file</title>
<style>
	* {
	
	}
	h1 {
		background-color: #e82e44;
		color: #fff;
		width: 400px;
		height: 60px;
		line-height:60px;
		padding:0;
		margin:0;
		text-align:center;
	}
	h3 {
		font-size: 20px;
		width: 150px;
		height: 100px;
		padding:3px 20px;
		line-height:50px;
	}
	h3:hover {
		background-color: yellowgreen;
		color:#fff;
	}
	ul li {
		list-style: none;
	
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"  %>	
	<h1>${my_name} 님 반갑습니다.</h1>
	<h3>1 &lt; 9 : ${ 1 < 9  }</h3>
	<h3>1 &lt; 9 : ${ 1 lt 9  }</h3>
	
	<h3>1 &gt; 9 : ${ 1 > 9  }</h3>
	<h3>1 &gt; 9 : ${ 1 gt 9  }</h3>
	
	<h3>3 == 3 : ${ 3 == 3 }</h3>
	<h3>3 == 3 : ${ 3 eq 3 }</h3>
	
	<h3>4 != 3 : ${ 4 != 3 }</h3>
	<h3>4 != 3 : ${ 4 ne 3 }</h3>
	
	<h3>1 &gt;= 9 : ${1 >= 9 }</h3>
	<h3>1 &gt;= 9 : ${1 ge 9 }</h3>
	
	<h3>1 &lt;= 9 : ${1 <= 9 }</h3>
	<h3>1 &lt;= 9 : ${1 le 9 }</h3>
	
	<h3>9 나누기 3 : ${9 / 3 }</h3>
	<h3>9 나누기 3 : ${9 div 3 }</h3>
	
	<h3>9 나누기 2 후 나머지 : ${9 % 2 }</h3>
	<h3>9 나누기 2 후 나머지 : ${9 mod 2 }</h3>
	
	<ul>
		<li>${ ST[0] }</li>
		<li>${ ST[1] }</li>
		<li>${ ST[2] }</li>
	</ul>
	
	
	
</body>
</html>
























