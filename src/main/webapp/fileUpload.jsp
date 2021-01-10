<%--
  Created by IntelliJ IDEA.
  User: yanglujian
  Date: 2021/1/10
  Time: 3:27 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>多文件上传</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/fileUpload3" method="post" enctype="multipart/form-data">
        名称<input type="text" name="username"><br/>
        文件1<input type="file" name="files"><br/>
        文件2<input type="file" name="files"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
