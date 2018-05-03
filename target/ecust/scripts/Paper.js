function AddPaperTip() {
    var PaperName = $("#PaperName").val();
    if (PaperName =="") {
        $("#ReAdd").html("请选择上传文献!");
        return true;
    }
    else{
        $("#File_Label").html("文献已上传！");

                }

}


