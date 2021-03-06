<%@ page import="com.ecust.Entity.User.UserRole" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文献管理主页</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/WebHome.css">
    <script src="${pageContext.request.contextPath}/plugins/jquery/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/jquery/echarts.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/WebHome.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/Category.js"></script>
    <script language="JavaScript">
        history.pushState(null, null, document.URL);
        window.addEventListener('popstate', function () {
            history.pushState(null, null, document.URL);
        })
    </script>
</head>
<body style="height:1000px;overflow: auto;background-color: #F8F8FF">
<div class="container-fluid">
    <div class="row">
        <div  class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="divtop" >
        </div>
        <nav class="navbar navbar-default" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" style="font-family: 楷体;font-size: 26px">欢迎使用文献管理系统</a>
                </div>
                <div>
                    <ul class="nav navbar-nav divnav">
                        <li><a class="active">
                            <span class="glyphicon glyphicon-paperclip"></span>
                            <span id="RoleIDSpan"><%=session.getAttribute("RoleID")%></span>
                        </a>
                        </li>
                        <li><a>
                            <span class="glyphicon glyphicon-user"></span>
                            <span id="UserIDSpan"><%=session.getAttribute("UserID")%></span>
                        </a>
                        </li>
                        <li class="dropdown" >
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-th-list"></span>
                                个人中心
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">个人信息</a></li>
                                <li><a href="#">修改密码</a></li>
                                <li><a href="${pageContext.request.contextPath}/login/LoginOut">退出</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="height: 100%;float: left">
            <div class="container">
                <div class="row">
                     <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2" style="height: 100%">
                         <div class="panel panel-default" id="Index">
                             <div class="panel-heading" style="color: #985f0d;"><a  style="text-decoration: none" href="${pageContext.request.contextPath}/Redirect/Home" onclick="CloseWebSocket()">首页</a></div>
                         </div>
                         <div class="panel panel-default" id="PaperAccordion">
                             <div class="panel-heading" style="color: #985f0d;" onclick="ShowAndHideOne()"><a  style="text-decoration: none">文献内容管理</a></div>
                             <div id="collapseOne" class="panel-collapse collapse in">
                                 <ul class="list-group">
                                     <li class="list-group-item"> <a href="${pageContext.request.contextPath}/Redirect/addPaper">文献新增</a></li>
                                     <li class="list-group-item"> <a href="${pageContext.request.contextPath}/Redirect/updatePaper">文献修改</a></li>
                                     <li class="list-group-item"> <a href="${pageContext.request.contextPath}/Redirect/queryPaper">文献查询</a></li>
                                     <li class="list-group-item"> <a href="${pageContext.request.contextPath}/Redirect/deletePaper">文献删除</a></li>
                                 </ul>
                             </div>
                         </div>

                         <div class="panel panel-default" id="CategoryManagement">
                             <div class="panel-heading" style="color: #985f0d;" onclick="ShowAndHideTwo()"><a  style="text-decoration: none">文献类别管理</a></div>
                             <div id="collapseTwo" class="panel-collapse collapse in">
                                 <ul class="list-group">
                                     <li class="list-group-item">类别管理</li>
                                     <li class="list-group-item">子类别管理</li>
                                 </ul>
                             </div>
                         </div>
                         <div class="panel panel-default" id="Message">
                             <div class="panel-heading" style="color: #985f0d;"><a  style="text-decoration: none">消息管理</a></div>
                             <div id="collapseFour" class="panel-collapse collapse in">
                                 <ul class="list-group">
                                     <li class="list-group-item"><a style="text-decoration: none" href="${pageContext.request.contextPath}/Redirect/ContactUser" onclick="CloseWebSocket()">未读消息<span class="badge pull-right" id="UnReadTumber"></span></a></li>
                                     <li class="list-group-item">已读消息</li>
                                 </ul>
                             </div>
                         </div>
                     </div>
                         <div class="panel panel-default" id="UserManagement" style="display: none">
                             <div class="panel-heading" style="color: #985f0d;" onclick="ShowAndHideThree()"><a  style="text-decoration: none">人员管理</a></div>
                             <div id="collapseThree" class="panel-collapse collapse in">
                                 <ul class="list-group">
                                     <li class="list-group-item">用户管理</li>
                                     <li class="list-group-item">权限管理</li>
                                 </ul>
                             </div>
                         </div>
                     </div>
                     <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
                          <div class="panel panel-default" style="height: 30%;width: 100%;margin-bottom: 0px">
                                 <div class="panel-body">
                                     <div class="form-inline">
                                          <label class="control-label label_h2" style="width: 30%">类别ID：</label>

                                     </div>
                                     <br>
                                     <textarea class="form-control" style="height: 35%;width: 100%;resize: none" id="MessageInput" placeholder="请输入消息" onfocus="ChangeFocus()"></textarea>
                                     <br>
                                     <button type="button" class="btn btn-primary" id="MessageReset" style="float: right;margin-left: 2%">清空</button>
                                     <button type="button" class="btn btn-primary" id="MessageCommit" style="float: right" onclick="SaveTextMessage()">发送</button>
                                 </div>
                           </div>
                           <div class="panel panel-default" style="height: 5%;width: 100%;margin-top: 0px;text-align: center">
                             <div class="panel-body" style="text-align: center">
                                 <img style="align-self: center;" src="${pageContext.request.contextPath}/images/Contact/refresh.png" onclick="RefreshMessage()">
                                 <label style="align-self: center;margin-left: 5px;font-family: 楷体" class="control-label">未读消息</label>
                             </div>
                           </div>
                         <div class="panel panel-default" style="width: 100%;margin-top: 0px;display: none" id="MessageContentsBody">
                             <div class="panel-body" id="MessageContents">
                             </div>
                         </div>
                         </div>



                     </div>
               </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

