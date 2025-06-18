<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<html>
<head><title>환자 예약 정보 사이트</title></head>
<body>

<h2>환자 예약 정보 사이트</h2>
<form action="reservation" method="get">
    <input type="submit" value="환자 예약 정보 조회하기">
</form>

<h2>예약 추가하기</h2>
<form action="reservation" method="post">
    <p>환자 이름 : <input type="text" name="patient_name"></p>
    <p>환자 전화번호 : <input type="text" name="patient_phone"></p>
    <p>의사 이름 : <input type="text" name="doctor_name"></p>
    <p>담당부서 : <input type="text" name="department"></p>
    <p>예약일 : <input type="date" name="reservation_date"></p>
    <p>예약시각 : <input type="time" name="reservation_time"></p>
    <p>증상 : <input type="text" name="symptoms"></p>
    <p>예약 상태 : <input type="text" name="status"></p>
    <input type="submit" value="예약하기">
</form>
</body>
</html>
