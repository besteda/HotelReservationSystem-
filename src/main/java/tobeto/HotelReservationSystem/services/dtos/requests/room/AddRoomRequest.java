package tobeto.HotelReservationSystem.services.dtos.requests.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRoomRequest {
    private String roomType;
    private int capacity;
    private double price;
    private boolean availability;
    private int hotelId;
}
