package pl.edu.wat.wcy.pz.restaurantServer.form.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Message {
    private String username;
    private String message;
    private Date date;
}