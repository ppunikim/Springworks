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
	padding: 0;
	margin: 0;
}
html {
	width: 100vw;
	height: 100vh;
}
body {
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: #000000e0;
}

img {
	width: 120px;
} 
.main {
	border: 1px solid #ffff95;
	padding: 30px;
	background-color: #ffff95;
}
.main h3 {
	text-align: center;
}
.input_memo {
	width: 300px;
	height: 200px; 
}
#hs_footer {
	display:flex;
}
#hs_footer input:nth-of-type(2){
	margin-left: auto;
}

</style> 
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/function.js?ver=9"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<section class="main">
	<form:form modelAttribute="memoVO" enctype="multipart/form-data" class="main_memo">
		<h3>메모장</h3>
			<form:input path="m_author" readonly="readonly" type="hidden"/>
			<textarea 	name="m_memo" 
						class="w3-input w3-border input_memo" 
						placeholder="메모를 입력하세요." 
						autofocus="autofocus" 
						required="required" 
						autocomplete="off">${M_MEMO.m_memo}</textarea>
			<br>
			<input type="file" name="file" accept="images/*"
				   value="${rootPath}/upload/${M_MEMO.m_up_image}"
			onchange="setThumbnail(event)" multiple/>
			<div class="img-box">
			<c:if test="${not empty M_MEMO.m_up_image}">
				<img src="${rootPath}/upload/${M_MEMO.m_up_image}" class="img-img"
				 	 alt="이미지를 등록하세요."> 
			</c:if>
		</div>
			<br>
			<br>
			<div id="hs_footer" >
				<input type="reset"class="w3-button w3-round-xxlarge w3-padding-large"> 
				<input type="submit" placeholder="전송" value="저장" 
				class="w3-button w3-round-xxlarge w3-padding-large" >
			</div>
	</form:form>
</section>
</body>
</html>