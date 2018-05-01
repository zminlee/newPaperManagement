package com.ecust.Dao;

import com.ecust.Entity.Category.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DoveXL on 2017/10/31.
 */
public interface CategoryDao {

    /**
     *
     * @param CreatePerson
     * @param StatusFlag
     * @return List<Category>类别列表
     * @author  mengweiqiang on  2017/11/1  09:58am
     */
    public List<Category> getCategoryByPerson(@Param("CreatePerson") String CreatePerson, @Param("StatusFlag") int StatusFlag);

    /**
     *
     * @param CategoryID
     * @param CategoryName
     * @param CategoryNote
     * @param CreatePerson
     * @param CreateTime
     * @param StatusFlag
     * @author  mengweiqiang on  2017/11/1  10:05am
     */
    public void AddCategory(@Param("CategoryID") String CategoryID, @Param("CategoryName") String CategoryName, @Param("CategoryNote") String CategoryNote, @Param("CreatePerson") String CreatePerson, @Param("CreateTime") String CreateTime, @Param("StatusFlag") int StatusFlag);


    /**
     *
     * @param CategoryID
     * @param CreatePerson
     * @param StatusFlag
     * @author  mengweiqiang on  2017/11/1  10:06am
     */
    public void DeleteCategory(@Param("CategoryID") String CategoryID,@Param("CreatePerson")String CreatePerson,@Param("StatusFlag") int StatusFlag);


    /**
     *
     * @param CategoryID
     * @param CategoryName
     * @param CategoryNote
     * @param CreatePerson
     * @param CreateTime
     * @param StatusFlag
     * @author  mengweiqiang on  2017/11/1  10:10am
     */
    public void UpdateCategory(@Param("CategoryID") String CategoryID, @Param("CategoryName") String CategoryName, @Param("CategoryNote") String CategoryNote, @Param("CreatePerson") String CreatePerson, @Param("CreateTime") String CreateTime, @Param("StatusFlag") int StatusFlag);
}