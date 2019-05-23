package pl.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginUserDTO {
    @NotNull
    @Size(min = 3, max = 30, message = "wrong length of login")
    private String login;

    @NotNull
    @Size(min = 5, max = 50, message = "wrong length of password")
    private String password;
}
