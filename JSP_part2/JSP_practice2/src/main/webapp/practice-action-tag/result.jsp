<%@ page contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="model.UserInfo" scope="request" />
<jsp:setProperty name="user" property="*" />

<html>
<body>
<ul>
    <li>이름: <jsp:getProperty name="user" property="name" /></li>
    <li>나이: <jsp:getProperty name="user" property="age" /></li>
    <li>이메일: <jsp:getProperty name="user" property="email" /></li>
</ul>
</body>
</html>