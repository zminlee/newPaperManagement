package com.ecust.Entity.Category;

/**
 * Created by DoveXL on 2017/10/31.
 */
public class Category {

    private int id;
    private String CategoryID;
    private String CategoryName;
    private String CategoryNote;
    private String CreateTime;
    private String CreatePerson;

    private int StatusFlag;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getCategoryNote() {
        return CategoryNote;
    }

    public void setCategoryNote(String categoryNote) {
        CategoryNote = categoryNote;
    }

    public String getCreatePerson() {
        return CreatePerson;
    }

    public void setCreatePerson(String createPerson) {
        CreatePerson = createPerson;
    }

    public int getStatusFlag() {
        return StatusFlag;
    }

    public void setStatusFlag(int statusFlag) {
        StatusFlag = statusFlag;
    }
}
