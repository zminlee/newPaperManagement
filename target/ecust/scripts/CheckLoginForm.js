
function checkvalidate() {
    var user = document.getElementById("username");
    var userpwd = document.getElementById("userpassword");
    var reg= /^[0-9a-zA-Z]*$/g;
    if (user.value.length == 0 && userpwd.value.length== 0)
    {
        alert("用户名和密码为空，请输入!");
        user.focus();
        userpwd.focus();
        return false;
    }
    else if (user.value.length == 0 && userpwd.value.length != 0)
    {
        alert("用户名为空，请输入!");
        user.focus();
        return false;
    }
    else  if (user.value.length != 0 && userpwd.value.length == 0)
    {
        alert("密码为空，请输入!");
        userpwd.focus();
        return false;
    }
    if (!reg.test(user.value))
    {
        alert("含有除英文数字之外的非法字符");
        user.focus();
        return false;
    }

    return true;
}