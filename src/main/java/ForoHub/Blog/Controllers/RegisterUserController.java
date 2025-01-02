package ForoHub.Blog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ForoHub.Blog.Config.HandleException.HandleException;
import ForoHub.Blog.Domain.DTOs.DatosJWTTokenDTO;
import ForoHub.Blog.Domain.DTOs.RegisterUsersDTO;
import ForoHub.Blog.Domain.Models.RegisterUser;
import ForoHub.Blog.Repository.UsersRepository;
import ForoHub.Blog.Services.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/login")

public class RegisterUserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsersRepository usersRepository;

    @SuppressWarnings("rawtypes")
    @PostMapping
    public ResponseEntity registerUsers(@RequestBody @Valid RegisterUsersDTO registerUsersDTO) {

        try {
            if (!usersRepository.existsByEmail(registerUsersDTO.email())) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found. Cannot register the user");
            }

            Authentication token = new UsernamePasswordAuthenticationToken(registerUsersDTO.email(),
                    registerUsersDTO.password());
            var userAuth = authenticationManager.authenticate(token);
            var jwtToken = tokenService.generatedToken((RegisterUser) userAuth.getPrincipal());

            return ResponseEntity.ok(new DatosJWTTokenDTO(jwtToken));

        } catch (Exception e) {
            throw new HandleException("Error insert register data");
        }

    }

}
