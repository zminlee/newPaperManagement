
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/plugins/jquery/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/CheckLoginForm.js"></script>
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
        <h2 style="font-family: '黑体';margin-top:2%;margin-bottom: 2%;color: #2aabd2;text-align: center">文献管理系统用户登录</h2>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="text-align: center">
            <form role="form"  method="post" style="background-color:rgba(255,255,255,0.8);border: 1px solid #dedede;border-radius:8px;margin:0 auto;padding:30px;margin-bottom:30px;max-width: 500px" action="${pageContext.request.contextPath}/login/UserLogin" onsubmit=" return checkvalidate();">
                <div class="form-group" >
                    <div class="form-inline">
                        <label  for="username" class="glyphicon glyphicon-user" style="margin: 5px"></label>
                        <input type="text" name="UserID" id="username" class="form-control" style="width: 90%;" placeholder="请输入用户名">
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-inline">
                        <label class="glyphicon glyphicon-lock" style="margin: 5px"></label>
                        <input type="password" name = "UserPwd" id="userpassword" class="form-control" style="width: 90%;" placeholder="请输入密码">
                    </div>
                </div>

                <div class="form-group" style="text-align: left;margin-left: 8px">
                    <div class="form-inline">
                        <label class="glyphicon glyphicon-check" style="margin: 5px"></label>


                        <label class="radio-inline">
                            <input type="radio" name="RoleID" value="NormalUser" checked>普通用户</label>
                        <label class="radio-inline" style="margin-left: 5%">
                            <input type="radio" name="RoleID" value="Administrator">管理员</label>
                    </div>
                </div>
                <br>
                <div class="form-group" style="text-align: center">
                    <div class="form-inline">
                        <a href="${pageContext.request.contextPath}/Register/ToRegister">注册</a>
                        <button type="submit" class="btn btn-primary" >登录</button>
                        <label class="control-label" style="margin-left: 10px"><a href="">忘记密码？</a></label>
                    </div>
                </div>
                <hr>
            </form>
        </div>
    </div>

</div>
</body>
</html>
