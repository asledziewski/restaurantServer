package pl.edu.wat.wcy.pz.restaurantServer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Reservation;
import pl.edu.wat.wcy.pz.restaurantServer.service.ReservationService;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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

    @GetMapping("/reservations/current")
    public Collection<Reservation> getCurrentReservations() {
        return reservationService.getCurrentReservations();
    }

    @GetMapping(value = "/reservations/{id}")
    public Reservation getReservationById(@PathVariable(name = "id") Long id) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        return reservation.orElse(null);
    }

    @PostMapping("/reservations")
    public void addReservation(@RequestBody Reservation reservation) {
        Date date = reservation.getDate();
        if (date != null) {
            if (date.before(new Date())) {
                throw new ResponseStatusException(
                        HttpStatus.FORBIDDEN, "Can't make reservation for past dates.");
            }
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
            String dateDays = dateFormatter.format(date);
            String dateTime = timeFormatter.format(date);
            reservation.setDateDays(dateDays);
            reservation.setDateTime(dateTime);
        }
        reservationService.addReservation(reservation);
    }

    @PutMapping("/reservations/{id}")
    public void updateReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
        reservationService.updateReservation(id, reservation);

    }

    @DeleteMapping("/reservations/{id}")
    public void deleteReservation(@PathVariable("id") Long id) {
        reservationService.deleteReservationById(id);
    }


}

