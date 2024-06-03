package tobeto.HotelReservationSystem.services.dtos.requests.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoomRequest {
    private int id;
    private String roomType;
    private int capacity;
    private double price;
    private boolean availability;
    private int hotelId;
}
