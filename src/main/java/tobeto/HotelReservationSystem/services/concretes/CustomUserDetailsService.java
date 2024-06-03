package tobeto.HotelReservationSystem.services.concretes;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import tobeto.HotelReservationSystem.core.utils.exceptions.types.BusinessException;
import tobeto.HotelReservationSystem.entities.Role;
import tobeto.HotelReservationSystem.entities.User;
import tobeto.HotelReservationSystem.repositories.UserRepository;

import java.util.Collection;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new BusinessException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities(user.getRole()));
    }

    private Collection<? extends GrantedAuthority> authorities(Role role) {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    }

