package in.amold.jwthandson.service;

import in.amold.jwthandson.dto.LoginResponseDto;
import in.amold.jwthandson.dto.LoginUserDto;
import in.amold.jwthandson.dto.RegisterUserDto;
import in.amold.jwthandson.model.User;
import in.amold.jwthandson.repository.UserRepository;
import in.amold.jwthandson.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager; // <-- Add this
    private final JwtService jwtService;

    public void addUser(RegisterUserDto user){
        User DbUser = new User();
        DbUser.setUsername(user.getUsername());
        DbUser.setEmail(user.getEmail());
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        DbUser.setPassword(encodedPassword);
        userRepository.save(DbUser);
    }

    public LoginResponseDto loginUser(LoginUserDto userDto){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDto.getUsername(),
                        userDto.getPassword()
                )
        );


        UserDetails userDetails = (UserDetails) authentication.getPrincipal();


        User user = userRepository.findByUsername(userDto.getUsername());


        String jwtToken = jwtService.generateToken(userDetails);

        LoginResponseDto response = new LoginResponseDto();
        response.setUserId(user.getId());
        response.setToken(jwtToken);

        return response;
    }

}
