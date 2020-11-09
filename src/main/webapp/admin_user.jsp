<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/11/9
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>用户管理</title>
    <link type="text/css" rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
<script type="text/javascript" src="static/bootstrap/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
<div id="container">
    <div class="row">
        <div class="col-md-11">
            <table class="table table-striped">
                <tr>
                    <th>用户ID</th>
                    <th>用户姓名</th>
                    <th>用户性别</th>
                    <th>用户邮件</th>
                    <th>操 作</th>

                </tr>
                <c:forEach var="user" items="${user}">
                    <tr>
                        <th>${user.id}</th>
                        <th>${user.name}</th>
                        <th>${user.gender}</th>
                        <th>${user.email}</th>
                        <th><a href="/selectOne?id=${user.id}">update</a>|<a href="/deleteById?id=${user.id}">del</a></th>
                    </tr>
                </c:forEach>
                <tr>
                    <th><a href="insert.jsp">新增</a></th>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
