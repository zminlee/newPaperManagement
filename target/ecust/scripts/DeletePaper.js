
$(document).ready(function () {
    var PaperSelect = $("#PaperSelect");
    var UserID = $("#UserIDSpan").html().trim();
    getPaper(UserID,PaperSelect)
});


function getPaper(UserID,Select) {
    var Paper = {"UserID":UserID};
    var jsonString = JSON.stringify(Paper);
    $.ajax({
        url:'/PaperManagement/Paper/getPaperName',
        type:'post',
        contentType: 'application/json;charset=UTF-8',
        data: jsonString,
        success:function (data) {
            $(Select).empty();
            $("<option></option>").val("PleaseChoose")
                .text("请选择需要删除的文献")
                .appendTo($(Select));
            var data =eval(data);
            for (var  i =0;i<data.length;i++)
            {
                if(data[i].paperName!=PaperName)
                {
                    $("<option></option>").val(data[i].paperName)
                        .text(data[i].userID)
                        .appendTo($(Select));
                }
            }
        }

    });
}


function  DeletePaperTip() {
    var PaperName = $("#PaperName").val().trim();
    if (PaperName == "") {
        $("#ReAdd").html("请选择需要删除文献!");
    }
    else {

        var Filename = PaperName.split("\\");
        var NewPaperName = {"FileName": Filename[Filename.length - 1]};
        var jsonString = JSON.stringify(NewPaperName);
        $.ajax({
            url: "/PaperManagement/Paper/DeletePaper",
            type: "post",
            contentType: "application/json;charset:utf-8",
            data: jsonString,
            success: function (flag) {
                if (flag == "true") {
                    alert("删除成功");
                    $("#File_Label").html("文献已删除！");
                } else {
                    alert("删除失败");
                }

            }
        })

    }
}
