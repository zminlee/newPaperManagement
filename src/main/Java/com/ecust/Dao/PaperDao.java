package com.ecust.Dao;

import com.ecust.Entity.Paper.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperDao {
    public List<Paper> getPaper(@Param("PaperID") String PaperID, @Param("PaperName") String PaperName, @Param("PaperInfo") String PaperInfo,@Param("UserID") String UserID);

    public List<Paper> getPaperName(@Param("PaperName") String PaperName);

    public Paper getPaperName(@Param("PaperName") String PaperName,@Param("UserID") String UserID);

    public void AddPaper(@Param("PaperID") String PaperID, @Param("PaperName") String PaperName, @Param("PaperInfo") String PaperInfo,@Param("UserID") String UserID);

    public void DeletePaper(@Param("PaperID") String PaperID, @Param("PaperName") String PaperName, @Param("PaperInfo") String PaperInfo,@Param("UserID") String UserID);

    public void UpdatePaper(@Param("PaperID") String PaperID, @Param("PaperName") String PaperName, @Param("PaperInfo") String PaperInfo,@Param("UserID") String UserID);

    public void QueryPaper(@Param("PaperID") String PaperID, @Param("PaperName") String PaperName, @Param("PaperInfo") String PaperInfo,@Param("UserID") String UserID);
}
