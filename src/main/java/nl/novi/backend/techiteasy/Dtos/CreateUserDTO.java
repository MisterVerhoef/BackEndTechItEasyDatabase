package nl.novi.backend.techiteasy.Dtos;

import javax.validation.constraints.Size;

public class CreateUserDTO {



    private String userName;

    @Size(min=6, max=30)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
