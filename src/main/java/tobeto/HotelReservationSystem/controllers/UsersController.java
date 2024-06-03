package tobeto.HotelReservationSystem.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.HotelReservationSystem.services.abstracts.UserService;
import tobeto.HotelReservationSystem.services.dtos.requests.user.AddUserRequest;
import tobeto.HotelReservationSystem.services.dtos.responses.user.GetAllUsersResponse;


import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody AddUserRequest request) {
        userService.addUser(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GetAllUsersResponse>> getAllUsers() {
        List<GetAllUsersResponse> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
