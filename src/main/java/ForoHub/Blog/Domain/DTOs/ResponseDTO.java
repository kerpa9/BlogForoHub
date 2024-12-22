package ForoHub.Blog.Domain.DTOs;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ResponseDTO(

                Long idTopic,
                @NotBlank String message,
                @NotNull LocalDateTime create_date,
                // @NotNull List<Users> author,
                @NotBlank String solution,
                Boolean active

) {

        public ResponseDTO {
                active = (active == null) ? true : active;
            }

}
