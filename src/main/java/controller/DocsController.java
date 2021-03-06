package controller;


import baseData.DocImpl;
import baseData.Docjdbc;
import model.Direct;
import model.Docs;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.io.File;

@RestController
public class DocsController {

    private final String path = "C:/directSberTat/";
    protected static long link = Direct.countDirect();




    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public String addFileInfo() {
        return "Вы можете загружать файл с использованием того же URL.";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String addFile(@RequestParam("name") String name, @RequestParam("file")MultipartFile file){
        link++;
        return Direct.saveFile(name, link, path, file);
    }

    @RequestMapping(value = "/getDocList", method = RequestMethod.GET)
    public List<Docs> getFileList(@RequestParam(value = "tabul", defaultValue = "0") int tabul){
        return Direct.listFile(tabul);
    }


    @RequestMapping(value = "/delete")
    public String deleteFile(@RequestParam(value = "id", required = false) int id){
        return Direct.deleteFile(id);
    }

    @RequestMapping(value = "/rename")
    public String renameFile(@RequestParam(value = "id", required = false) int id, @RequestParam("name") String name){
        return Direct.renameFile(id, name);
    }

    @RequestMapping(value = "/getDocInfo")
    public Docs getDocInfo(@RequestParam(value = "id", required = false) int id){
        return Direct.getDocInfo(id);
    }

}






























