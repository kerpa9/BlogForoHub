package ForoHub.Blog.Domain.DTOs;

import jakarta.validation.constraints.NotBlank;

public record ProfileDTO(

        @NotBlank String name_profile

) {

}
