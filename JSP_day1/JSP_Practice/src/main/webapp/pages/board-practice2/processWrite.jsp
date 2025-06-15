<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("utf-8");
    String title = request.getParameter("title");
    String content = request.getParameter("content");

    if(title == null || title.trim().isEmpty()){
%>
        <jsp:forward page="writeForm.jsp" />
<%
    }else if (content == null || content.trim().isEmpty()){
%>
        <jsp:forward page="writeForm.jsp" />
    <%
    }else{
        session.setAttribute("postTitle", title);
        session.setAttribute("postContent", content);
        response.sendRedirect("boardList.jsp");
    }
%>