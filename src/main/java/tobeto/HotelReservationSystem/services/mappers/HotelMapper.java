package tobeto.HotelReservationSystem.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tobeto.HotelReservationSystem.entities.Hotel;
import tobeto.HotelReservationSystem.services.dtos.requests.hotel.AddHotelRequest;
import tobeto.HotelReservationSystem.services.dtos.requests.hotel.UpdateHotelRequest;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.AddHotelResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.DeleteHotelResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.GetAllHotelResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.UpdateHotelResponse;

import java.util.List;

@Mapper
public interface HotelMapper {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    AddHotelResponse hotelToAddHotelResponse(Hotel hotel);

    Hotel addHotelRequestToHotel(AddHotelRequest request);

    UpdateHotelResponse hotelToUpdateHotelResponse(Hotel hotel);

    Hotel updateHotelRequestToHotel(UpdateHotelRequest request);

    DeleteHotelResponse hotelToDeleteHotelResponse(String message);

    List<GetAllHotelResponse> hotelsToGetAllHotelResponses(List<Hotel> hotels);

    // Delete dönüşümleri
   // default DeleteHotelResponse hotelToDeleteHotelResponse(String message) {
     //   DeleteHotelResponse response = new DeleteHotelResponse();
     //   response.setMessage(message);
      //  return response;
    //}
}
