<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Online Shopping Mall</title>
</head>
<body>
<h1>Online Shopping Mall</h1>

<%
String[] products = {"Laptop","Mouse","Keyboard"};
int[] prices = {1000,20,50};
int totalPrice = 0;
%>

<h2>상품 목록:</h2>
<ul>
    <% for(int i=0; i
    <products.length
    ; i++){ %>
    <li><%= products[i] %>: <%= prices[i] %>원</li>
    <% totalPrice += prices[i]; %>
    <% } %>
</ul>

<!-- HTML 주석 -->
<%-- JSP 주석 --%>

<p>총 가격: <%= totalPrice %></p>
<p>평균 가격: <%= String.format("%.2f", (double)totalPrice / products.length) %>원</p>
<% if(totalPrice >= 1000) { %>
<p>배송 정보: 무료 배송</p>
<% } else { %>
<p>배송 정보: 배송비 3000원</p>
<% } %>
</body>
</html>
