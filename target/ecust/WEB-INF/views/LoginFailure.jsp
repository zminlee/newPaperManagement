
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆失败</title>
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
<div >
    <h1>很抱歉，您未能登录系统</h1>
</div>
<br>
<div  align="center" class="png">
    <p><a href="${pageContext.request.contextPath}/WEB-INF/index.jsp"><img src="${pageContext.request.contextPath}/images/LoginFailure_to_index.png" /></a> </p>
</div>
<div id="cloud"></div>
</div>
</body>
</html>
