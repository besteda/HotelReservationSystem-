package tobeto.HotelReservationSystem.services.dtos.responses.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteRoomResponse {
    private int id;
    private String roomType;
    private int capacity;
    private double price;
    private  boolean availability;
    private String hotelName;
}
