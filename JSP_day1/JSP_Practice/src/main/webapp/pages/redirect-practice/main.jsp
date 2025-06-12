<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String loginUser = (String)session.getAttribute("loginUser");
    if(loginUser == null){
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
<body>
    <h1>환영합니다, <%= loginUser %> 님!</h1>
    <a href="logout.jsp">로그아웃</a>
</body>
</html>