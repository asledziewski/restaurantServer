package pl.edu.wat.wcy.pz.restaurantServer.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.pz.restaurantServer.model.Reservation;
import pl.edu.wat.wcy.pz.restaurantServer.service.ReservationService;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8101", maxAge = 3600)
@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public Collection<Reservation> getReservations() {
        return reservationService.getReservations();
    }


    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public Reservation getReservationById(@PathVariable long id) throws ObjectNotFoundException {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        return reservation.orElseGet(Reservation::new);
    }
}

