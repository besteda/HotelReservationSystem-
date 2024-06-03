package tobeto.HotelReservationSystem.services.dtos.responses.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tobeto.HotelReservationSystem.entities.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {
    private String username;
    private Role role;
}
