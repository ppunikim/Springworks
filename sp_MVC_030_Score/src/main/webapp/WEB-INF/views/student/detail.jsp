<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<div>
	<table class="student detail">
		<thead>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>학과</th>
				<th>전번</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${STUDENT.st_num}</td>
				<td>${STUDENT.st_name}</td>
				<td>${STUDENT.st_dept}</td>
				<td>${STUDENT.st_tel}</td>
				<td>${STUDENT.st_addr}</td>
			</tr>
		</tbody>
	</table>
</div>
<div>
	<c:forEach items="${SCORE}" var="sc">
		<ul>
			<li>${sc.sb_name}(${sc.sc_sbcode}) : ${sc.sc_score}</li>
		</ul>
	</c:forEach>
</div>