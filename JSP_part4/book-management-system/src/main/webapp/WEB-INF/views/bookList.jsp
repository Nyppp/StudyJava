<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head><title>도서 목록 조회</title></head>
<body>
    <h2>도서 목록</h2>
    <a href="${pageContext.request.contextPath}/index.jsp">메인 페이지로 돌아가기</a>
    <c:if test="${not empty insertedBookTitle}">
        <h3>"${insertedBookTitle}" 도서가 추가 완료되었습니다.</h3>
    </c:if>

    <c:if test="${not empty deletedBookTitle}">
        <h3>"${deletedBookTitle}" 도서가 삭제 완료되었습니다.</h3>
    </c:if>

    <c:if test="${not empty updatedBookTitle}">
        <h3>"${updatedBookTitle}" 도서가 수정 완료되었습니다.</h3>
    </c:if>
    <c:choose>
        <c:when test="${empty books}">
            <p>도서가 존재하지 않습니다.</p>
        </c:when>
        <c:otherwise>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>제목</th>
                        <th>저자</th>
                        <th>가격</th>
                        <th>출간일</th>
                        <th>설명</th>
                        <th>컬럼 생성일</th>
                        <th>컬럼 갱신일</th>
                        <th>수정</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.book_id}</td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.price}</td>
                        <td>${book.publishDate}</td>
                        <td>${book.description}</td>
                        <td>${book.createdAt}</td>
                        <td>${book.updatedAt}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/books/edit" method="get">
                                <input type="hidden" name="book_id" value="${book.book_id}">
                                <input type="submit" value="수정">
                            </form>
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/books/delete" method="post">
                                <input type="hidden" name="book_id" value="${book.book_id}">
                                <input type="hidden" name="title" value="${book.title}">
                                <input type="submit" value="삭제">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>