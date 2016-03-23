package DAO;

import model.Docs;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by HMF on 23.03.2016.
 */
public interface DocImpl {
    public void setDataSource(DataSource ds);

    public void create(String name, long link);

    public Docs getDocById(Integer id);

    public List<Docs> listDocs(long tabul);

    public void delete(Integer id);

    public void update(Integer id, String name);
}
