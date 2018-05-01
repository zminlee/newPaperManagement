package com.ecust.Entity.Category;

/**
 * Created by DoveXL on 2017/10/31.
 */
public class SubCategory {

    private int id;
    private String SubCategoryID;
    private String CategoryID;
    private String SubCategoryName;
    private String CreateTime;
    private String CreatePerson;
    private String StatusFlag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubCategoryID() {
        return SubCategoryID;
    }

    public void setSubCategoryID(String subCategoryID) {
        SubCategoryID = subCategoryID;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public String getSubCategoryName() {
        return SubCategoryName;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public void setSubCategoryName(String subCategoryName) {
        SubCategoryName = subCategoryName;
    }

    public void setCreatePerson(String createPerson) {
        CreatePerson = createPerson;
    }

    public String getCreatePerson() {
        return CreatePerson;
    }

    public String getStatusFlag() {
        return StatusFlag;
    }

    public void setStatusFlag(String statusFlag) {
        StatusFlag = statusFlag;
    }
}
