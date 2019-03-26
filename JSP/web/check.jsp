<%@ page import="com.ryan.vo.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/22/022
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="service" class="com.ryan.service.UserServiceImpl"/>
<html>
<head>
    <title></title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String action=request.getParameter("action");
    String id=request.getParameter("id");
    boolean flag=false;
    switch (action){
        case "delete":
          flag= service.del(Integer.parseInt(id));
          if(flag){
              response.sendRedirect("index.jsp");
          }
          break;
        case "add":
            User user=new User();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            String id1=request.getParameter("id");
            if(id1!=""){//修改
                user.setId(Integer.parseInt(id1));
                flag=service.updateByQueryId(user);
            }else {
                flag = service.add(user);
            }
            if (flag){
                response.sendRedirect("index.jsp");
            }
            break;

    }
%>
</body>
</html>
