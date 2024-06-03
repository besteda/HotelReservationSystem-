package tobeto.HotelReservationSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.HotelReservationSystem.entities.Hotel;

public interface HotelRepository extends JpaRepository <Hotel,Integer>{
}
