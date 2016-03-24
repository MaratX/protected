package baseData;

import model.Docs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by HMF on 24.03.2016.
 */
public class Docjdbc implements baseData.DocImpl {

    BD bd = new BD();
    ResultSet rs = null;
    PreparedStatement PS = null;

    @Override
    public String create(String name, long link){
        String SQL = "insert into cloude.document (docName, docLink) values(?,?)";
        try {
            PS = bd.getPS(SQL);
            PS.setString(1, name);
            PS.setLong(2, link);
            PS.executeUpdate();
            return "Документ загружен";
        }catch (Exception e){
            System.out.println("INFO " + e);
            return "Ошибка : документ не удалось загрузить";
        }

    }

    @Override
    public Docs getDocById(Integer id) {
        String SQL = "";
        return null;
    }

    @Override
    public List<Docs> listDocs(int tabul) {
        String SQL = "";
        return null;
    }

    @Override
    public void delete(Integer id) {
        String SQL = "";

    }

    @Override
    public void update(Integer id, String name) {
        String SQL = "";

    }
}
