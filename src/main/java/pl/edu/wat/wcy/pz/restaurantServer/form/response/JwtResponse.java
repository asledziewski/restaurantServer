package pl.edu.wat.wcy.pz.restaurantServer.form.response;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Reservation;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Role;
import pl.edu.wat.wcy.pz.restaurantServer.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class JwtResponse {

    private String jwtToken;
    private String tokenType;
    private long userId;
    private String mail;
    private String firstName;
    private String lastName;
    private Set<Role> roles;
    private List<Reservation> reservations;
//    private String mail;
//    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(String jwtToken, User user) {
        this.jwtToken = jwtToken;
        this.tokenType = "Bearer";
        this.userId = user.getUserId();
        this.mail = user.getMail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.roles = user.getRoles();
        this.reservations = user.getReservations();

    }
}