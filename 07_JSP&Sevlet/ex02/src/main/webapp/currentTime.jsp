<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오전 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page import ="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>스크립트릿 실습</title>
</head>
<body>
    <h1>현재 날짜 출력 실습</h1>
    <%
        Date d = new Date();

        int sum = 0;
        for (int i=0; i<10; i++) {
            sum = sum + i;
        }

        Date d2 = null;

    %>
    현재 날짜: <%= d %> <br>
    1부터 10까지의 합: <%= sum %> <br>
    <% if(d2 != null) { %>
        <%= d2 %>
    <%}%>
</body>
</html>