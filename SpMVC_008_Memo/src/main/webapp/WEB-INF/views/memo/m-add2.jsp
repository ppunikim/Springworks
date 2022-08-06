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


img {
	width: 120px;
} 

.main h3 {
	text-align: center;
}
.input_memo {
	width: 300px;
	height: 200px; 
}
section {
	width: 100%;
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
	<form:form modelAttribute="memoVO" enctype="multipart/form-data" class="main_memo">
		<h3>메모장</h3>
			<form:input path="m_author" readonly="readonly" type="hidden"/>
			<textarea 	name="m_memo" 
						id="MEMO"
						class="w3-input w3-border input_memo" 
						placeholder="메모를 입력하세요." 
						autofocus="autofocus" 
						required="required" 
						autocomplete="off">${M_MEMO.m_memo}</textarea>
			<br>
			<label for="put">파일 등록</label>
			<input type="file" name="file" accept="images/*"
				   value="${rootPath}/upload/${M_MEMO.m_up_image}" id="put"
			onchange="setThumbnail(event)" multiple/>
			<div class="img-box">
			<c:if test="${not empty M_MEMO.m_up_image}">
				<img src="${rootPath}/upload/${M_MEMO.m_up_image}" class="img-img"> 
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