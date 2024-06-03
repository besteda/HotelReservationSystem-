package tobeto.HotelReservationSystem.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tobeto.HotelReservationSystem.entities.Room;
import tobeto.HotelReservationSystem.services.dtos.requests.room.AddRoomRequest;
import tobeto.HotelReservationSystem.services.dtos.responses.room.AddRoomResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.room.DeleteRoomResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.room.GetAllRoomResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.room.UpdateRoomResponse;
import tobeto.HotelReservationSystem.services.dtos.requests.room.UpdateRoomRequest;

import java.util.List;

@Mapper

public interface RoomMapper {
RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

@Mapping(source = "hotel.id", target = "hotelName")
AddRoomResponse roomToAddRoomResponse(Room room);

@Mapping(source = "hotelId", target = "hotel.id")
Room addRoomRequestToRoom(AddRoomRequest request);

UpdateRoomResponse roomToUpdateRoomResponse(Room room);

@Mapping(source = "hotelId", target = "hotel.id")
Room updateRoomRequestToRoom(UpdateRoomRequest request);

@Mapping(source = "hotel.id", target = "hotelName")
GetAllRoomResponse roomToGetAllRoomResponse(Room room);

List<GetAllRoomResponse> roomsToGetAllRoomResponses(List<Room> rooms);

DeleteRoomResponse roomToDeleteRoomResponse(String message);

}
