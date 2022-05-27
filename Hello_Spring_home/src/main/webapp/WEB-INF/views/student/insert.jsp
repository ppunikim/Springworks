<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<section>
	<article>
		<form method="POST">
			<fieldset>
				<legend>학생정보 등록</legend>
				<label>학번</label>
				<input type="text" placeholder="학번" />
				<label>이름</label>
				<input type="text" placeholder="이름" />
				<label>학과</label>
				<input type="text" placeholder="학과" />
				<label>학년</label>
				<input type="text" placeholder="학년" />
				<label>주소</label>
				<input type="text" placeholder="주소" />
				
				<div>
					<button>저장</button>
					<button type="button">리스트로</button>
					<button type="reset">다시작성</button>
				</div>
			</fieldset>
		</form>
	</article>
</section>
</body>
</html>