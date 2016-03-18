package model;

/**
 * Created by HMF on 18.03.2016.
 */
public class Docs {

    private final long Id;
    private final String Name;
    private final String Link;

    public Docs(long id, String name, String link) {
        Id = id;
        Name = name;
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
