
function checkregisterInfo(userID,userName,name,userPwd,userPwd1,telPhone) {

    var UserID=userID;
    var UserName =userName;
    var Name = name;
    var UserPwd = userPwd;
    var UserPwd1 = userPwd1;
    var TelPhone = telPhone;
    var UserIDReg = /^[_a-zA-Z0-9]+$/;
    var UserNameReg = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
    var NameReg = /^[\u4e00-\u9fa5]+$/;
    var UserPwdReg = /^[0-9]*$/;

    // console.log(UserID);
    // // console.log(TelPhone);
    // console.log(Name);
    // console.log(UserPwd);
    // console.log(UserPwd1);

    if (UserID.trim().length != 0 && Name.trim().length != 0 && UserName.trim().length!=0 && UserPwd.trim().length!=0 && UserPwd1.trim().length!=0&&TelPhone.trim().length) {

        if (!UserIDReg.test(UserID)) {
            alert("用户ID只允许属于英文、数字！");
            return false;
        }

        if (!UserNameReg.test(UserName)) {
            alert("用户名只允许输入中文，英文，数字请重新输入")
        }

        if (!NameReg.test(Name)) {
            alert("真实姓名只允许属于中文！");
            return false;
        }
        // console.log(UserPwd)
        if (!UserPwdReg.test(UserPwd)) {
            alert("密码由数字组成");
        }
        // console.log(UserPwd1);
        if (UserPwd1!=UserPwd) {
            alert("两次输入密码不同，请重新输入!");
        }
    }
    else {
        alert("必填项有空值，请检查!");
        return false;
    }
    return true;
}




function CheckUser() {
    var UserID = $("#UserID").val().trim();
    var UserName = $("#UserName").val().trim();
    var Name = $("#Name").val().trim();
    var UserPwd = $("#UserPwd").val().trim();
    var UserPwd1 = $("#UserPwd1").val().trim();
    var TelPhone = $("#TelPhone").val().trim();
    if(checkregisterInfo(UserID,UserName,Name,UserPwd,UserPwd1,TelPhone))
    {
        var UserInfo={"UserID":UserID,"UserName":UserName,"Name":Name,"UserPwd":UserPwd,"TelPhone":TelPhone};
        var jsonString = JSON.stringify(UserInfo);
        $.ajax({
            url:"/PaperManagement/Register/CheckRegisterUser",
            type:"post",
            contentType:'application/json;charset=UTF-8',
            data:jsonString,
            success:function (flag) {
                if (flag =="false")
                {
                    $.ajax({
                        url:"/PaperManagement/Register/RegisterUser",
                        type:"post",
                        contentType:'application/json;charset=UTF-8',
                        data:jsonString,
                        success:function(flag)
                        {
                            if(flag=="RegisterSuccess") {
                                alert("用户注册成功");
                            }else
                            {
                                alert("用户注册失败");
                            }
                        }
                    })
                }
                else if(flag == "true")
                {
                    alert("用户名已存在");
                    return false;
                }
                else
                {
                    alert("用户名出错");
                    return true;
                }
            }
        })
    }

}
