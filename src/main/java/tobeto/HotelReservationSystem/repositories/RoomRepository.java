package tobeto.HotelReservationSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.HotelReservationSystem.entities.Room;

public interface RoomRepository extends JpaRepository<Room,Integer> {
}
