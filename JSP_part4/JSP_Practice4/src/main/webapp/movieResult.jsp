<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head><title>영화 정보</title></head>

<body>
    <h2>영화 기본 정보</h2>
    <p>영화 제목 : <strong>${param.title}</strong></p>
    <p>평점 : <strong> <c:forEach var="i" begin="1" end="${param.rating}">⭐</c:forEach></strong></p>
    <p>관람료 : <strong><fmt:formatNumber value="${param.price}" type="currency"/></strong></p>
    <p>할인가(-20%) : <strong><fmt:formatNumber value="${param.price * 0.8}" type="currency"/></strong></p>
    <p>개봉일 : <strong>
        <fmt:parseDate value="${param.releaseDate}" pattern="yyyy-MM-dd" var="date"/>
        <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
    </strong></p>

    <h2>추가 정보</h2>
    <p>평점 등급 :
        <strong>
            <c:choose>
                <c:when test="${param.rating == 5}">
                    최고
                </c:when>
                <c:when test="${param.rating == 4}">
                    좋음
                </c:when>
                <c:when test="${param.rating == 3}">
                    보통
                </c:when>
                <c:when test="${param.rating == 2}">
                    별로
                </c:when>
                <c:when test="${param.rating == 1}">
                    최악
                </c:when>
            </c:choose>
        </strong></p>
    <p>제목 길이 :
        <strong>
            <c:if test="${fn:length(param.title) > 10}">긴 제목</c:if>
            <c:if test="${fn:length(param.title) <= 10 && fn:length(param.title) >= 5}">적당한 제목</c:if>
            <c:if test="${fn:length(param.title) < 5}">짧은 제목</c:if>
        </strong></p>
    <p>선택한 장르 :
        <strong>
            <c:choose>
                <c:when test="${fn:length(paramValues.genre) == 0}">
                    선택한 장르 없음
                </c:when>
                <c:otherwise>
                    <c:forEach var="i" begin="0" end="${fn:length(paramValues.genre)}">
                        ${paramValues.genre[i]}
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </strong></p>

</body>
</html>