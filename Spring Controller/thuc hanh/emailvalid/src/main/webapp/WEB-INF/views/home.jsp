<%--
  Created by IntelliJ IDEA.
  User: congson
  Date: 16/02/2020
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Email Validate</h1>

<h3>${message}</h3>




<form action="/validate" method="post">

    <input type="text" name="email"><br>

    <input type="submit" value="Validate">

</form>
</body>
</html>
