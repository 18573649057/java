<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
    int arr[] = {3,5,3,6};
      ArrayList<Integer> list = new ArrayList<>();
      list.add(3);
      list.add(6);
    %>
  ${arr}
  ${list}
  </body>
</html>
