package ForoHub.Blog.Domain.DTOs;

import ForoHub.Blog.Config.Security.HashPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record RegisterUsersDTO(
        @Email @NotNull String email,
        @NotNull String password) {

        //             public RegisterUsersDTO {
        //         HashPassword hash = new HashPassword();
        //         password = hash.hashingPass(password);
        // }
}
