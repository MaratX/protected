package DAO;

import model.Docs;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by HMF on 23.03.2016.
 */
public class DocsMapper implements RowMapper<Docs>{
    public Docs mapRow(ResultSet rs, int rowNum) throws SQLException{
        Docs docs = new Docs();
        docs.setId(rs.getInt("id"));
        docs.setName(rs.getString("name"));
        docs.setLink(rs.getString("link"));
        return docs;
    }
}
