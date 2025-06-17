<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>

<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("username");
    String hobby = request.getParameter("userhobby");


    String id = session.getId();
    long created = session.getCreationTime();
    long lastAccess = session.getLastAccessedTime();
    boolean isNew = session.isNew();

    Date cDate = new Date(created);
    Date lDate = new Date(lastAccess);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String createdTime = sdf.format(cDate);
    String lastTime = sdf.format(lDate);
%>

<html>
<body>
    <h1>유저 정보 조회 페이지</h1>
    <p>이름 : <%= name %></p>
    <p>관심분야 : <%= hobby %></p>

    <h2>세션 정보</h2>
    <p>세션 ID : <%= id%></p>
    <p>생성 시간 : <%= createdTime %></p>
    <p>마지막 접근 시간 : <%= lastTime %></p>
    <p>최초 방문? : <%= isNew %></p>

</body>
</html>