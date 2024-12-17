package ForoHub.Blog.Domain.DTOs;

import java.time.LocalDateTime;
import java.util.List;

import ForoHub.Blog.Domain.Models.users.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ResponseDTO (
                @NotBlank String message,
                @NotBlank String topic,
                @Email @NotNull LocalDateTime create_date,
                @NotNull List<Users> author,
                @NotBlank String solution

) {
    
}
