package DAO;

import model.Docs;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by HMF on 23.03.2016.
 */
public class DocsJDBCTemplate implements DocImpl {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dateSource){
        this.dataSource = dateSource;
        this.jdbcTemplate = new JdbcTemplate(dateSource);
    }
    public void create(String name, long link){
        String SQL = "insert into Docs (name, link) values(?,?)";
        jdbcTemplate.update(SQL, name, link);
    }
    public Docs getDocById(Integer id){
        String SQL = "select * from Docs where id = ?";
        Docs docs = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new DocsMapper());
        return docs;
    }
    public List<Docs> listDocs(int tabul){
        String SQL = "select * from Docs";
        List<Docs> docsList = jdbcTemplate.query(SQL, new DocsMapper());
        return docsList;
    }
    public void delete(Integer id){
        String SQL = "delete from Docs where id = ?";
        jdbcTemplate.update(SQL, id);
    }
    public void update(Integer id, String name){
        String SQL = "update Docs set name = ? where = id = ?";
        jdbcTemplate.update(SQL, name, id);
    }

}


























