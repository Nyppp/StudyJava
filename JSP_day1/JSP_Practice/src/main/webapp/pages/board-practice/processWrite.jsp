<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("utf-8");
    String title = request.getParameter("title");
    String content = request.getParameter("content");

    if(title == null || title.trim().isEmpty()){
        request.setAttribute("errorMsg", "Title is required");
        request.setAttribute("savedContent", content);
%>
    <jsp:forward page="writeForm.jsp" />
<%
    }else if (content == null || content.trim().isEmpty()){
        request.setAttribute("errorMsg", "Content is required");
        request.setAttribute("savedTitle", title);
%>
    <jsp:forward page="writeForm.jsp" />
<%
    }else{
        session.setAttribute("postTitle", title);
        session.setAttribute("postContent", content);
        session.setAttribute("successMsg", "Post created succesfully!");

        response.sendRedirect("boardList.jsp");
    }
%>