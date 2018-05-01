package com.ecust.Entity.Paper;

public class PaperKey extends Paper {
    private String PaperID;
    private String KeyID;

    public void setPaperID(String paperID) {
        PaperID = paperID;
    }

    public String getPaperID() {
        return PaperID;
    }

    public void setKeyID(String keyID) {
        KeyID = keyID;
    }

    public String getKetID() { return KeyID; }
}
