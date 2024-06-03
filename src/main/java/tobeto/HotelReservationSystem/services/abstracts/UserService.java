package tobeto.HotelReservationSystem.services.abstracts;

import org.springframework.security.core.userdetails.UserDetailsService;
import tobeto.HotelReservationSystem.services.dtos.requests.user.AddUserRequest;
import tobeto.HotelReservationSystem.services.dtos.responses.user.GetAllUsersResponse;


import java.util.List;

public interface UserService extends UserDetailsService {

    void addUser(AddUserRequest request);

    List<GetAllUsersResponse> getAllUsers();
}
