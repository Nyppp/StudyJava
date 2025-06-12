<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%

%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Board List</title>
</head>
<body>
    <h1>Board List</h1>
    <%
        String successMsg = (String)session.getAttribute("successMsg");
        if(successMsg != null){
            session.removeAttribute("successMsg");
    %>
            <p style="color: green"><%= successMsg %></p>
    <%
        }
        String postTitle = (String)session.getAttribute("postTitle");
        String postContent = (String)session.getAttribute("postContent");

        if(postTitle != null){
    %>
            <h3>Lastest Post:</h3>
            <p><strong>Title:</strong> <%=postTitle%></p>
            <p><strong>Content:</strong> <%=postContent%></p>
    <%
        }else {
    %>
        <p>No posts available.</p>
    <%
        }
    %>
    <p><a href="writeForm.jsp">Write New Post</a></p>
</body>
</html>