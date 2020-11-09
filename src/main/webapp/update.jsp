<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/11/9
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/update" method="post">
        <input type="hidden" name="id" value="${user.id}"><br>
        用户姓名:<input type="text" name="name" value="${user.name}"><br>
        用户性别:<input type="text" name="gender" value="${user.gender}"><br>
        用户邮件:<input type="email" name="email" value="${user.email}"><br>
        <input type="submit" value="提交修改">
    </form>
</div>
</body>
</html>

