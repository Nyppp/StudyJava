<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>구구단</title>
</head>
<style>
    table, th, td {
      border : 1px solid #000;
    }
    th {
    background-color : #AAAAAA;
    }
    td {
      padding : 4px 8px;
      text-align: center;
    }

</style>
<body>
<%!
public String getStringData(int a, int b) {
return a + " * " + b + " = " + (a * b);
}
%>

<h2>구구단</h2>

<table>
    <tr>
        <% for(int i=2; i<=9; i++) { %>
        <th><%= i %> 단</th>
        <% } %>
    </tr>
    <% for(int b=1; b<=9; b++) { %>
    <tr>
        <% for(int a=2; a<=9; a++) { %>
        <td><%= getStringData(a, b) %></td>
        <% } %>
    </tr>
    <% } %>
</table>

</body>
</html>