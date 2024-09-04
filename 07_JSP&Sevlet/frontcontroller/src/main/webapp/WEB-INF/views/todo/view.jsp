<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-08-01
  Time: 오전 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Todo 보기</h1>
    <div>
        <a href="list">목록보기</a>
        <a href="update">수정하기</a>
    </div>
    <form action="delete" method="POST">
        <input type="submit" value="삭제">
    </form>
</body>
</html>
