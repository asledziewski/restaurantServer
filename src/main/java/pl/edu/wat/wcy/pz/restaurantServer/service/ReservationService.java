package pl.edu.wat.wcy.pz.restaurantServer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
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
        return reservationRepository.findById(id);
    };

    public Reservation addReservation(Reservation reservation) {
        List<Reservation> reservationList = reservationRepository.findAll();

//        if (reservationList.stream().map(Reservation::getEnglishName).anyMatch(reservation.getEnglishName()::equals) || reservationList.stream().map(Reservation::getPolishName).anyMatch(reservation.getPolishName()::equals))
//            throw new RuntimeException("Reservation with this name already exists.");

        return reservationRepository.save(reservation);
    }

    public void updateReservation(Long id, Reservation reservation) {

        Optional<Reservation> oldReservation = reservationRepository.findById(id);
        if(!oldReservation.isPresent())
            throw new RuntimeException("Reservation with id " + id + "does not exist");
        else{
            reservation.setReservationId(id);
            reservationRepository.save(reservation);
        }

    }

    public void deleteReservationById(Long id){
        reservationRepository.deleteById(id);
    }

}
