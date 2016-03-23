package controller;


import DAO.DocsJDBCTemplate;
import model.Direct;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class DocsController {

    private final String path = "C:/directSberTat/";
    protected static long count = Direct.countDirect();
    ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
    DocsJDBCTemplate jdbc = (DocsJDBCTemplate) context.getBean("DocsJDBCTemplate");

    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public String provideUploadInfo() {
        return "Вы можете загружать файл с использованием того же URL.";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("name") String name, @RequestParam("file")MultipartFile file){
        count++;
        jdbc.create(name,count);
        return Direct.saveFile(name, count, path, file);
    }

}






























