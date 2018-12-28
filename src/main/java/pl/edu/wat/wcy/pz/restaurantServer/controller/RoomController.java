package pl.edu.wat.wcy.pz.restaurantServer.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.pz.restaurantServer.model.Room;
import pl.edu.wat.wcy.pz.restaurantServer.service.RoomService;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8101", maxAge = 3600)
@RestController
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public Collection<Room> getRooms() {
        return roomService.getRooms();
    }


    @RequestMapping(value = "/room/{id}", method = RequestMethod.GET)
    public Room getRoomById(@PathVariable long id) throws ObjectNotFoundException {
        Optional<Room> room = roomService.getRoomById(id);
        return room.orElseGet(Room::new);
    }
}

