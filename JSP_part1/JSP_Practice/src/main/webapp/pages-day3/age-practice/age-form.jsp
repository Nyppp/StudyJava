<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<body>
    <form action="process-age.jsp" method="post">
        <p>이름을 입력해주세요 : <input type="text" name="username"></p>
        <p>태어난 년도를 입력해주세요 : <input type="text" name="userbirth"></p>
        <input type="submit" value="제출">
    </form>


    <h1>이전 정보 (세션 저장)</h1>
    <%
        String name = (String)session.getAttribute("userName");
        String birthString = (String)session.getAttribute("userBirth");

        if(name != null && birthString != null){
            int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
            int birth = Integer.parseInt(birthString);
    %>
            <h2>유저 정보</h2>
            <p>이름 : <%= name %></p>
            <p>생일 : <%= birth %></p>
            <br>
            <h2>나이 계산</h2>
            <p>만나이 : <%= currentYear - birth %></p>
            <p>표준나이 : <%= currentYear - birth +1 %></p>
            <br>
            <h2>접속 정보</h2>
            <p>ip 정보 : <%=request.getRemoteAddr()%></p>
            <p>브라우저 정보 : <%=request.getHeader("User-Agent")%></p>
    <% } %>
</body>
</html>