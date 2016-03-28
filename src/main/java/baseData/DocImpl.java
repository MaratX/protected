package baseData;

import model.Docs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HMF on 24.03.2016.
 */
public interface DocImpl {
    public String create(String name, long link, String format) throws Exception;

    public Docs getDocById(Integer id) throws Exception;

    public ArrayList<Docs> listDocs(int tabul) throws Exception;

    public String delete(Integer id) throws Exception;

    public String update(int id, String name) throws Exception;
}
