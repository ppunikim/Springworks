<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page import="java.util.List"%>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jsp" %>
<style>
	section{
		display: flex;
		flex-direction: column;
	}
	article{
		width: 80%;
		margin: 0 auto;
	}
	table{
		width: 80%;
		margin: 0 auto;
		border-top:1px solid #ddd;
		border-bottom: 1px solid #ddd;
		border-collapse: collapse;
	}
	tr{
		border-bottom: 1px solid #ddd;
		border-top: 1px solid #ddd;
	}
	th, td{
		padding: 5px;
		text-align: left;
		cursor: pointer;
	}
	tr:nth-of-type(even) {
		background-color: #eee;
	}
	tr:nth-of-type(odd) {
		background-color: #ccc;
	}
	 tr:nth-of-type(n+2):hover {
		background-color: #aaa;
	} 
	/* tr:not(:first-of-type){
		background-color: #aaa;
	} */
	div.button-box{
		width:80%;
		margin:5px auto;
		text-align: right;
		padding: 5px 0;
	}
	div.button-box a{
		display:inline-block;
		padding: 12px 16px;
		text-decoration: none;
		color:white;
		background-color:#3f3f4c;
		border-radius: 5px;
	}
	div.button-box a:hover {
		box-shadow: 2px 2px 2px rgba(0,0,0,0.6);
	}	
</style>
<body>
<!--  불편한 jap파일이다. -->
	<%@ include file="/WEB-INF/views/include/include_header.jsp"%>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>
	<section>
		<article>학생정보</article>
		<table>
			<tr>
				<th>학번</th><th>이름</th>
				<th>학과</th><th>학년</th>
				<th>주소</th>
			</tr>
			<tr>
				<td>
			
				</td>
				<td>${STUDENTS[0].stName}</td>
				<td>${STUDENTS[0].stDept}</td>
				<td>${STUDENTS[0].intGrade}</td>
				<td>${STUDENTS[0].stAddr}</td>
			</tr>
						
		</table>
		<div class="button-box">
			<a href="${pageContext.request.contextPath}/student/insert">학생정보 등록</a>
		</div>
	</section>
	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
</html>