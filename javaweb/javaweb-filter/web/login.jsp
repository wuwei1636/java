<%--
  Created by IntelliJ IDEA.
  User: 李坤松
  Date: 2022/5/8
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="text" name="username">
        <input type="submit">
    </form>
</body>
</html>
