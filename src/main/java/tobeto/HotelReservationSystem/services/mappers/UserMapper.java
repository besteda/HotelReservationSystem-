package tobeto.HotelReservationSystem.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tobeto.HotelReservationSystem.entities.User;
import tobeto.HotelReservationSystem.services.dtos.requests.auth.RegisterRequest;
import tobeto.HotelReservationSystem.services.dtos.responses.auth.RegisterResponse;
import tobeto.HotelReservationSystem.services.dtos.responses.user.GetAllUsersResponse;


@Mapper (componentModel = "spring")
public interface UserMapper {

//    @Mapping(target = "role", constant = "ROLE_GUEST")
//    User registerRequestToUser(RegisterRequest request);

    GetAllUsersResponse toGetAllUsersResponse(User user);


}
