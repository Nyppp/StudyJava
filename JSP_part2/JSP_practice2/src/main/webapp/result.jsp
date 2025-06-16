<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>가입 결과</title>
</head>
<body>
    <%
        int result = (Integer)request.getAttribute("result");
        String name = (String)request.getAttribute("name");
    %>
    <h3>
        <%
            if(result > 0) {
        %>
                <%= name %>님, 가입이 완료되었습니다.
        <% } else { %>
            가입이 실패했습니다.
        <% } %>
    </h3>
</body>
</html>
