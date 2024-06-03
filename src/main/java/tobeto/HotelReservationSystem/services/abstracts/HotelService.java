package tobeto.HotelReservationSystem.services.abstracts;

import tobeto.HotelReservationSystem.services.dtos.requests.hotel.AddHotelRequest;
import tobeto.HotelReservationSystem.services.dtos.requests.hotel.DeleteHotelRequest;
import tobeto.HotelReservationSystem.services.dtos.requests.hotel.UpdateHotelRequest;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.AddHotelResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.DeleteHotelResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.GetAllHotelResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.UpdateHotelResponse;

import java.util.List;

public interface HotelService {
    AddHotelResponse add(AddHotelRequest request);

    UpdateHotelResponse update(UpdateHotelRequest request);

    DeleteHotelResponse delete(DeleteHotelRequest request);


    List<GetAllHotelResponse> getAll();
}
