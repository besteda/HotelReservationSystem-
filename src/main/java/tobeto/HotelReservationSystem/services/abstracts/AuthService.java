package tobeto.HotelReservationSystem.services.abstracts;

import tobeto.HotelReservationSystem.services.dtos.requests.auth.LoginRequest;
import tobeto.HotelReservationSystem.services.dtos.requests.auth.RegisterRequest;
import tobeto.HotelReservationSystem.services.dtos.responses.auth.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequest request);

    String login(LoginRequest request);

}
