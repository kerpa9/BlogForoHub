package ForoHub.Blog.Domain.DTOs;

import jakarta.validation.constraints.NotBlank;

public record CourseDTO(

                @NotBlank String name,
                @NotBlank String category,
                Boolean active

) {

        public CourseDTO {
                active = active == null ? true : active;
        }

}
