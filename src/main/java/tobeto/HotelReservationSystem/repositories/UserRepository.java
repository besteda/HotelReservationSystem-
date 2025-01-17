package tobeto.HotelReservationSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.HotelReservationSystem.entities.User;



public interface UserRepository extends JpaRepository<User,Integer>{
    User findByUsername(String username);


    // Optional<User> findByUsername(String username);
}
