package pl.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegisterUserDTO {
    private long id;

    @NotNull
    @Size(min = 3, max = 30, message = "wrong length of first name")
    private String firstName;

    @NotNull
    @Size(min = 3, max = 30, message = "wrong length of last name")
    private String lastName;

    @NotNull
    @Size(min = 3, max = 30, message = "wrong length of login")
    private String login;

    @NotNull
    @Size(min = 5, max = 50, message = "wrong length of password")
    private String password;

    @NotNull
    private String confirmPassword;
}
