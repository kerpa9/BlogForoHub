package ForoHub.Blog.Domain.DTOs;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicDTO(

        @NotBlank String title, @NotBlank String message, @NotNull LocalDateTime create_date,
        @NotNull Boolean status,
        // List<Course> course,
        @NotBlank String response

) {
    public TopicDTO {
        status = status == null ? true : status;
    }

}
