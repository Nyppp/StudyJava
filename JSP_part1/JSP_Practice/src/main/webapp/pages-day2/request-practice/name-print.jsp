<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("utf-8");
    String username = request.getParameter("username");
%>

<html>
<body>
    <h2>안녕하세요, <%= username %> 님!</h2>
</body>
</html>