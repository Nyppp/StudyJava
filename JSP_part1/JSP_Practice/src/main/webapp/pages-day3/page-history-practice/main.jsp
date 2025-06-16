<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="java.util.*, java.text.*" %>

<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date now = new Date();

    List<String> ipList = (List)session.getAttribute("ip");
    List<String> dateList = (List)session.getAttribute("time");
%>

<html>
<body>
<h2>현재 방문 정보</h2>
<p>접속 IP : <%= request.getRemoteAddr() %></p>
<p>접속 시각 : <%= sdf.format(now) %></p>

<form method="post">
    <input type="submit" name="reset" value="세션 기록 초기화">
</form>

<%
    if (request.getParameter("reset") != null) {
        session.removeAttribute("ip");
        session.removeAttribute("time");

        ipList.clear();
        dateList.clear();
    }

    if(ipList == null){
        ipList = new ArrayList<>();
    }

    if(dateList == null){
        dateList = new ArrayList<>();
    }

    ipList.add(request.getRemoteAddr());
    dateList.add(sdf.format(now));

    session.setAttribute("time", dateList);
    session.setAttribute("ip", ipList);
%>


<h2>이전 방문 정보 (IP / 접속 시각)</h2>
<%
    for(int i = 0 ; i < ipList.size(); i++){
        out.print(i+1 + "번째 방문 정보) IP:" + ipList.get(i) + " 방문 시각 : " + dateList.get(i) + "<br>");
    }
%>

</body>
</html>
