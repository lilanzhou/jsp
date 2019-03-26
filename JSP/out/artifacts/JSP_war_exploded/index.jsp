<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/22/022
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.ryan.service.UserServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ryan.vo.User" %>


<title>课堂练习</title>
<meta charset="utf-8">
<style>
    .username.ng-valid {
        background-color: lightgreen;
    }

    .username.ng-dirty.ng-invalid-required {
        background-color: red;
    }

    .username.ng-dirty.ng-invalid-minlength {
        background-color: yellow;
    }

    .email.ng-valid {
        background-color: lightgreen;
    }

    .email.ng-dirty.ng-invalid-required {
        background-color: red;
    }

    .email.ng-dirty.ng-invalid-email {
        background-color: yellow;
    }

</style>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link href="css/app.css" rel="stylesheet"/>
</head>
<body>
<div class="generic-container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">注册用户 </span></div>
        <div class="formcontainer">
            <%
                UserServiceImpl service = new UserServiceImpl();
                String id1 = request.getParameter("id");
                if (id1 != null) {

                    User user = service.queryById(Integer.parseInt(id1));
                    pageContext.setAttribute("username", user.getUsername());
                    pageContext.setAttribute("password", user.getPassword());
                    pageContext.setAttribute("id", user.getId());

                }
            %>
            <form name="myForm" class="form-horizontal" id="form1"
                  action="check.jsp?action=add"
                  method="post">


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable">姓名</label>
                        <div class="col-md-7">
                            <input type="hidden" name="id"
                                   value="<%=pageContext.getAttribute("id")!=null?pageContext.getAttribute("id"):""%>"/>
                            <input type="text" name="username" id="username"
                                   value="<%=pageContext.getAttribute("username")!=null?pageContext.getAttribute("username"):""%>"
                                   class="username form-control input-sm"
                                   placeholder="输入你的姓名"/>
                            <div class="has-error">
                                <span id="uerror"></span>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable">密码</label>
                        <div class="col-md-7">
                            <input type="text" name="password" id="password"
                                   value="<%=pageContext.getAttribute("password")!=null?pageContext.getAttribute("password"):""%>"
                                   class="password form-control input-sm"
                                   placeholder="输入你的密码"
                            />
                            <div class="has-error">
                                <span id="perror"></span>

                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" id="add"
                               value="提交"
                               class="btn btn-primary btn-sm"
                        >
                        <button type="button" id="rst"
                                class="btn btn-warning btn-sm">复原
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">用户列表 </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID.</th>
                    <th>用户名</th>
                    <th>密码</th>
                    <th width="20%">操作</th>
                </tr>
                </thead>
                <tbody>
                <%
                    UserServiceImpl userService = new UserServiceImpl();
                    List<User> list = userService.queryAll();
                    for (User user : list) {


                %>

                <tr>
                    <td>
                        <%=user.getId()%>
                    </td>
                    <td>
                        <%=user.getUsername()%>
                    </td>
                    <td>
                        <%=user.getPassword()%>

                    </td>
                    <td>
                        <a href="index.jsp?id=<%=user.getId()%>" class="btn btn-success custom-width">编辑</a>
                        <a href="check.jsp?action=delete&id=<%=user.getId()%>"
                           class="btn btn-danger custom-width">删除</a>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>

