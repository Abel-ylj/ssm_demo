<%--
  Created by IntelliJ IDEA.
  User: yanglujian
  Date: 2021/1/9
  Time: 8:10 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/quick5" method="post">
        <input type="text" name="users[0].username">
        <input type="text" name="users[0].age">
        <input type="text" name="users[1].username">
        <input type="text" name="users[1].age">
        <input type="submit" value="提交">
    </form>
</body>
</html>
