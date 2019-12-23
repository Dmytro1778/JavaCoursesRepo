<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21.07.2019
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> First JSP </title>
</head>
<body>
    <h1> Testing JSP </h1>
    <p>
        <%
            String name = request.getParameter("name");
        %>

        <%= "Hello, " + name %>
    </p>
</body>
</html>
