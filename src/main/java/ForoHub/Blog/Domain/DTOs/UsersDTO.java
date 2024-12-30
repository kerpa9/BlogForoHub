package ForoHub.Blog.Domain.DTOs;

import ForoHub.Blog.Config.Security.HashPassword;
import ForoHub.Blog.Domain.Models.users.RoleUser;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UsersDTO(
                @NotBlank String name_profile,
                @NotBlank String phone,
                @Email @NotNull String email,
                @NotNull String password,
                @NotBlank @Pattern(regexp = "\\d{4,6}") String document,
                @NotNull RoleUser role_user,
                Boolean active) {

        public UsersDTO {
                HashPassword hash = new HashPassword();
                active = active == null ? true : active;
                password = hash.hashingPass(password);
                role_user = role_user == null ? RoleUser.USER : role_user;
        }

}
