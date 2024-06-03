package tobeto.HotelReservationSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Table (name="rooms")
@Getter
@Setter
@Table(name="rooms")
@NoArgsConstructor
@AllArgsConstructor

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "room_type")
    private String roomType;

    private int capacity;

    private double price;

    private boolean availability;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
