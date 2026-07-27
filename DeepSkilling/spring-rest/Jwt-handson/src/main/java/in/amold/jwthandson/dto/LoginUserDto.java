package in.amold.jwthandson.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Lazy;

@Getter
@Setter
public class LoginUserDto {
    @NotNull
    @NotBlank
    private String username;
    @Length(min=3)
    private String password;
}
