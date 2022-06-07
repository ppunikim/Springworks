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
		margin-top: 90px;
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
		width: 950px; 
		height: 330px; 
		margin: 30px auto;  
		padding: 5px 2px;
		
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
  	margin: 10px;
  	text-decoration: none;
  }
  #sec_div {
  	display: flex;
  	flex-shrink: 1;
  	justify-content: center;
  }

</style>
	<header>
		<h2>책 정보 입력</h2>
	</header>
	<form method="POST" >
		<div id="first_div">
			<div>
				<input name="title" 	id="title" placeholder="도서명 입력 후 Enter" value="${BOOK.title}"/>
				<input name="isbn" 		id="isbn"  placeholder="ISBN"  value="${BOOK.isbn}" 
					<c:if test="${not empty BOOK.isbn}">
						readonly ="readonly"
					</c:if>
				>
				<input name="author"		placeholder="저자" value="${BOOK.author}"/>
				<input name="link" 			placeholder="자세히보기" value="${BOOK.link}"/>
			</div>
			<div>
				<input name="publisher" 	placeholder="출판사"  value="${BOOK.publisher}"/>
				<input name="pubdate"		placeholder="출판일"  value="${BOOK.pubdate}"/>
				<input name="price"		 	placeholder="가격" type="number"  value="${BOOK.price}"/>
				<input name="discount"		 	placeholder="할인 가격" type="number"  value="${BOOK.discount}"/>
			</div>
			<div>
				<input name="image" 		placeholder="이미지경로"  value="${BOOK.image}"/>
			</div>
			<textarea name="description" placeholder="설명란">${BOOK.description}</textarea>
		</div>
		<div id="sec_div">
			<button type="submit" class="btn btn-neo">저장</button>
			<button type="submit" class="btn btn-neo">새로작성</button>
			<a href="${rootPath}/books/list" class="btn btn-neo">리스트보기</a>
		</div>
	</form>
