package tobeto.HotelReservationSystem.services.dtos.responses.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdHotelResponse {
    private int id;
    private String name;
    private String address;
    private int phoneNumber;
    private String email;
}
