package ForoHub.Blog.Domain.DTOs;

import ForoHub.Blog.Domain.Models.users.RoleUser;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UsersDTO(
                @NotBlank String first_name,
                String last_name,
                @NotBlank String phone,
                @Email @NotNull String email,
                @NotNull String password,
                @NotBlank @Pattern(regexp = "\\d{4,6}") String document,
                @NotNull RoleUser role_user,
                Boolean active) {
                        
        public UsersDTO {
                active = active == null ? true : active;
        }

}
