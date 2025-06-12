<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 1. 변수 설정/출력 -->
<c:set var="name" value="홍길동" /><c:set var="age" value="25" /><c:set var="score" value="85" />
<p>이름: <c:out value="${name}" /> | 나이: ${age} | 점수: ${score}</p>

<!-- 2. 조건문 (if) -->
<c:if test="${age >= 20}"><p style="color:green;">성인입니다 (${age}세)</p></c:if>
<c:if test="${score >= 80}"><p style="color:blue;">우수 성적!</p></c:if>

<!-- 3. 다중 조건문 (choose) -->
<p>등급: <c:choose><c:when test="${score >= 90}">A등급</c:when><c:when test="${score >= 80}">B등급</c:when><c:otherwise>C등급</c:otherwise></c:choose></p>

<!-- 4. 반복문 - 컬렉션 -->
<c:set var="fruits" value="사과,바나나,오렌지" />
<p>과일: <c:forEach var="fruit" items="${fruits}" varStatus="s">${s.count}.${fruit} </c:forEach></p>

<!-- 5. 반복문 - 숫자 범위 -->
<p>숫자: <c:forEach var="i" begin="1" end="5" step="2">[${i}] </c:forEach></p>

<!-- 6. URL 생성 -->
<c:url var="userUrl" value="user.jsp"><c:param name="id" value="123"/><c:param name="tab" value="profile"/></c:url>
<p>링크: <a href="${userUrl}">사용자 페이지</a></p>

<!-- 7. 폼 파라미터 처리 -->
<c:if test="${not empty param.username}">
    <c:choose><c:when test="${param.username == 'admin'}"><p style="color:red;">관리자 로그인</p></c:when>
        <c:otherwise><p>환영합니다, ${param.username}님!</p></c:otherwise></c:choose>
</c:if>

<!-- 8. 배열/리스트 처리 예제 -->
<c:set var="users" value="김철수:30,이영희:25,박민수:35" />
<table border="1"><tr><th>번호</th><th>이름</th><th>나이</th><th>상태</th></tr>
    <c:forEach var="user" items="${users}" varStatus="status">
        <c:set var="info" value="${user.split(':')}" />
        <tr><td>${status.count}</td><td>${info[0]}</td><td>${info[1]}</td>
            <td><c:if test="${info[1] >= 30}">시니어</c:if><c:if test="${info[1] < 30}">주니어</c:if></td></tr>
    </c:forEach></table>

<!-- 9. 테스트 폼 -->
<form><input name="username" placeholder="사용자명" value="${param.username}">
    <input name="age" type="number" placeholder="나이" value="${param.age}"><input type="submit" value="제출"></form>