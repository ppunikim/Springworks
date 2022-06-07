<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>detail.jsp</title>
<style>
body {
 background-color: #efefef;
}
div.detail, div.btn-box {
	width: 80%;
	margin: 10px auto;
}
div.btn-box {
	text-align: right;
}
div.btn-box a {
	text-decoration: none;
	color: #666;
	display: inline-block;
	padding: 12px 16px;
	border-radius: 10px;
}
div.btn-box a:hover {
	box-shadow: 2px 2px 2px rgba(0,0,0,0.7);
}
a.list {
}
a.update {
}
a.delete {
}
.btn-neo {
        padding: 1rem 4rem;
        border-radius: 0.5rem;

        color: #444;
        font-size: 1rem;
        font-weight: 700;
        outline: none;
        cursor: pointer;
        border: none;
        box-shadow: -6px -6px 14px rgba(255, 255, 255, 0.7),
          -6px -6px 10px rgba(255, 255, 255, 0.5),
          6px 6px 8px rgba(255, 255, 255, 0.075),
          6px 6px 10px rgba(0, 0, 0, 0.15);
	}
.table_all {
	border: 1px solid #777;
	padding-left: 20px;
}
</style>
</head>
<body>
	<div class="detail table_all">
		<p>ISBN : ${BOOK.isbn}</p>
		<p>도서명: ${BOOK.title}</p>
		<p>저자: ${BOOK.author}</p>
		<p>출판사: ${BOOK.publisher}</p>
		<p>가격: ${BOOK.price}</p>
		<p>출판일자: ${BOOK.pubdate}</p>
	</div>
	<div class="btn-box">
		<a href="${rootPath}/books/list" class="list btn-neo">리스트로 gogo</a>
		<a href="${rootPath}/books/${BOOK.isbn}/update" class="update btn-neo">수정</a>
		<a href="javascript:void(0)" class="delete btn-neo">삭제</a>
	</div>
</body>
<script>
	document.querySelector("a.delete")?.addEventListener("click",()=>{
		if(confirm("정말 삭제할거니??")){
			document.location.replace("${rootPath}/books/${BOOK.isbn}/delete")
		}
		
	})
	
	
</script>







</html>