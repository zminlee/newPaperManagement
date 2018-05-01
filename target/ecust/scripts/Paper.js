function AddPaperTip() {
    var PaperName = $("#PaperName").val();
    if (PaperName =="") {
        $("#ReAdd").html("请选择上传文献!");
        return true;
    }
    else{
        var UserID = $("#UserIDSpan").html().trim();
        var Filename = PaperName.split("\\");
        var Paper = {"FileName": Filename[Filename.length - 1],"UserID":UserID};
        var jsonString = JSON.stringify(Paper);
        $.ajax({
            url: "/PaperManagement/Paper/AddPaper",
            type: "post",
            contentType: 'application/json;charset=UTF-8',
            data: jsonString,
            success: function (flag) {
                if (flag == "AddSuccess") {
                    alert("添加失败");
                } else  {
                    $("#File_Label").html("文献已上传！");

                }
            }
        })
    }
}


