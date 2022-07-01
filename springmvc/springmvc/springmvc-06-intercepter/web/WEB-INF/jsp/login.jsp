<%--
  Created by IntelliJ IDEA.
  User: 李坤松
  Date: 2022/6/30
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>


<%--在web-inf下的所有界面不能直接访问，只能通过controller和servlet访问--%>

<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名: <input type="text" name="username">
    密码: <input type="text" name="password">
    <input type="submit" value="提交">
</form>

</body>
</html>
