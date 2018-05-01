package com.ecust.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ecust.Entity.Paper.Paper;
import com.ecust.Service.PaperService;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import sun.rmi.runtime.NewThreadAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

@Controller
@RequestMapping(value = "/Paper/**")
public class PaperController {

    @Autowired
    private PaperService paperService;

    private String papername;
    @RequestMapping(value = "/StorePaper/",method = RequestMethod.POST)
    public void AddPaper(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        String PaperName = "";
        try {

            Date now = new Date();
            DateFormat df = DateFormat.getDateTimeInstance();
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if (multipartResolver.isMultipart(request)) {

                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

                Iterator<String> iter = multiRequest.getFileNames();
                while (iter.hasNext()) {

                    int pre = (int) System.currentTimeMillis();
                    MultipartFile paper = multiRequest.getFile(iter.next());
                    if (paper != null) {
                        String addPaperName = paper.getOriginalFilename();
                        if (addPaperName.trim() != "") {
                            System.out.println(addPaperName);
                            System.out.println(session.getAttribute("UserID"));
                            PaperName = df.format(now) + paper.getOriginalFilename();
                            PaperName = PaperName.replaceAll(":", "_");
                            PaperName = PaperName.replaceAll(":", "_");
                            File MyFolder = new File("F:/Document/"+session.getAttribute("UserID"));
                            if(!MyFolder.exists())
                            {
                                MyFolder.mkdir();
                            }

                            String path = "F:/Document/"+session.getAttribute("UserID")+"/" + PaperName;
                            File localPaper = new File(path);
                            paper.transferTo(localPaper);
                        }
                    }
                    int finaltime = (int) System.currentTimeMillis();
                    System.out.println(finaltime - pre);
                    papername = PaperName;
                }
            }
        } catch (Exception e) {
            papername = "null";
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "AddPaper" ,method = RequestMethod.POST)
    @ResponseBody
    public String AddPaper(@RequestBody String Paper)
    {
        JSONObject jsonObject = JSON.parseObject(Paper);
        String PaperName=jsonObject.getString("FileName");
        String UserID=jsonObject.getString("UserID");
        String PaperInfo="F:/Document/"+UserID+PaperName;
        String PaperID=UserID;
        String Status = paperService.AddPaper(PaperID, PaperName, PaperInfo,UserID);
            if (Status.equals("true")) {
                return "/AddSuccess";
            } else {
                return "/AddFailure";

            }

    }

    @RequestMapping(value="getPaperName",method = RequestMethod.POST)
    @ResponseBody
    public String getPaperName(@RequestBody  String Paper){
        JSONObject jsonObject = JSON.parseObject(Paper);
        String UserID=jsonObject.getString("UserID");
          return JSON.toJSONString(paperService.getPaperName(UserID));
        }




    @RequestMapping(value = "/DeletePaper/",method = RequestMethod.POST)
    @ResponseBody
    public String DeletePaper(@RequestBody String PaperName) {
        String paperDir;
        //String NewPaperName = PaperName.substring(PaperName.lastIndexOf("/")+1);
        JSONObject jsonObject = JSON.parseObject(PaperName);
        String NewPaperName=jsonObject.getString("FileName");
        System.out.println(NewPaperName);
        paperDir = "F:\\Document\\";
        File fileDir = new File(paperDir + NewPaperName);

        System.out.println(fileDir.exists());
        if (fileDir.exists()) {
            System.out.println("111");
            fileDir.delete();
            return "true";
        }
        return "false";
    }

}




