<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head><title>도서 관리 시스템</title></head>
<body>
<h2>도서 관리 시스템 메인페이지</h2>

<p><a href="${pageContext.request.contextPath}/books">도서 조회 / 편집(수정, 삭제)</a></p>
<p><a href="${pageContext.request.contextPath}/books/add">도서 추가</a></p>

</body>
</html>
