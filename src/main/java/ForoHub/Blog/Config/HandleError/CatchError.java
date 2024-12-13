package ForoHub.Blog.Config.HandleError;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ForoHub.Blog.Config.HandleException.HandleException;
import ForoHub.Blog.Domain.DTOs.ManageErrorDTO;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class CatchError {

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity notFound() {
        return ResponseEntity.notFound().build();
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity batRequest400(MethodArgumentNotValidException e) {
        var errors = e.getFieldErrors().stream().map(ManageErrorDTO::new).toList();

        return ResponseEntity.badRequest().body(errors);

    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(HandleException.class)
    public ResponseEntity manageErrorValidate(HandleException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
