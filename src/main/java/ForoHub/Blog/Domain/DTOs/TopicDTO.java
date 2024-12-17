package ForoHub.Blog.Domain.DTOs;

import java.time.LocalDateTime;
import java.util.List;

import ForoHub.Blog.Domain.Models.Course;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicDTO (

                @NotBlank String title,
                @NotBlank String message,
                @Email @NotNull LocalDateTime create_date,
                @NotNull  Boolean status,
                @NotNull List<Course> course,
                @NotBlank String response

){
    
}
