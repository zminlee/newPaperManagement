<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文献管理系统用户注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/plugins/jquery/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/Register.js"></script>
    <script language="JavaScript">
        history.pushState(null, null, document.URL);
        window.addEventListener('popstate', function () {
            history.pushState(null, null, document.URL);
        })
    </script>
</head>
<body style="background-color:#eeeeee">
<div class="container">
    <div class="row">
        <h2 style="font-family: '黑体';margin-top:2%;margin-bottom: 2%;color: #2aabd2;text-align: center">文献管理系统用户注册</h2>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="text-align: center">
                <form role="form"  method="post" style="background-color:rgba(255,255,255,0.8);border: 1px solid #dedede;border-radius:8px;margin:0 auto;padding:30px;margin-bottom:30px;max-width: 500px" action="${pageContext.request.contextPath}/RegisterUser" onsubmit=" return checkregisterInfo();">
                    <div class="form-group" style="text-align: left;margin-left: 10px">
                        <label class="text-danger ">*表示必填项</label>
                    </div>
                    <div class="form-group" style="text-align: left;">
                        <div class="form-inline">
                            <label for="UserID" class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;用户ID:</label>
                            <input type="text" class="form-control " id="UserID" name="UserID" style="width: 60%" >
                            <label class="text-danger " >*</label>
                        </div>
                    </div>
                    <div class="form-group" style="text-align: left;">
                        <div class="form-inline">
                            <label for="UserName" class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;用户名：</label>
                            <input type="text" class="form-control" id="UserName" name=UserName  style="width: 60%" >
                            <label class="text-danger " >*</label>
                        </div>
                    </div>

                    <div class="form-group" style="text-align: left;">
                        <div class="form-inline">
                            <label for="Name" class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;姓&nbsp;名&nbsp;&nbsp;：</label>
                            <input type="text" class="form-control" id="Name" name=Name  style="width: 60%" >
                            <label class="text-danger " >*</label>
                        </div>
                    </div>

                    <div class="form-group" style="text-align: left;">
                        <div class="form-inline">
                            <label for="UserPwd" class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;密码：</label>
                            <input type="password"  class="form-control" name = "UserPwd" id="UserPwd"  style="width: 60%;" >
                            <label class="text-danger " >*</label>
                        </div>
                    </div>
                    <div class="form-group" style="text-align: left;">
                        <div class="form-inline">
                            <label for="UserPwd1" class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;密码确认：</label>
                            <input type="password"  class="form-control" name = "UserPwd1" id="UserPwd1"  style="width: 60%;" >
                            <label class="text-danger " >*</label>
                        </div>
                    </div>
                    <div class="form-group" style="text-align: left;">
                        <div class="form-inline">
                            <label for="UserPwd1" class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;电话号码：</label>
                            <input type="text"  class="form-control" name = "TelPhone" id="TelPhone"  style="width: 60%;" >
                            <label class="text-danger " >*</label>
                        </div>
                    </div>
                    <br>
                    <div class="form-group" style="text-align: center">
                        <div class="form-inline">
                            <button type="button" class="btn btn-primary" onclick="CheckUser()">注册</button>
                        </div>
                        <div class="form-inline">
                            <a href="${pageContext.request.contextPath}/login/index">返回主页</a>
                        </div>
                    </div>
                    <hr>
                </form>
        </div>
    </div>

</div>
</body>
</html>

<%--<div class="form-group">--%>
                        <%--<div class="form-inline">--%>
                            <%--<label class="glyphicon glyphicon-user" style="margin: 5px"></label>--%>
                            <%--<input type="text" name = "UserID" id="userID" class="form-control" style="width: 90%;" placeholder="请输入用户ID">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group" >--%>
                        <%--<div class="form-inline">--%>
                            <%--<label  for="username" class="glyphicon glyphicon-user" style="margin: 5px"></label>--%>
                            <%--<input type="text" name="Name" id="Name" class="form-control" style="width: 90%;" placeholder="请输入用户名">--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="form-group">--%>
                        <%--<div class="form-inline">--%>
                            <%--<label class="glyphicon glyphicon-lock" style="margin: 5px"></label>--%>
                            <%--<input type="password" name = "UserPwd" id="UserPwd" class="form-control" style="width: 90%;" placeholder="请输入密码">--%>
                        <%--</div>--%>
                    <%--</div>--%>


                    <%--<hr>--%>
                    <%--<div class="form-group">--%>
                        <%--<label ></label>--%>
                    <%--</div>--%>
                <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>

<%--</div>--%>
<%--</body>--%>
<%--</html>--%>

