<%--
  Created by IntelliJ IDEA.
  User: 李坤松
  Date: 2022/6/29
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
    <div class="container">

        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>修改书籍</small>
                    </h1>
                </div>
            </div>
        </div>

        <form action="${pageContext.request.contextPath}/book/changeBook" method="post">
<%--            出现的问题，我们的sql语句失败，添加事务后仍然失败，发现是sql语句中的id没有传入导致失败--%>
<%--            解决办法：前端传递隐藏域--%>
            <input type="hidden" name="bookID" value="${qbooks.bookID}">
            <div class="form-group">
                <label >书籍名称</label>
                <input type="text" name="bookName" class="form-control" value="${qbooks.bookName}" required>
            </div>
            <div class="form-group">
                <label >书籍数量</label>
                <input type="text" name="bookCounts" class="form-control" value="${qbooks.bookCounts}" required>
            </div>
            <div class="form-group">
                <label>书籍描述</label>
                <input type="text" name="detail" class="form-control" value="${qbooks.detail}" required>
            </div>
            <button type="submit" class="btn btn-default">修改</button>
        </form>

    </div>
</body>
</html>
