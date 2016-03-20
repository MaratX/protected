package controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@RestController
public class DocsController {

    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public String provideUploadInfo() {
        return "Вы можете загружать файл с использованием того же URL.";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("name") String name, @RequestParam("file")MultipartFile file){
        if(!file.isEmpty()){
            try{
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return "Вы удачно загрузили " + name + " в " + name + "-upload !";
            }catch (Exception e){
                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
            }
        }else {
            return "Вам не удалось загрузить " + name + " Потому что файл пустой.";
        }
    }

}






























