<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>

<html>
<head><title>개인 정보 입력</title></head>
<body>
<h2>개인 정보를 입력해주세요</h2>
<form action="output.jsp" method="post">
    <p>이름 : <input type="text" name="username"></p>
    <p>나이 : <input type="text" name="age"></p>
    <p>점수 : <input type="text" name="score"></p>
    <p>취미</p>
    <p><input type="checkbox" name="hobbies" value="코딩">코딩
    <input type="checkbox" name="hobbies" value="게임">게임
    <input type="checkbox" name="hobbies" value="운동">운동
    <input type="checkbox" name="hobbies" value="독서">독서</p>

    <input type="submit" value="제출">
</form>
</body>
</html>