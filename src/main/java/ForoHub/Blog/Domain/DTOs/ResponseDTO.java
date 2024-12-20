package ForoHub.Blog.Domain.DTOs;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ResponseDTO (
                @NotBlank String message,
                @NotBlank String topic,
                @NotNull LocalDateTime create_date,
                // @NotNull List<Users> author,
                @NotBlank String solution

) {
    
}
