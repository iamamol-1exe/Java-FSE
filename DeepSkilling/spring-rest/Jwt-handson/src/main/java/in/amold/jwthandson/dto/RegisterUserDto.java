package in.amold.jwthandson.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class RegisterUserDto {
    @NotNull
    @NotBlank
    private String username;
    @Length(min=3)
    private String password;
    @NotNull
    @Email
    private String email;
}
