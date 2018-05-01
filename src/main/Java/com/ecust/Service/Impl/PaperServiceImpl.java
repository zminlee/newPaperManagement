package com.ecust.Service.Impl;

import com.ecust.Service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ecust.Dao.PaperDao;
import com.ecust.Entity.Paper.Paper;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)

public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;

    public List<Paper> getPaper(String PaperID, String PaperName, String PaperInfo,String UserID) {
        return getPaper(PaperID,PaperName,PaperInfo,UserID);
    }

    public Paper getPaperName(String PaperName,String UserID)
    {
        return paperDao.getPaperName(PaperName,UserID);
    }

    public List<Paper> getPaperName(String PaperName)
    {
        return paperDao.getPaperName(PaperName);
    }


    public String  AddPaper(String PaperID, String PaperName, String PaperInfo,String UserID)
    {
        paperDao.AddPaper(PaperID,PaperName,PaperInfo,UserID);
        return "true";

    }
    public void DeletePaper(String PaperID, String PaperName, String PaperInfo,String UserID)
    {
        paperDao.DeletePaper(PaperID,PaperName,PaperInfo,UserID);

    }
    public void UpdatePaper(String PaperID, String PaperName, String PaperInfo,String UserID)
    {
        paperDao.UpdatePaper(PaperID,PaperName,PaperInfo,UserID);

    }
    public void QueryPaper(String PaperID, String PaperName, String PaperInfo,String UserID)
    {
        paperDao.QueryPaper(PaperID,PaperName,PaperInfo,UserID);

    }
}

