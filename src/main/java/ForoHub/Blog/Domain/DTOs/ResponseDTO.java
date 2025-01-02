package ForoHub.Blog.Domain.DTOs;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record ResponseDTO(

                Long id_response,
                Long idTopic,
                Long idUsers,
                @NotBlank String message,
                LocalDateTime create_date,
                // @NotNull List<Users> author,
                String solution,
                Boolean active

) {

        public ResponseDTO {
                active = (active == null) ? true : active;
        }

}
