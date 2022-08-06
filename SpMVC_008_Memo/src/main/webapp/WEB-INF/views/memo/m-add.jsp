<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>memo쓰기</title>
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
	text-align: center;
	background-color:#ddffdd;
}
img {
	width: 120px;
} 
.main_div {
	width: 70%;
	margin: 30px auto;
}
.main h3 {
	text-align: center;
}
.input_memo {
	height: 250px;
}
section {
	width: 100%;
}
#hs_footer {
	margin: 20px auto;
}
/* #hs_footer {
	display:flex;
}
#hs_footer input:nth-of-type(2){
	margin-left: auto;
}
#put {
	display: none;
} */
</style> 
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/function.js?ver=9"></script>
<link rel="stylesheet" href="${rootPath}/static/css/w3css.css">
</head>
<body>
<section class="main">
<div class="main_div">
	<form:form modelAttribute="MEMOLIST" class="main_memo">
		<h3>메모장</h3>
			<form:input path="m_date" readonly="readonly" type="hidden"/>
			<textarea 	name="m_memo" 
						id="MEMO"
						class="w3-input w3-border input_memo" 
						placeholder="메모를 입력하세요." 
						autofocus="autofocus" 
						required="required" 
						autocomplete="off">${M_MEMO.m_memo}</textarea>

			<div id="hs_footer" >
				<a href="${rootPath}/memo/m-list" class="w3-button w3-round-xxlarge w3-padding-large" >돌아가기</a>
				<input type="reset"class="w3-button w3-round-xxlarge w3-padding-large"> 
				<input type="submit" placeholder="전송" value="저장" 
				class="w3-button w3-round-xxlarge w3-padding-large" >
			</div>
	</form:form>
</div>
</section>
</body>
</html>