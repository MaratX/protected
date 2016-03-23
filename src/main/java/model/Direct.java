package model;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class Direct {
    public static void add(){
        File file = new File("C:/directSberTat");
        file.mkdirs();
    }

    public static String saveFile(String name, long count, String path, MultipartFile file){
        if(!file.isEmpty()){
            try{
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path + count)));
                stream.write(file.getBytes());
                stream.close();

                return "Вы удачно загрузили " + name + "!";
            }catch (Exception e){
                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
            }
        }else {
            return "Вам не удалось загрузить " + name + " Потому что файл пустой.";
        }
    }

    public static long countDirect(){
        File count = new File("C:/directSberTat");
        return count.list().length;
    }

}
