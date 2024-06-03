package tobeto.HotelReservationSystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tobeto.HotelReservationSystem.services.abstracts.RoomService;
import tobeto.HotelReservationSystem.services.dtos.requests.hotel.DeleteHotelRequest;
import tobeto.HotelReservationSystem.services.dtos.requests.room.AddRoomRequest;
import tobeto.HotelReservationSystem.services.dtos.requests.room.UpdateRoomRequest;
import tobeto.HotelReservationSystem.services.dtos.responses.room.AddRoomResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.room.DeleteRoomResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.room.GetAllRoomResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.room.UpdateRoomResponse;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomsController {
    private RoomService roomService;
    private RoomsController(RoomService roomService){
        this.roomService = roomService;
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddRoomResponse add(AddRoomRequest request){
        return roomService.add(request);
    }
    @PutMapping("/update")
    public UpdateRoomResponse update(UpdateRoomRequest request){
        return roomService.update(request);
    }
    @DeleteMapping("/delete")
    public DeleteRoomResponse delete(DeleteHotelRequest request){
        return roomService.delete(request);
    }
    @GetMapping("/getAll")
    public List<GetAllRoomResponse> getAll(){
        return roomService.getAll();
    }

}
