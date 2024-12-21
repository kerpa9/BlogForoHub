package ForoHub.Blog.Domain.DTOs;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicDTO(

        @NotBlank String title,
        @NotBlank String message,
        @NotNull LocalDateTime create_date,
        @NotNull Boolean active,
        List<ResponseDTO> response
        // Long idCourse
// @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch =
// FetchType.EAGER)
// List<Course> course
// @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch =
// FetchType.EAGER)
// List<Response> response

) {
    public TopicDTO {
        active = active == null ? true : active;
    }

}
