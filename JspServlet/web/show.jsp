<%@ page import="java.util.List" %>
<%@ page import="com.ryan.vo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head >
  <title>易圣通课堂练习</title>
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
<div class="generic-container" >
  <div class="panel panel-default" >
    <div class="panel-heading"><span class="lead">注册用户 </span></div>
    <div class="formcontainer">

      <form  name="myForm" class="form-horizontal" id="form1"
             action="user?action=add"
             method="post">


        <div class="row">
          <div class="form-group col-md-12">
            <label class="col-md-2 control-lable">姓名</label>
            <div class="col-md-7">
              <input type="hidden" name="id"
                     value="<%=request.getAttribute("id")!=null?request.getAttribute("id"):(Object)""%>"/>
              <input type="text" name="username" id="username"
                     value="<%=request.getAttribute("username")!=null?request.getAttribute("username"):(Object)""%>"
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
            <label class="col-md-2 control-lable" >密码</label>
            <div class="col-md-7">
              <input type="text" name="password" id="password"
                     value="<%=request.getAttribute("password")!=null?request.getAttribute("password"):(Object)""%>"
                     class="password form-control input-sm"
                     placeholder="输入你的密码"
              />
              <div class="has-error" >
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
                    class="btn btn-warning btn-sm">复原</button>
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
          List<User>list= (List<User>) request.getAttribute("list");
          for (User u:list
               ) {


        %>
        <tr>
          <td>
          <%=u.getId()%>
          </td>
          <td>
          <%=u.getUsername()%>
          </td>
          <td>
            <%=u.getPassword()%>
          </td>
          <td>
            <a href="user?action=edit&id=<%=u.getId()%>"  class="btn btn-success custom-width">编辑</a>
            <a href="user?action=delete&id=<%=u.getId()%>"  class="btn btn-danger custom-width">删除</a>
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


</body>
</html>