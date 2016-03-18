package model;

/**
 * Created by HMF on 18.03.2016.
 */
public class Users {

    private int Id;
    private String Name;



    private String LastName;

    public Users(int id, String name, String lastName) {
        Id = id;
        Name = name;
        LastName = lastName;
    }

    public int getId() {
        return Id;
    }

    public String getName() {

        return Name;
    }

    public String getLastName() {
        return LastName;
    }


    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setName(String name) {
        Name = name;
    }


}
