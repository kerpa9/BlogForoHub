package ForoHub.Blog.Domain.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record RegisterUsersDTO(
        @Email @NotNull String email,
        @NotNull String password) {
}
