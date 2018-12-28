package pl.edu.wat.wcy.pz.restaurantServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.wcy.pz.restaurantServer.model.Reservation;
import pl.edu.wat.wcy.pz.restaurantServer.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class ReservationServiceImplementation implements ReservationService {

    private final ReservationRepository ReservationRepository;

    @Autowired
    public ReservationServiceImplementation(ReservationRepository ReservationRepository) {
        this.ReservationRepository = ReservationRepository;
    }

    @Override
    public Collection<Reservation> getReservations() {
        Collection<Reservation> reservations = new ArrayList<>();
        ReservationRepository.findAll().forEach(reservations::add);
        return reservations;
    }

    @Override
    public Optional<Reservation> getReservationById(long id) {
        return ReservationRepository.findById(id);
    }
}


