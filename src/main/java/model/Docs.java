package model;

/**
 * Created by HMF on 18.03.2016.
 */
public class Docs {

    private long Id;
    private String Name;
    private String Link;

    public void setId(long id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setLink(String link) {
        Link = link;
    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getLink() {
        return Link;
    }
}
