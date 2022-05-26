<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN.JSP</title>
</head>
<style>
form.join {
	width: 60%;
	margin:20px auto;

}
form.join fieldset {
	background-color: skyblue;	
}
form div {
	display: flex;
	margin: 5px auto;
	
}
form input {
	flex: 1;
	padding: 8px;
}

.warn {
	color: tomato;
	font-weigth: 900;
	text-decoration: underline;
}
.ok {
	color:olive;
}
</style>
<script>
	//js 파일에서 rootPath를 사용할 수 있도록 미리 JS변수로 선언
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/join.js?ver=2022-05-26-008" ></script>
<body>	
	<form class="join">
		<fieldset>
			<legend>회원가입</legend>
			<div>
				<input name="username" placeholder="username" autocomplete="none"/>
				<button class="id-check" type="button">중복검사</button>
			</div>
			<div class="username"></div>
			<div>
				<input name="password" type="password" placeholder="password" autocomplete="none"/>
			</div>
			<div>
				<input name="Re_password" placeholder="re_password" type="password" />
			</div>
			<div>
				<input name="name" placeholder="이름"/>
			</div>
			<div>
				<input name="email" placeholder="이메일"/>
			</div>
			<div>
				<button type="button" class="join" >회원가입</button>
				<button type="reset" >새로 작성</button>
			</div>
		</fieldset>		
	</form>

</body>
</html>