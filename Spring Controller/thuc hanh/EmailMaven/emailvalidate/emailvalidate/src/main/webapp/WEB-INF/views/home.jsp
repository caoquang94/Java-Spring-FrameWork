<%--
  Created by IntelliJ IDEA.
  User: a2019
  Date: 2/14/20
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<h1>Email Validate</h1>
<h3 style="color: red">${message}</h3>

<form action="validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" name="Validate">
</form>
</body>
</html>
