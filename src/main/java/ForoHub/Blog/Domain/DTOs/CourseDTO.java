package ForoHub.Blog.Domain.DTOs;

import jakarta.validation.constraints.NotBlank;

public record CourseDTO(

        @NotBlank String name,
        @NotBlank String category

) {

}
