package pl.edu.wat.wcy.pz.restaurantServer.form;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class LoginForm {
    @NotBlank
    @Email
    @Size(max = 50)
    private String mail;
    @NotBlank
    @Size(min = 6, max = 30)
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