package baseData;

import model.Docs;

import java.util.List;

/**
 * Created by HMF on 24.03.2016.
 */
public interface DocImpl {
    public String create(String name, long link);

    public Docs getDocById(Integer id);

    public List<Docs> listDocs(int tabul);

    public void delete(Integer id);

    public void update(Integer id, String name);
}
