<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<style>
	body {
        background-color: #efefef;
        flex-direction: column; 
	}
	header h2 {
		text-align: center;  
		margin-top: 30px;
		margin-bottom: 20px;
		color: #444;
	} 
	#first_div {
		border: none;
        box-shadow: -6px -6px 14px rgba(255, 255, 255, 0.7),
          -6px -6px 10px rgba(255, 255, 255, 0.5),
          6px 6px 8px rgba(255, 255, 255, 0.075),
          6px 6px 10px rgba(0, 0, 0, 0.15);
		box-sizing: border-box;
		width: 920px; 
		height: 510px; 
		margin: 10px auto;  
		padding: 5px 2px;
		
	}
	.btn-neo {
        padding: 10px 30px;
        border-radius: 0.5rem;
		margin-right: 7px;
	
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
	form div input, input {
		width: 450px;
		height: 40px;
		margin: 6px; 
	}
	form button {
		display: flex;
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
    width: 800px;
    height: 4em;
    resize: none;
    maring: 4px 6px;
  }
  button, a {
  	text-decoration: none;
  }
  #sec_div {
  	display: flex;
  	flex-shrink: 1;
  	justify-content: center;
  	margin-top: 30px;
  }
	input {
		width: 97%;
	}
</style>
	<header>
		<h2>책 정보 입력</h2>
	</header>
	<form method="POST" class="w3-container">
		<div id="first_div">
			<div>
				<input name="title"  class="w3-input"	id="title" placeholder="도서명 입력 후 Enter" value="${BOOK.title}"/>
				<input name="isbn" 	 class="w3-input"	id="isbn"  placeholder="ISBN"  value="${BOOK.isbn}" 
					<c:if test="${not empty BOOK.isbn}">
						readonly ="readonly"
					</c:if>
				>
				<input name="author"	 class="w3-input"	placeholder="저자" value="${BOOK.author}"/>
				<input name="link" 		 class="w3-input"	placeholder="자세히보기" value="${BOOK.link}"/>
			</div>
			<div>
				<input name="publisher"  class="w3-input"	placeholder="출판사"  value="${BOOK.publisher}"/>
				<input name="pubdate"	 class="w3-input"	placeholder="출판일"  value="${BOOK.pubdate}"/>
				<input name="price"		  class="w3-input"	placeholder="가격" type="number"  value="${BOOK.price}"/>
				<input name="discount"	 class="w3-input"	 	placeholder="할인 가격" type="number"  value="${BOOK.discount}"/>
			</div>
			<div>
				<input name="image"       class="w3-input"	placeholder="이미지경로"  value="${BOOK.image}"/>
			</div>
			<textarea name="description"  class="w3-input" placeholder="설명란">${BOOK.description}</textarea>
		</div>
		<div id="sec_div">
			<button type="button" class="btn btn-neo w3-button book-save">저장</button>
			<button type="reset" class="btn btn-neo w3-button">새로작성</button>
			<a href="${rootPath}/books/list" class="btn btn-neo w3-button">리스트보기</a>
		</div>
	</form>
