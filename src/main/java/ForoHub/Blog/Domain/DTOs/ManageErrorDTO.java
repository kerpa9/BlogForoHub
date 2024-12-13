package ForoHub.Blog.Domain.DTOs;

import java.lang.reflect.Field;

import org.springframework.validation.FieldError;

public record ManageErrorDTO(
        String field, String error) {

    public ManageErrorDTO(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }

}
