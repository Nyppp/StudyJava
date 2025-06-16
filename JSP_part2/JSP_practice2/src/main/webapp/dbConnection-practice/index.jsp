<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*" %>


<%
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "1234";

    Class.forName("org.postgresql.Driver");
    out.println("드라이버 로딩 성공<br>");

    Connection conn = DriverManager.getConnection(url, user, password);
    out.println("DB 연결 성공");
%>