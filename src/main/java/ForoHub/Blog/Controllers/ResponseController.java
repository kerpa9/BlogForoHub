package ForoHub.Blog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ForoHub.Blog.Domain.DTOs.PageableDTO;
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

    @GetMapping
    private ResponseEntity<PageableDTO> listResponse(@PageableDefault(size = 5) Pageable pageable) {
        Page<Response> responses = responseService.getAllResponse(pageable);
        Page<ResponseDTO> responseDTOs = responses.map(response -> new ResponseDTO(

                response.getTopic().getId(),
                response.getMessage(),
                response.getCreate_date(),
                response.getSolution()));

        return ResponseEntity.ok(PageableDTO.fromPage(responseDTOs));
    }
}