package tobeto.HotelReservationSystem.services.concretes;


import org.springframework.stereotype.Service;
import tobeto.HotelReservationSystem.core.utils.exceptions.types.BusinessException;
import tobeto.HotelReservationSystem.entities.Room;
import tobeto.HotelReservationSystem.repositories.RoomRepository;
import tobeto.HotelReservationSystem.services.abstracts.RoomService;
import tobeto.HotelReservationSystem.services.dtos.requests.hotel.DeleteHotelRequest;
import tobeto.HotelReservationSystem.services.dtos.requests.room.AddRoomRequest;
import tobeto.HotelReservationSystem.services.dtos.requests.room.UpdateRoomRequest;
import tobeto.HotelReservationSystem.services.dtos.responses.room.AddRoomResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.room.DeleteRoomResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.room.GetAllRoomResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.room.UpdateRoomResponse;
import tobeto.HotelReservationSystem.services.mappers.RoomMapper;

import java.util.List;
@Service

public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;
    private RoomServiceImpl(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }
    @Override
    public AddRoomResponse add(AddRoomRequest request) {
       Room room = RoomMapper.INSTANCE.addRoomRequestToRoom(request);
       Room saved = roomRepository.save(room);
       AddRoomResponse response = RoomMapper.INSTANCE.roomToAddRoomResponse(saved);
        return response;
    }

    @Override
    public UpdateRoomResponse update(UpdateRoomRequest request) {
       Room room = RoomMapper.INSTANCE.updateRoomRequestToRoom(request);
       Room updated = roomRepository.save(room);
       UpdateRoomResponse response = RoomMapper.INSTANCE.roomToUpdateRoomResponse(updated);
        return response;
    }

    @Override
    public DeleteRoomResponse delete(DeleteHotelRequest request) {
        Room room = roomRepository.findById(request.getId())
                .orElseThrow(() -> new BusinessException("Room not found"));
        roomRepository.deleteById(request.getId());
        return RoomMapper.INSTANCE.roomToDeleteRoomResponse("Room deleted successfully.");
    }

    @Override
    public List<GetAllRoomResponse> getAll() {

        List<Room> rooms = roomRepository.findAll();
        return RoomMapper.INSTANCE.roomsToGetAllRoomResponses(rooms);
    }
}
