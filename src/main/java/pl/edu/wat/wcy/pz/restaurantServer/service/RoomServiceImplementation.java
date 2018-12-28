package pl.edu.wat.wcy.pz.restaurantServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.wcy.pz.restaurantServer.model.Room;
import pl.edu.wat.wcy.pz.restaurantServer.repository.RoomRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class RoomServiceImplementation implements RoomService {

    private final RoomRepository RoomRepository;

    @Autowired
    public RoomServiceImplementation(RoomRepository RoomRepository) {
        this.RoomRepository = RoomRepository;
    }

    @Override
    public Collection<Room> getRooms() {
        Collection<Room> rooms = new ArrayList<>();
        RoomRepository.findAll().forEach(rooms::add);
        return rooms;
    }

    @Override
    public Optional<Room> getRoomById(long id) {
        return RoomRepository.findById(id);
    }
}


