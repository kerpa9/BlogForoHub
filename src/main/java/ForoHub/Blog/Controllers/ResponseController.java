package ForoHub.Blog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ForoHub.Blog.Domain.DTOs.ResponseDTO;
import ForoHub.Blog.Domain.Models.Response;
import ForoHub.Blog.Services.ResponseService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/response")
@SecurityRequirement(name = "bearer-key")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @PostMapping
    private ResponseEntity<Response> createResponse(@RequestBody @Valid ResponseDTO responseDTO) {
        Response createResponse = responseService.createResponse(responseDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createResponse);

    }

}
