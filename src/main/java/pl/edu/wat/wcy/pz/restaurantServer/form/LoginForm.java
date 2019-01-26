package pl.edu.wat.wcy.pz.restaurantServer.form;

import lombok.Getter;

@Getter
public class LoginForm {
    private String mail;
    private String password;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}