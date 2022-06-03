<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<style>
	form {
		display: flex;
		flex-direction: column;
		width: 80%;
	}
	form div {
		flex: 1;
	}
	.btn-gray {
		background-color: gray;
		color: white;
		border-radius: 10px;
		border: 1px solid transparent;
		padding: 7px;
	}
	.btn-tomato{
		background-color: tomato;
		border-radius: 10px;
		color: black;
		border: 1px solid transparent;
		padding: 7px;
	}
	.btn-sky {
		background-color: skyblue;
		color: black;
		border-radius: 10px;
		border: 1px solid transparent;
		padding: 7px;
	}
	textarea {
    width: 80%;
    height: 6.25em;
    resize: none;
  }
</style>
	<form method="POST" >
		<div>
			<input name="isbn" 		id="isbn"  placeholder="ISBN" />
			<input name="title" 	id="title" placeholder="도서명 입력 후 Enter" />
		</div>
		<div>
			<input name="author"		placeholder="저자"/>
			<input name="publisher" 	placeholder="출판사" />
			<input name="pubdate"		placeholder="출판일" />
			<input name="price"		 	placeholder="가격" type="number" />
		</div>
		<div>
			<input name="link" 			placeholder="자세히보기"/>
			<input name="image" 		placeholder="이미지경로" />
		</div>
		<textarea rows="10"></textarea>
	</form>
		<button type="submit" class="btn-gray">저장</button>
		<button type="submit" class="btn-tomato">새로작성</button>
		<button type="submit" class="btn-sky">리스트보기</button>
