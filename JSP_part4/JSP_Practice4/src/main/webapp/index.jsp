<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<html>
<head><title>영화 평점</title></head>
<body>
<h2>🎬 영화 평점 시스템</h2>

<form action="movieResult.jsp" method="post">
    영화 제목: <input type="text" name="title" placeholder="어벤져스"><br><br>
    평점:
    <select name="rating">
        <option value="1">1점</option>
        <option value="2">2점</option>
        <option value="3">3점</option>
        <option value="4">4점</option>
        <option value="5">5점</option>
    </select><br><br>
    관람료: <input type="number" name="price" placeholder="12000"><br><br>
    개봉일: <input type="date" name="releaseDate"><br><br>
    장르:
    <input type="checkbox" name="genre" value="액션">액션
    <input type="checkbox" name="genre" value="로맨스">로맨스
    <input type="checkbox" name="genre" value="코미디">코미디<br><br>
    <input type="submit" value="평점 등록">
</form>
</body>
</html>