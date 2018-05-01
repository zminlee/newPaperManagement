package com.ecust.Dao;

import com.ecust.Entity.Category.SubCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DoveXL on 2017/10/31.
 */
public interface SubCategoryDao {


    /**
     *
     * @param CategoryID
     * @param CreatePerson
     * @param StatusFlag
     * @return List<SubCategory>
     *  @author  mengweiqianng   on 2017.11.1  13:50pm
     */
     public List<SubCategory> getSubCategory(String CategoryID,String CreatePerson,int StatusFlag);

    /**
     *
     * @param SubCategoryID
     * @param CategoryID
     * @param SubCategoryName
     * @param CreateTime
     * @param CreatePerson
     * @param StatusFlag
     * @author  mengweiqiang   2017.11.1   13:50pm
     */
    public void AddSubCategory(@Param("SubCategoryID") String SubCategoryID, @Param("CategoryID") String CategoryID, @Param("SubCategoryName")  String SubCategoryName, @Param("CreateTime") String CreateTime, @Param("CreatePerson") String CreatePerson, @Param("StatusFlag") int StatusFlag);


    /**
     *
     * @param SubCategoryID
     * @param CreatePerson
     * @param StatusFlag
     * @author mengweiqiang 2017.11.1  13:50pm
     */
    public void DeleteSubCategory(@Param("SubCategoryID") String SubCategoryID,@Param("CreatePerson") String CreatePerson,@Param("StatusFlag") int StatusFlag);

    /**
     *
     * @param SubCategoryID
     * @param CategoryID
     * @param SubCategoryName
     * @param CreateTime
     * @param CreatePerson
     * @param StatusFlag
     * @author  mengweiqiang 2017.11.1  13:52pm
     */

    public void UpdateSubCategory(@Param("SubCategoryID") String SubCategoryID,@Param("CategoryID") String CategoryID,@Param("SubCategoryName") String SubCategoryName,@Param("CreateTime") String CreateTime,@Param("CreatePerson") String CreatePerson,@Param("StatusFlag") int StatusFlag);
}
