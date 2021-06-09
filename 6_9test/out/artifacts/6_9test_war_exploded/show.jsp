<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>学生信息管理</title>
    </head>
    <body>
        <form action="selectBy" method="get">
            姓名：<input type="text" name="name">
            年龄：<input type="text" name="age">
            <input type="submit" value="查询">


        </form>

        <table border="1"  align="center" width="600px" style="margin: 0 auto">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
            </tr>
            <c:forEach items="${list}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>