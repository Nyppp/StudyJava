<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.Reservation" %>
<%@ page import="util.SecurityUtil" %>
<%
    List<Reservation> rList = (List<Reservation>)request.getAttribute("list");

    String resultName = (String)request.getAttribute("resultName");
    String resultDate = (String)request.getAttribute("resultDate");
%>


<html>
<head><title>예약 정보 조회</title></head>
<body>
<h2>예약 리스트</h2>
<p><a href="../hospital-reservation-system/index.jsp">메인 페이지로 돌아가기</a></p>

<%
    if(resultName != null && resultDate != null){
%>
    <h3><%= resultName %>님 <%= resultDate %> 일자에 예약 완료되었습니다.</h3>
<%} %>

<%
    if(rList == null || rList.isEmpty()){
%>
    <p><strong>예약 정보가 없습니다.</strong></p>
<% } else { %>
    <table border="1">
        <tr>
            <th>예약ID</th><th>환자이름</th><th>환자전화번호</th><th>의사이름</th><th>담당부서</th><th>예약일자</th><th>예약시각</th><th>증상</th><th>예약상태</th><th>예약 생성일</th>
        </tr>

        <%
            for(Reservation r : rList){
        %>
            <tr>
                <td><%= r.getId() %></td>
                <td><%= r.getPatient_name() %></td>
                <td><%= SecurityUtil.maskTelString(r.getPatient_phone()) %></td>
                <td><%= r.getDoctor_name() %></td>
                <td><%= r.getDepartment() %></td>
                <td><%= r.getReservation_date() %></td>
                <td><%= r.getReservation_time() %></td>
                <td><%= r.getSymptoms() %></td>
                <td><%= r.getStatus() %></td>
                <td><%= r.getCreated_at() %></td>
            </tr>
        <%}%>
    </table>
<% } %>
</body>
</html>