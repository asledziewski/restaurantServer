package pl.edu.wat.wcy.pz.restaurantServer.controller;

import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Reservation;
import pl.edu.wat.wcy.pz.restaurantServer.service.ReservationService;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
public class ReservationController {

    private ReservationService reservationService;


    @GetMapping("/reservations")
    public Collection<Reservation> getReservations() {
        return reservationService.getReservations();
    }


    @GetMapping(value = "/reservations/{id}")
    public Reservation getReservationById(@PathVariable(name = "id") Long id){
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        if(!reservation.isPresent())
            throw new RuntimeException("Reservation not found");

        return reservation.orElse(null);
    }

    @PostMapping("/reservations")
    public ResponseEntity<Object> addReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.addReservation(reservation);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdReservation.getReservationId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/reservations/{id}")
    public void updateReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
        reservationService.updateReservation(id, reservation);

    }

    @DeleteMapping("/reservations/{id}")
    public void deleteReservation(@PathVariable("id") Long id){
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        if(!reservation.isPresent())
            throw new RuntimeException("Reservation not found");
        reservationService.deleteReservationById(id);
    }


}

