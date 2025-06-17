<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<body>
    <h2>저장된 쿠키 정보</h2>
    <%
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
    %>
        <table border="1">
            <tr><th>쿠키 이름</th><th>쿠키 값</th><th>만료시간(초)</th></tr>
            <%
                for(Cookie cookie : cookies){
                    String name = cookie.getName();
                    String value = cookie.getValue();
                    int maxAge = cookie.getMaxAge();
            %>
                    <tr>
                        <td><strong><%= name %></strong></td>
                        <td><strong><%= value %></strong></td>
                        <td><strong><%= maxAge == -1? "브라우저 종료시" : maxAge + "초"%></strong></td>
                    </tr>
            <%
                }
            %>
        </table>
    <% } else { %>
        <p>저장된 쿠키가 없습니다.</p>
        <p><a href="index.jsp">쿠키 저장하기</a></p>
    <% } %>
</body>
</html>