package pl.edu.wat.wcy.pz.restaurantServer.form.response;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
public class JwtResponse {

    private String jwtToken;
    private String tokenType;
    private String mail;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(String jwtToken, String mail, Collection<? extends GrantedAuthority> authorities) {
        this.jwtToken = jwtToken;
        this.tokenType = "Bearer";
        this.mail = mail;
        this.authorities = authorities;
    }
}