<%@ page import="Bean.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: pankelong
  Date: 6/2/21
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="600px" border="1px">
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>分数</th>
    </tr>
    <% ArrayList<Student> students = (ArrayList<Student>) session.getAttribute("list");
        for (Student student : students) {%>
    <tr align="center">
        <td>${student.name}</td>
        <td>${student.age}</td>
        <td>${student.score}</td>
    </tr>
    <%}%>

</table>
</body>
</html>
</html>
