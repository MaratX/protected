package controller;


import model.Direct;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class DocsController {

    private final String path = "C:/directSberTat/";
    protected static long count = Direct.countDirect();

    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public String provideUploadInfo() {
        return "Вы можете загружать файл с использованием того же URL.";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("name") String name, @RequestParam("file")MultipartFile file){
        count++;
        return Direct.saveFile(name, count, path, file);
    }

}






























