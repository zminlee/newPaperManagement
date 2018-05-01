package com.ecust.Service;

import java.util.List;
import com.ecust.Entity.Paper.Paper;

public interface PaperService
{
    public List<Paper> getPaper(String PaperID, String PaperName, String PaperInfo,String UserID);



    public Paper getPaperName(String PaperName,String UserID);

    public List<Paper> getPaperName(String PaperName);


    public String  AddPaper(String PaperID, String PaperName, String PaperInfo,String UserID);

    public void DeletePaper(String PaperID, String PaperName, String PaperInfo,String UserID);

    public void UpdatePaper(String PaperID, String PaperName, String PaperInfo,String UserID);

    public void QueryPaper(String PaperID, String PaperName, String PaperInfo,String UserID);

}
