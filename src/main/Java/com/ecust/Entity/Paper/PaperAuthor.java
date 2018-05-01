package com.ecust.Entity.Paper;

public class PaperAuthor extends Paper {

    private String PaperID;
    private String AuthorID;

    public void setPaperID(String paperID) {
        PaperID = paperID;
    }

    public String getPaperID() {
        return PaperID;
    }

    public void setAuthorID(String authorID) {
        AuthorID = authorID;
    }

    public String getAuthorID() { return AuthorID; }
}
