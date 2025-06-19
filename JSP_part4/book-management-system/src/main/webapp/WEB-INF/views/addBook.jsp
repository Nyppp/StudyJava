<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head><title>도서 추가 페이지</title></head>
<body>
    <h2>추가할 도서 정보</h2>
    <a href="${pageContext.request.contextPath}/index.jsp">메인 페이지로 돌아가기</a>
    <form action="${pageContext.request.contextPath}/books/add" method="post">
        <p>제목 : <input type="text" name="title" value="${title}">
            <strong style="color:red">${errors.title}</strong>
        </p>
        <p>저자 : <input type="text" name="author" value="${author}">
            <strong style="color:red">${errors.author}</strong>
        </p>
        <p>가격 : <input type="number" name="price" value="${price}">
            <strong style="color:red">${errors.price}</strong>
        </p>
        <p>출간일 : <input type="date" name="publishDate" value="${publishDate}">
            <strong style="color:red">${errors.publishDate}</strong>
        </p>
        <p>설명 : <input type="text" name="description" value="${description}">
            <strong style="color:red">${errors.description}</strong>
        </p>
        <input type="submit" value="추가">
    </form>
</body>
</html>