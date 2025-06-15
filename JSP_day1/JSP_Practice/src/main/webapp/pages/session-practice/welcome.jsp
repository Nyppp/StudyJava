<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String username = (String)session.getAttribute("userName");
%>

<html>
<body>
<h2>안녕하세요, <%= username %> 님!</h2>
</body>
</html>