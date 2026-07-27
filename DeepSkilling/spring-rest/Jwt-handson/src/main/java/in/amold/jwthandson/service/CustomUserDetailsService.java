package in.amold.jwthandson.service;

import in.amold.jwthandson.model.User;
import in.amold.jwthandson.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User myDbUser = userRepository.findByUsername((username));

        if (myDbUser == null) {
            throw new UsernameNotFoundException("User not found");
        }


        return org.springframework.security.core.userdetails.User.builder()
                .username(myDbUser.getUsername())
                .password(myDbUser.getPassword())
                .build();
    }
}
