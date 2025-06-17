<%@ page contentType="text/html; charset=UTF-8"%>
<%
    Cookie usernameCookie = new Cookie("savedUsername", "NYP");
    Cookie themeCookie = new Cookie("userTheme", "dark");

    usernameCookie.setMaxAge(60*60*24*7); //쿠키 생명주기 설정 7일
    themeCookie.setMaxAge(60*60*24*30); //쿠키 생명주기 설정 30일

    usernameCookie.setPath("/"); //슬래시만 쓰면, 기본 도메인 경로 (전체 경로에서 적용 가능)
    themeCookie.setHttpOnly(true); //http에서만 사용

    //respsone 객체에 담아 전달
    response.addCookie(usernameCookie);
    response.addCookie(themeCookie);
%>

<html>
<head><title>쿠키 저장</title></head>
<body>
    <h2>쿠키가 저장되었습니다.</h2>
    <p>저장된 쿠키 : </p>
    <ul>
        <li><strong>savedUsername : NYP</strong></li>
        <li><strong>userTheme : dark</strong></li>
    </ul>

    <p><em>쿠키는 브라우저에 저장되며, 개발자 도구에서 확인할 수 있습니다.</em></p>
    <a href="cookieRead.jsp">쿠키 읽기</a>
</body>
</html>