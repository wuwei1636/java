<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 李坤松
  Date: 2022/5/3
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>

<%
    ArrayList<String > people = new ArrayList<>();
    people.add(0,"张三");
    people.add(1,"田七");
    people.add(2,"赵六");
    people.add(3,"王五");
    people.add(4,"里斯");

    request.setAttribute("list",people);
%>

    <form action="hello.jsp" method="get">

        <input type="text" name="username" value="${param.username}">
        <input type="submit" value="登录">
    </form>

    <c:forEach var="people" items="${list}">
        <c:out value="${people}"/> <br>
    </c:forEach>

    <c:if test="${param.username == 'admin'}" var="admincheck">
        <c:out value="管理员欢迎你"/>
    </c:if>

    <c:set value="111" var="scope"/>
    <c:choose>
        <c:when test="${scope > 90}">
            <c:out value="你的成绩为优秀"/>
        </c:when>
        <c:when test="${scope > 80}">
            <c:out value="你的成绩为良好"/>
        </c:when>
        <c:when test="${scope > 70}">
            <c:out value="你的成绩为一般"/>
        </c:when>
        <c:when test="${scope > 60}">
            <c:out value="你的成绩为及格"/>
        </c:when>
    </c:choose>

</body>
</html>
