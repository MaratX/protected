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
    public String create(String name, long link, String format){
        String SQL = "insert into cloude.document (docName, docLink, docFormat) values(?,?,?)";
        try {
            PS = bd.getPS(SQL);
            PS.setString(1, name);
            PS.setLong(2, link);
            PS.setString(3, format);
            PS.executeUpdate();
            return "Документ загружен";
        }catch (Exception e){
            return "Ошибка : документ не удалось загрузить";
        }finally {
            PS = null;
        }

    }

    @Override
    public Docs getDocById(Integer id) throws Exception{
        String SQL = "SELECT * FROM document WHERE id = " + id;
        rs = bd.getStm().executeQuery(SQL);
        Docs d = new Docs();
        rs.next();
        d.setName(rs.getString("docName"));
        d.setLink(rs.getLong("docLink"));
        d.setFormat(rs.getString("docFormat"));
        rs.close();
        return d;
    }

    @Override
    public List<Docs> listDocs(int tabul) {
        String SQL = "";
        return null;
    }

    @Override
    public String delete(Integer id) throws Exception{
        String SQL = "DELETE FROM cloude.document where  id = ?";
            PS = bd.getPS(SQL);
            PS.setInt(1, id);
            PS.executeUpdate();
            PS = null;
        return "Запись удалена";
    }

    @Override
    public String update(Integer id, String name) {
        String SQL = "UPDATE cloude.document SET docName=? WHERE id=?";
        try{
            PS = bd.getPS(SQL);
            PS.setString(1, name);
            PS.setInt(2, id);
            PS.executeUpdate();
            return "Документ " + name + " обновлен";
        }catch (Exception e){
            return "Ошибка: документ не удалось обновить";
        }

    }
}
