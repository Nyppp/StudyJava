<%@ page contentType="text/html; charset=UTF-8"%>
<%
    String targetCookieName = "savedUserLanguage";
    String cookieValue = null;

    Cookie[] cookies = request.getCookies();
    if(cookies != null){
        for(Cookie cookie : cookies){
            if(targetCookieName.equals(cookie.getName())){
                cookieValue = cookie.getValue();
                break;
            }
        }
    }
%>

<html>
<head><title>언어 설정 페이지</title></head>
<body>
    <h2>사용할 언어를 선택해주세요.</h2>
    <h3>현재 설정 중인 언어 : <%= (cookieValue != null) ? cookieValue : "N/A" %></h3>
    <form method="post">
        <input type="radio" name="userLanguage" value="KO"> 한국어
        <input type="radio" name="userLanguage" value="EN"> 영어
        <input type="radio" name="userLanguage" value="JP"> 일본어
        <p><input type="submit" value="제출"></p>
    </form>

    <%
        if(request.getParameter("userLanguage") != null){
            String userLanguage = request.getParameter("userLanguage");
            Cookie userLanguageCookie = new Cookie("savedUserLanguage", userLanguage);

            userLanguageCookie.setMaxAge(60*60*24*30);
            userLanguageCookie.setPath("/");

            //respsone 객체에 담아 전달
            response.addCookie(userLanguageCookie);
            response.sendRedirect("cookieManager.jsp");
        }
    %>
</body>
</html>