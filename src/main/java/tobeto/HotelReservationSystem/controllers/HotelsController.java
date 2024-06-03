package tobeto.HotelReservationSystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tobeto.HotelReservationSystem.services.abstracts.HotelService;
import tobeto.HotelReservationSystem.services.dtos.requests.hotel.AddHotelRequest;
import tobeto.HotelReservationSystem.services.dtos.requests.hotel.DeleteHotelRequest;
import tobeto.HotelReservationSystem.services.dtos.requests.hotel.UpdateHotelRequest;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.AddHotelResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.DeleteHotelResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.GetAllHotelResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.hotel.UpdateHotelResponse;

import java.util.List;


@RestController
@RequestMapping("/hotel")
public class HotelsController {

    private HotelService hotelService;
   private HotelsController (HotelService hotelService){
       this.hotelService = hotelService;
   }

@PostMapping ("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddHotelResponse add(AddHotelRequest request){
     return hotelService.add(request);
}
@PutMapping ("/update")
   public UpdateHotelResponse update(UpdateHotelRequest request){
    return hotelService.update(request);
}
@DeleteMapping ("/delete")
    public DeleteHotelResponse delete(DeleteHotelRequest request){
    return hotelService.delete(request);
}
@GetMapping ("/getAll")
    public List<GetAllHotelResponse> getAll(){
    return hotelService.getAll();
}
// @GetMapping ("/getById")
 //   public GetByIdHotelResponse getById(GetByIdRequest request){
  //     return hotelService.getById(request);
//}
}
