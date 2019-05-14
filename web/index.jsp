<%--
  Created by IntelliJ IDEA.
  User: lsy
  Date: 2019/5/6
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="vaildate.jsp?type=log" name="form1" method="post">
    账号：<input type="text" name="username"><br>
    密码：<input type="text" name="password"><br>
    <input type="submit" value="登录">
    <a href="vaildate.jsp?type=reg">
      <button onclick="reg()">注册</button>
    </a>
  </form>

  <script>
    function reg() {
      document.form1.action = "vaildate.jsp?type=reg";
      document.form1.submit();
    }
  </script>
  </body>
</html>
