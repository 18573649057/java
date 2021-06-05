<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>查看学生</title>
    </head>
    <body>
        <h3>用户信息</h3>
        <table>
            <tr><td>ID</td><td>姓名</td><td>年龄</td></tr>
            <c:forEach items="${students}" var="s">

                <tr><td>${s.id}</td><td>${s.name}</td><td>${s.age}</td></tr>
            </c:forEach>

        </table>


    </body>
</html>
