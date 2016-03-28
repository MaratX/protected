package baseData;

import model.Docs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by HMF on 24.03.2016.
 */
public class Docjdbc implements baseData.DocImpl {

    BD bd = new BD();
    ResultSet rs = null;
    PreparedStatement PS = null;


    @Override
    public String create(String name, long link, String format) throws Exception{
        String SQL = "insert into cloude.document (docName, docLink, docFormat) values(?,?,?)";

            PS = bd.getPS(SQL);
            PS.setString(1, name);
            PS.setLong(2, link);
            PS.setString(3, format);
            PS.executeUpdate();
            bd.closePS();
            return "Документ загружен";
    }

    @Override
    public Docs getDocById(Integer id) throws Exception{
        String SQL = "SELECT * FROM document WHERE id = " + id;
        rs = bd.getStm().executeQuery(SQL);
        Docs d = new Docs();
        rs.next();
        d.setId(rs.getInt("id"));
        d.setName(rs.getString("docName"));
        d.setLink(rs.getLong("docLink"));
        d.setFormat(rs.getString("docFormat"));
        rs = null;
        return d;
    }

    @Override
    public ArrayList<Docs> listDocs(int tabul) throws Exception{
        ArrayList<Docs> list = new ArrayList<>();
        Docs d = new Docs();
        String SQL = "SELECT id, docName, docFormat FROM cloude.document WHERE id >= ? LIMIT 20";
        PS = bd.getCon().prepareStatement(SQL);
        PS.setInt(1, tabul);
        rs = PS.executeQuery();
        bd.closeConn();
        while (rs.next()){
            list.add(rsDoc(rs));
        }
        rs.close();
        return list;
    }

    private Docs rsDoc(ResultSet rs) throws Exception{
        Docs d = new Docs();
        d.setId(rs.getInt("id"));
        d.setName(rs.getString("docName"));
        d.setLink(0);
        d.setFormat(rs.getString("docFormat"));
        return d;
    }

    @Override
    public String delete(Integer id) throws Exception{
        String SQL = "DELETE FROM cloude.document where  id = ?";
            PS = bd.getPS(SQL);
            PS.setInt(1, id);
            PS.executeUpdate();
            bd.closePS();
        return "Запись удалена";
    }

    @Override
    public String update(int id, String name) throws Exception{
        String SQL = "UPDATE cloude.document SET docName = ? WHERE id = ?";
            PS = bd.getPS(SQL);
            PS.setString(1, name);
            PS.setInt(2, id);
            PS.executeUpdate();
            bd.closePS();
        return "Документ " + name + " обновлен";
    }
}
