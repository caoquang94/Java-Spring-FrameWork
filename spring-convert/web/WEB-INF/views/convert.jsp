<%--
  Created by IntelliJ IDEA.
  User: a2019
  Date: 2/12/20
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>convert</title>
</head>
<body>
<form action="/convert">
<input type="number" name="usd">
<input type="submit">
</form>
<h1>${usd} USD = ${usd*23000} VND</h1>
</body>
</html>
