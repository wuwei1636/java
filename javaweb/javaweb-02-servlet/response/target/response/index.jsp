<html>
<body>
<%@ page contentType="text/html;" pageEncoding="utf-8" %>
<h2>Hello World!</h2>


<form action="${pageContext.request.contextPath}/login" method="get">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit">
</form>

</body>
</html>
