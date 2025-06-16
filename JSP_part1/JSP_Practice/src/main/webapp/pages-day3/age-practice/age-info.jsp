<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<body>
    <%
        String name = (String)session.getAttribute("userName");
        int birth = Integer.parseInt((String)session.getAttribute("userBirth"));

        if(name != null){
            int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    %>
            <h1>유저 정보</h1>
            <p>이름 : <%= name %></p>
            <p>생일 : <%= birth %></p>
            <br>
            <h1>나이 계산</h1>
            <p>만나이 : <%= currentYear - birth %></p>
            <p>표준나이 : <%= currentYear - birth +1 %></p>
            <br>
            <h1>접속 정보</h1>
            <p>ip 정보 : <%=request.getRemoteAddr()%></p>
            <p>브라우저 정보 : <%=request.getHeader("User-Agent")%></p>
    <% } %>

</body>
</html>
