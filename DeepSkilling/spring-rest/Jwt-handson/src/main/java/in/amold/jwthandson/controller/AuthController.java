package in.amold.jwthandson.controller;


import in.amold.jwthandson.dto.LoginResponseDto;
import in.amold.jwthandson.dto.LoginUserDto;
import in.amold.jwthandson.dto.RegisterUserDto;
import in.amold.jwthandson.dto.ResponseDto;
import in.amold.jwthandson.model.User;
import in.amold.jwthandson.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@Valid @RequestBody RegisterUserDto userDto){
        userService.addUser(userDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("success");
        responseDto.setCode("USER_REGISTERED");
       return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginUserDto userDto){
        LoginResponseDto  responseDto = userService.loginUser(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

}
