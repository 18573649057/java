<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<form method="get" action="/stu_web/addStudentServlet">
    姓名：<input type="text" name="name">
    年龄：<input type="number" name="age">
    <button type="submit" >添加</button>
</form>
</body>
</html>
