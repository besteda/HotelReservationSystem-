package tobeto.HotelReservationSystem.services.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tobeto.HotelReservationSystem.entities.Role;
import tobeto.HotelReservationSystem.entities.User;
import tobeto.HotelReservationSystem.repositories.UserRepository;
import tobeto.HotelReservationSystem.services.abstracts.UserService;
import tobeto.HotelReservationSystem.services.dtos.requests.user.AddUserRequest;
import tobeto.HotelReservationSystem.services.dtos.responses.user.GetAllUsersResponse;
import tobeto.HotelReservationSystem.services.mappers.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public void addUser(AddUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole() != null ? request.getRole() : Role.GUEST);
        userRepository.save(user);
    }

    @Override
    public List<GetAllUsersResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toGetAllUsersResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

}
