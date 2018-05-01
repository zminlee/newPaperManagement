package com.ecust.Entity.Paper;

public class Paper {
    private String PaperID;
    private String PaperName;
    private String PaperInfo;
    private String UserID;

    public void setPaperID(String paperID) { PaperID = paperID; }

    public String getPaperID() { return PaperID; }

    public void setPaperName(String paperName) {
        PaperName = paperName;
    }

    public String getPaperName() {
        return PaperName;
    }

    public void setPaperInfo(String paperInfo) {
        PaperInfo = paperInfo;
    }

    public String getPaperInfo() { return PaperInfo; }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUserID() { return UserID; }

}
