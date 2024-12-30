package ForoHub.Blog.Domain.DTOs;

import jakarta.validation.constraints.NotBlank;

public record ProfileDTO(

                Long id_profile,
                Long idUser,
                @NotBlank String name_profile,
                Boolean active

) {

        public ProfileDTO {
                active = active == null ? true : active;

        }

}
