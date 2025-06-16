<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String userId = request.getParameter("userId");
    String password = request.getParameter("password");

    if ("admin".equals(userId) && "1234".equals(password)){
        session.setAttribute("loginUser", userId);
        response.sendRedirect("main.jsp");
    } else {
        response.sendRedirect("login.jsp?error=1");
    }
%>