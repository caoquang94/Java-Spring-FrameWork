<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: a2019
  Date: 2/12/20
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dictionary</title>
  </head>
  <body>
  <form action="/convert" method="get">
    <input type="text" name="ENG">
    <input type="submit">
  </form>
  <h1><c:choose>

    <c:when test = "${ENG == 'hello'}">
      hello is xin chao
    </c:when>

    <c:when test = "${ENG == 'school'}">
      school is truong hoc.
    </c:when>

    <c:when test = "${ENG == 'book'}">
      book is sach.
    </c:when>

    <c:otherwise>
      Not Found...
    </c:otherwise>
  </c:choose></h1>
  </body>
</html>
