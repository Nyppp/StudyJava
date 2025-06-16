<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("utf-8");
    String username = request.getParameter("username");
    String userbirth = request.getParameter("userbirth");

    session.setAttribute("userName", username);
    session.setAttribute("userBirth", userbirth);

    response.sendRedirect("age-info.jsp");
%>