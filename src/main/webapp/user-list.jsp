<%--
  Created by IntelliJ IDEA.
  User: yanglujian
  Date: 2021/1/13
  Time: 10:40 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<table border="1">

    <tr>
        <th>id</th>
        <th>username</th>
        <th>password</th>
        <th>gender</th>
        <th>age</th>
        <th>address</th>
        <th>qq</th>
        <th>email</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <th>${user.id}</th>
            <th>${user.username}</th>
            <th>${user.password}</th>
            <th>${user.gender}</th>
            <th>${user.age}</th>
            <th>${user.address}</th>
            <th>${user.qq}</th>
            <th>${user.email}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
