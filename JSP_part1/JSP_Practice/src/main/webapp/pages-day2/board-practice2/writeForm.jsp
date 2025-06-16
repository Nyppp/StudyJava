<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
    <h1>게시물 작성하기</h1>
    <form action="processWrite.jsp" method="post">
        <p>글 제목 : <input type="text" name="title"></p>
        <p>글 내용 : <textarea type="text" name="content"></textarea></p>
        <input type="submit" value="작성하기">
    </form>
</body>
</html>