package pl.edu.wat.wcy.pz.restaurantServer.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Reservation;
import pl.edu.wat.wcy.pz.restaurantServer.repository.ReservationRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    public List<Reservation> getReservations(){
        return reservationRepository.findAll();
    };

    public Optional<Reservation> getReservationById(Long id){
        Optional <Reservation> reservation = reservationRepository.findById(id);
        if(reservation.isPresent()){
            return reservation;
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Reservation not found.");
        }
    };

    public Reservation addReservation(Reservation reservation) {
        List<Reservation> reservationList = reservationRepository.findAll();

        if (reservationList.stream().map(Reservation::getRTableId).anyMatch(reservation.getRTableId()::equals) && reservationList.stream().map(Reservation::getDate).anyMatch(reservation.getDate()::equals)) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Reservation for this table and date already exists.");
        }
        else {
            return reservationRepository.save(reservation);
        }
    }

    public void updateReservation(Long id, Reservation reservation) {

        Optional<Reservation> oldReservation = reservationRepository.findById(id);
        if(!oldReservation.isPresent())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Reservation not found.");
        else{
            reservation.setReservationId(id);
            reservationRepository.save(reservation);
        }

    }

    public void deleteReservationById(Long id){
        if(reservationRepository.findById(id).isPresent()){
            reservationRepository.deleteById(id);
        }
        else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Reservation not found.");
        }
    }

}
