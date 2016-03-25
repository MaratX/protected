package baseData;

import model.Docs;

import java.util.List;

/**
 * Created by HMF on 24.03.2016.
 */
public interface DocImpl {
    public String create(String name, long link, String format);

    public Docs getDocById(Integer id) throws Exception;

    public List<Docs> listDocs(int tabul);

    public String delete(Integer id) throws Exception;

    public void update(Integer id, String name);
}
