package pl.edu.wat.wcy.pz.restaurantServer.form.response;


import lombok.Getter;
import lombok.Setter;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Reservation;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Role;
import pl.edu.wat.wcy.pz.restaurantServer.entity.User;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class JwtResponse {

    //    private String mail;
//    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(String jwtToken, User user) {
        String jwtToken1 = jwtToken;
        String tokenType = "Bearer";
        long userId = user.getUserId();
        String mail = user.getMail();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        Set<Role> roles = user.getRoles();
        List<Reservation> reservations = user.getReservations();

    }
}