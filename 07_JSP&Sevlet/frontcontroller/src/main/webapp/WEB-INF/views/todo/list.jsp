<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-08-01
  Time: 오전 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Todo 목록 보기</h1>
    <div>
        ${todoList}
        <a href="view">상세보기</a>
    </div>
    <div>
        <a href="create">새로운 Todo</a>
    </div>
</body>
</html>
