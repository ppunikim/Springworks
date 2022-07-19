<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"  />
<style>
	.page-box {
		width: 90%;
		margin: 15px auto;
		padding: 16px;
		border :1px solid tomato;
	}
	.page-body {
		list-style: none;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.page-item {
		margin: 4px;
	}
	.page-link {
		padding: 0.5rem 0.7rem;
		line-height: 1.25;
		color: tomato;
		text-decoration: none;
	}
	.page-link:hover {
		color: #eee;
		background-color: #E9ECF;
		border-color: tomato;
	}
	.page-item.active .page-link {
		color: #fff;
		background-color: tomato;
		border-color: tomato;
	}
</style>
<div class="page-box">
   <ul class="page-body">
      <c:if test="${PAGE.startPageNo>1}">
         <li class="page-item"><a href="${rootPath}?pageno=1"
            class="page-link">1</a></li>
      </c:if>
      <li class="page-item"><a
         href="${rootPath}?pageno=${PAGE.currentPageNo-1}" class="page-link">&lt;</a></li>

      <li><a class="page-link">&middot;&middot;&middot;&middot;</a></li>
      <c:forEach begin="${PAGE.startPageNo}" end="${PAGE.endPageNo}"
         var="page">
         <li
            class="page-item <c:if test="${PAGE.currentPageNo==page}">active</c:if>"><a
            href="${rootPath}?pageno=${page}" class="page-link">${page}</a></li>
      </c:forEach>
      <li class="page-item"><a
         href="${rootPath}?pageno=${PAGE.currentPageNo+1}" class="page-link">&gt;</a></li>
      <li><a class="page-link">&middot;&middot;&middot;&middot;</a></li>


      <c:if test="${PAGE.endPageNo != PAGE.finalPageNo}">
         <li class="page-item"><a
            href="${rootPath}?pageno=${PAGE.finalPageNo}" class="page-link">${PAGE.finalPageNo}</a></li>
      </c:if>
   </ul>
</div>