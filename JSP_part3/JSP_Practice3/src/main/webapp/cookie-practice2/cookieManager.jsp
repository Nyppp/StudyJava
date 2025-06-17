<%@ page contentType="text/html; charset=UTF-8"%>
<%
    Cookie[] cookies = request.getCookies();
%>

<html>
<head><title>사용자 쿠키 관리 페이지</title></head>
<body>
    <h2>사용자 쿠키</h2>
    <form method="post">
        <input type="submit" name="resetCookies" value="전체 쿠키 삭제">
    </form>

    <form method="get">
        <input type="text" name="searchName" placeholder="쿠키 이름 입력"
               value="<%= request.getParameter("searchName") != null ? request.getParameter("searchName") : "" %>">
        <input type="submit" value="특정 쿠키 삭제">
    </form>

    <a href="languageSettings.jsp">언어 설정으로 돌아가기</a>

    <%
    if (request.getParameter("resetCookies") != null) {
        for(Cookie cookie : cookies){
            if(!cookie.getName().equals("JSESSIONID")){
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        response.sendRedirect("cookieManager.jsp");
    }

    if (request.getParameter("searchName") != null) {
        for(Cookie cookie : cookies){
            if (cookie.getName().contains(request.getParameter("searchName"))) {
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
                break;
            }
        }
        response.sendRedirect("cookieManager.jsp");
    }
    %>
    <%

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
        <p><a href="languageSettings.jsp">쿠키 저장하기</a></p>
    <% } %>
</body>
</html>