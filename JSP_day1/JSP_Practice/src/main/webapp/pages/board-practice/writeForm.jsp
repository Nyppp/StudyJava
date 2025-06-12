<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Write Post</title>
</head>
<body>
    <h1>Write New Post</h1>
    <%
        String errorMsg = (String)request.getAttribute("errorMsg");
        String savedTitle = (String)request.getAttribute("savedTitle");
        String savedContent = (String)request.getAttribute("savedContent");

        if(errorMsg != null){%>
            <p style="color: red;">Error : <%= errorMsg %></p>

    <%} %>

    <form action="processWrite.jsp" method="post">
        <p>Title : <input type="text" name="title" value="<%= savedTitle != null ? savedTitle : "" %>"></p>
        <p>Content : <textarea type="text" name="content"><%= savedContent != null ? savedContent : "" %></textarea></p>
        <p><input type="submit" value="Submit"></p>
    </form>
</body>
</html>