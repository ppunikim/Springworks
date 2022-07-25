<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<style>
table tbody td input {
	width: 200px;
}

.merge {
	display: flex;
}
.lists {
	font-weight: bold;
	margin: 10px auto;
	font-size: 20px;
}
input {
	margin-left:10px;
	padding-left: 4px; 
}
.sub{
	margin: 5px auto;
	border: 1.5px solid black;
	padding: 10px;
	width: 500px;
}
.sub label {
	display: inline-block;
	width: 180px;
}
.sub input {
	width : 100px;
}

</style>
<div>
	<form method="POST">
		<table class="student detail">
			<thead>
				<tr>
					<th>학번</th>
					<th>기본정보</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${STUDENT.st_num}</td>
					<td class="merge"><h5>이름</h5> <input type="text" name="st_name"
						value="${STUDENT.st_name}"></td>
					<td class="merge"><h5>학과</h5> <input type="text" name="st_dept"
						value="${STUDENT.st_dept}"></td>
					<td class="merge"><h5>학년</h5> <input type="text" name="st_grade"
						value="${STUDENT.st_grade}"></td>
					<td class="merge"><h5>전번</h5> <input type="text" name="st_tel"
						value="${STUDENT.st_tel}"></td>
					<td><textarea name="st_addr" readonly="readonly" >${STUDENT.st_addr}</textarea></td>
				</tr>
			</tbody>
		</table>
		<div class="sub">
			<c:forEach items="${STUDENT.scoreList}" var="sc">
				<label>${sc.sb_name}(${sc.sc_sbcode})</label>
				<input value="${sc.sc_score}" name= "sc_score">
				<br>
			</c:forEach>
		</div>
		<div class="lists">
			<button>수정</button> 
			<a href="${rootPath}/student">리스트로</a>
		</div>
	</form>
</div>