package controller;


import DAO.DocsJDBCTemplate;
import baseData.DocImpl;
import baseData.Docjdbc;
import model.Direct;
import model.Docs;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@RestController
public class DocsController {

    private final String path = "C:/directSberTat/";
    protected static long link = Direct.countDirect();
    DocImpl doc = new Docjdbc();

    //ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
    //DocsJDBCTemplate jdbc = (DocsJDBCTemplate) context.getBean("DocsJDBCTemplate");

    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public String provideUploadInfo() {
        return "Вы можете загружать файл с использованием того же URL.";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("name") String name, @RequestParam("file")MultipartFile file){
        link++;
        String s = doc.create(name, link);
        return s + " " + Direct.saveFile(name, link, path, file);
    }

    @RequestMapping(value = "/getDoc", method = RequestMethod.GET)
    public List<Docs> getFileList(@RequestParam(value = "tabul", defaultValue = "0") int tabul){
        return null;
    }

}






























