package ForoHub.Blog.Domain.DTOs;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record TopicDTO(

        Long id,
        Long id_topic,
        @NotBlank String title, 
        @NotBlank String message, 
         LocalDateTime create_date,
         Boolean active,
        List<ResponseDTO> response,
        String name_course,
        Long idCourse

) {
    public TopicDTO {
        active = active == null ? true : active;
    }

}
