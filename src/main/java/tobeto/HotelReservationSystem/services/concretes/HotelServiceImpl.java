package tobeto.HotelReservationSystem.services.concretes;

import org.springframework.stereotype.Service;
import tobeto.HotelReservationSystem.core.utils.exceptions.types.BusinessException;
import tobeto.HotelReservationSystem.entities.Hotel;
import tobeto.HotelReservationSystem.repositories.HotelRepository;
import tobeto.HotelReservationSystem.services.abstracts.HotelService;
import tobeto.HotelReservationSystem.services.dtos.requests.hotel.AddHotelRequest;
import tobeto.HotelReservationSystem.services.dtos.requests.hotel.DeleteHotelRequest;
import tobeto.HotelReservationSystem.services.dtos.requests.hotel.UpdateHotelRequest;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.AddHotelResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.DeleteHotelResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.GetAllHotelResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.UpdateHotelResponse;
import tobeto.HotelReservationSystem.services.mappers.HotelMapper;


import java.util.List;
@Service

public class HotelServiceImpl implements HotelService {
    private HotelRepository hotelRepository;
    private HotelServiceImpl (HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @Override
    public AddHotelResponse add(AddHotelRequest request) {
        Hotel hotel = HotelMapper.INSTANCE.addHotelRequestToHotel(request);
        Hotel saved = hotelRepository.save(hotel);
        AddHotelResponse response = HotelMapper.INSTANCE.hotelToAddHotelResponse(saved);
        return response;
    }

    @Override
    public UpdateHotelResponse update(UpdateHotelRequest request) {
        Hotel hotel = HotelMapper.INSTANCE.updateHotelRequestToHotel(request);
        Hotel updated = hotelRepository.save(hotel);
        UpdateHotelResponse response = HotelMapper.INSTANCE.hotelToUpdateHotelResponse(updated);
        return response;
    }

    @Override
    public DeleteHotelResponse delete(DeleteHotelRequest request) {
        Hotel hotel = hotelRepository.findById(request.getId())
                .orElseThrow(() -> new BusinessException("Hotel not found"));
        hotelRepository.deleteById(request.getId());
        return HotelMapper.INSTANCE.hotelToDeleteHotelResponse("Hotel deleted successfully");
    }

    @Override
    public List<GetAllHotelResponse> getAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        return HotelMapper.INSTANCE.hotelsToGetAllHotelResponses(hotels);
    }
}
