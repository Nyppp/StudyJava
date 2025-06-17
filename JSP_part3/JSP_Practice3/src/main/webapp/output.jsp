<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%
    Integer visitCount = (Integer)session.getAttribute("visitCount");
    if(visitCount == null){
        visitCount = 1;
    }else{
        visitCount++;
    }
    session.setAttribute("visitCount", visitCount);
%>
<html>
<body>
    <h2>사용자 정보 페이지</h2>
    <p>이름 : ${param.username} </p>
    <p>나이 : ${param.age} </p>
    <p>점수 : ${param.score} </p>

    <br>
    <p>나이 + 5 :${param.age + 5} </p>
    <p>점수가 80 이상인가: ${param.score >= 80}</p>

    <br>
    <p>등급 : ${param.score >=90 ? "우수" : param.score >= 80 ? "보통" : "부족"}</p>

    <br>
    <p>첫번째 취미 : ${paramValues.hobbies[0] == null ? "없음" : paramValues.hobbies[0]}</p>
    <p>취미 갯수 :${paramValues.hobbies[0] == null ? 0 : paramValues.hobbies[1] == null ? 1 :
        paramValues.hobbies[2] == null? 2 : paramValues.hobbies[3]==null? 3 : 4} </p>

    <br>
    <p>요청 방식 :${pageContext.request.method} </p>
    <p>브라우저 정보 : ${header['User-Agent']}</p>

    <br>
    <p>방문 횟수 : ${sessionScope.visitCount}</p>
</body>
</html>