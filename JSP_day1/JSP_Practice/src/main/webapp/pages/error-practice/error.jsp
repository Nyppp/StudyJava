<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>error page</title>
</head>
<body>
    <h3>에러 정보</h3>
        <p><%= exception.getMessage() %></p>
</body>
</html>