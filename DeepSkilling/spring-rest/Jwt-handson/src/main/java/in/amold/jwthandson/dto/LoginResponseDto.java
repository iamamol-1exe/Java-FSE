package in.amold.jwthandson.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private Long userId;
    private String token;
}
