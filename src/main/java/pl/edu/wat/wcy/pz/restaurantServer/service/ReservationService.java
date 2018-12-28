package pl.edu.wat.wcy.pz.restaurantServer.service;

import pl.edu.wat.wcy.pz.restaurantServer.model.Reservation;

import java.util.Collection;
import java.util.Optional;

public interface ReservationService {

    Collection<Reservation> getReservations();

    Optional<Reservation> getReservationById(long id);

}
