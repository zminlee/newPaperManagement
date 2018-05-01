
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/LoginFailure.css">
    <script src="${pageContext.request.contextPath}/plugins/jquery/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script language="JavaScript">
        history.pushState(null, null, document.URL);
        window.addEventListener('popstate', function () {
            history.pushState(null, null, document.URL);
        })
    </script>

</head>
<body>
<div class="container">
    <div class="row">
        <h2 style="font-family: '黑体';margin-top:2%;margin-bottom: 2%;color: #2aabd2;text-align: center">注册成功！欢迎使用</h2>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="text-align: center">
            <form role="form"  method="post" style="background-color:rgba(255,255,255,0.8);border: 1px solid #dedede;border-radius:8px;margin:0 auto;padding:30px;margin-bottom:30px;max-width: 500px" action="${pageContext.request.contextPath}/index">
            <div class="form-group" style="text-align: center">
                 <div class="form-inline">
                     <button type="submit" class="btn btn-primary" >返回登录</button>
                 </div>
            </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

