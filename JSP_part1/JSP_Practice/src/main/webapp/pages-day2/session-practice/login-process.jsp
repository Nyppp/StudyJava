<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("utf-8");
    String username = request.getParameter("username");

    if(username != null){
        session.setAttribute("userName", username);
        response.sendRedirect("welcome.jsp");
    }else{
        response.sendRedirect("login.jsp");
    }
%>