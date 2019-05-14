<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="DAO.IUserDAO" %><%--
  Created by IntelliJ IDEA.
  User: lsy
  Date: 2019/5/6
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = request.getParameter("username");
    String pass =request.getParameter("password");
    String type = request.getParameter("type");
    //获取spring配置文件
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    //通过配置文件拿到bean
    IUserDAO userDAO = (IUserDAO) context.getBean("userDao");
    boolean vaildate = false;
    if (type.equals("log")){
        if (userDAO.vaildateUser(name,pass)!=null){
            vaildate = true;
        }
        if (vaildate){
            request.getRequestDispatcher("welcome.jsp").forward(request,response);
        }
    }else if (type.equals("reg")){
        if (userDAO.registerUser(name,pass)){
            vaildate = true;
        }
        if (vaildate){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
%>
</body>
</html>
