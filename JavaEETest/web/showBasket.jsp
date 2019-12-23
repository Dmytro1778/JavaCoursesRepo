<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22.07.2019
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Show basket </title>
</head>
<body>
    <%@ page import="Logic.Basket" %>

    <% Basket basket = (Basket) session.getAttribute("basket"); %>

    <p> Name: <%= basket.getName() %></p>
    <p> Quantiy: <%= basket.getQuantity() %></p>
</body>
</html>
