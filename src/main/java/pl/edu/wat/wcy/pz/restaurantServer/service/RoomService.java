package pl.edu.wat.wcy.pz.restaurantServer.service;

import pl.edu.wat.wcy.pz.restaurantServer.model.Room;

import java.util.Collection;
import java.util.Optional;

public interface RoomService {

    Collection<Room> getRooms();

    Optional<Room> getRoomById(long id);

}
