package tobeto.HotelReservationSystem.services.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tobeto.HotelReservationSystem.core.services.JwtService;
import tobeto.HotelReservationSystem.entities.Role;
import tobeto.HotelReservationSystem.entities.User;
import tobeto.HotelReservationSystem.repositories.UserRepository;
import tobeto.HotelReservationSystem.services.abstracts.AuthService;
import tobeto.HotelReservationSystem.services.dtos.requests.auth.LoginRequest;
import tobeto.HotelReservationSystem.services.dtos.requests.auth.RegisterRequest;
import tobeto.HotelReservationSystem.services.dtos.responses.auth.RegisterResponse;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.GUEST);
        userRepository.save(user);

        RegisterResponse response = new RegisterResponse();
        response.setUsername(user.getUsername());
        response.setRole(user.getRole());
        return response;
    }

    @Override
    public String login(LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            User user = (User) authentication.getPrincipal();
            return jwtService.generateToken(user.getUsername());
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid username or password");
        }
    }
    }

//TODO:AuthServiceImpl yarım kaldı.