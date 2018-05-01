

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
    <script src="${pageContext.request.contextPath}/scripts/UserHome.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/HomeWebSocket.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/Paper.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/DeletePaper.js"></script>
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
                            <div class="panel-heading" style="color: #985f0d;"><a  style="text-decoration: none">首页</a></div>
                        </div>
                        <div class="panel panel-default" id="PaperAccordion">
                            <div class="panel-heading" style="color: #985f0d;" onclick="ShowAndHideOne()"><a  style="text-decoration: none">文献管理</a></div>
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
                            <div class="panel-heading" style="color: #985f0d;" onclick="ShowAndHideTwo()"><a  style="text-decoration: none">分类管理</a></div>
                            <div id="collapseTwo" class="panel-collapse collapse in">
                                <ul class="list-group">
                                    <li class="list-group-item">分类新增</li>
                                    <li class="list-group-item">类别修改</li>
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
                    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
                        <div class="panel panel-default" style="height: 30%;width: 100%;margin-bottom: 0px">
                            <div class="panel-body">
                                <div class="form-inline">
                                    <label class="control-label label_h2" style="width: 30%" >请选择需要删除的文献：</label>
                                    <select class="form-control" style="width: 100%" id="PaperSelect">
                                        <option></option>
                                    </select>
                                </div>
                                <br>
                                <button type="button" class="btn btn-primary" id="DeleteCommit" style="float: right" onclick="DeletePaperTip()">确认删除</button>
                    <%--<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">--%>
                        <%--<div class="panel panel-default" style="height: 70%;width: 100%;margin-bottom: 0px">--%>
                            <%--<table style="height: 90%;width: 100%;margin-top: 30px">--%>
                                <%--<tr style="height: 10%;width: 100% ">--%>
                                            <%--<div class="form-inline">--%>
                                                <%--<label class="control-label" >请选择删除文献："</label>--%>
                                                <%--<input type="file" id="PaperName" class="form-control" name="FileInput">--%>
                                                <%--<button type="button" class="btn btn-default" id="btn_File" onclick="DeletePaperTip()">删除文献</button>--%>
                                                <%--<label class="control-label" style="color: red" id="File_Label">文献未删除！</label>--%>
                                                <%--<br>--%>
                                                <%--<br>--%>
                                                <%--<label class="control-label" style="color: red" id="ReAdd"></label>--%>
                                            <%--</div>--%>

                                <%--</tr>--%>
                                <%--</table>--%>
                            <%----%>
            <%--</div>--%>
        <%--</div>--%>
    </div>
</div>
</div>
</div>
</div>
<iframe id="formsubmit" name="formsubmit" style="display:none;">
</iframe>
</body>
</html>

