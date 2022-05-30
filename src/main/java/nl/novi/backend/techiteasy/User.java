package nl.novi.backend.techiteasy;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password;

    public User() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }



    public String getPassword(String password) {
        return this.password;
    }
}
