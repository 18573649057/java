<%--
  Created by IntelliJ IDEA.
  User: pankelong
  Date: 6/12/21
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="get">
    账号：<input type="text" id="username"><span id="span"></span><br>
    密码：<input type="password" id="password"><br>
    <input type="submit" value="注册">
  </form>

  </body>
<script src="jquery-3.3.1.min.js"></script>
<script>
  $("#username").blur(function(){
    var name= $("#username").val();
    $.ajax({
      url:"userServlet",
      data:"name="+name,
      type:"GET",
      datatype:"text",
      success:function(data) {
        $("#span").html(data);
      },
      error:function(data){
        alert("操作失败...");
      }
    })
  })

</script>
</html>
