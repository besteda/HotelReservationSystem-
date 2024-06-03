package tobeto.HotelReservationSystem.services.abstracts;

import tobeto.HotelReservationSystem.services.dtos.requests.hotel.DeleteHotelRequest;
import tobeto.HotelReservationSystem.services.dtos.requests.room.AddRoomRequest;
import tobeto.HotelReservationSystem.services.dtos.requests.room.UpdateRoomRequest;
import tobeto.HotelReservationSystem.services.dtos.responses.room.AddRoomResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.room.DeleteRoomResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.room.GetAllRoomResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.room.UpdateRoomResponse;

import java.util.List;

public interface RoomService {
    AddRoomResponse add(AddRoomRequest request);

    UpdateRoomResponse update(UpdateRoomRequest request);

    DeleteRoomResponse delete(DeleteHotelRequest request);

    List<GetAllRoomResponse> getAll();
}
