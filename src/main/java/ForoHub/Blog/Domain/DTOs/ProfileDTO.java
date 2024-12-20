package ForoHub.Blog.Domain.DTOs;

import jakarta.validation.constraints.NotBlank;

public record ProfileDTO(

        Long idUser,
        @NotBlank String name_profile

) {

}
