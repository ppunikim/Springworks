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
<title>Home.jsp</title>
<style>
	* {
		box-sizing: border-box;
		margin:0;
		padding:0;
	}
	html {
		width:100vw;
		height:100vh; 
	}
	body {
		width:100%;
		height:100%;
		display:flex;
		flex-direction: column;
		background-color:#f3cabb;
	}
	header {
		border-bottom:1.4px solid black; 
	}
	
	header div ul {
		display: flex;
		justify-content: space-around;
	}
	header div ul li {
		list-style: none;
		padding: 30px;
	} 
	header div ul li:hover {
		background-color: black;
		color: #fff;
		cursor: progress;
	}
	nav{
		flex: 1;
		justify-content: center;
		margin: 10px auto;
	}
	nav div h4 {
		font-size: 20px;
		text-align: center;
		margin: 10px 0;
	}
	nav div form{
		display: flex;
		flex-direction: column;
		padding: 10px;
		margin: 6px;
	}
	nav div form input {
		padding: 5px;
		border-radius: 10px;
	}
	nav div form button {
		margin-top: 10px;
		padding: 4px;
		cursor: se-resize;
		background-color: black;
		color: #fff;
		border-radius: 20px;
	}
	nav div table {
		text-align: center;
	}
	nav div table tr th, nav div table tr td {
		padding: 
	}
	nav div table tr th {
		font-size: 17.5px;
		padding: 10px 0;
	}
	nav div table tr th {
		background-color: #f9e4e0; 
	}
	nav div table tr td {
		background-color: #ffefedc9;
		padding: 5px;
	}
	nav div table tr td a {
		text-decoration: none;
		color: inherit;
	}
</style>
<script>
	const rootPath = '${rootPath}'
</script>
</head>
<body>
	<header>
		<div>
			<ul>
				<li>메뉴1</li>
				<li>메뉴2</li> 
				<li>메뉴3</li>
				<li>메뉴4</li>
			</ul>
		</div>
	</header>
	<nav>
		<div>
			<h4>주소록</h4> 
			<form  method="POST" >
				<input name = "a_seq" type="hidden" value='<c:out value="${address.a_seq}" default="0" />' />
 				<label>이름</label> 
				<input name="a_name" id="a_name" placeholder="이름 입력해라" value="${address.a_name}" autocomplete="off"
							required="required" autofocus="autofocus"/> 
				<label>전화번호</label>
				<input name="a_tel" id="a_tel" placeholder="전화번호 입력해라"  value="${address.a_tel}" autocomplete="off"/>
				<label>집주소</label>
				<input name="a_address" id="a_address" placeholder="집주소 입력해라"  value="${address.a_address}" autocomplete="off"/>
				<button>저장</button>
			</form>
		</div>
		<div>
			<table>
				
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>주소명</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="INDEX" value="1"></c:set>
					<c:forEach items="${ADDR}" var="addr" varStatus="INDEX">
						<tr>
							<td><a href="${rootPath}/detail?seq=${addr.a_seq}">${INDEX.count}</a></td>
							<td> <a href="${rootPath}/detail?seq=${addr.a_seq}">
							${addr.a_name}</a></td>
							<td>${addr.a_tel}</td>
							<td>${addr.a_address}</td>
						</tr>				
					</c:forEach>
				</tbody>
			</table>
			<%@ include file = "/WEB-INF/views/pagenation.jsp" %>
		</div>
	</nav>
</body>
</html>