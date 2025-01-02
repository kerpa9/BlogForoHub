package ForoHub.Blog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ForoHub.Blog.Domain.DTOs.UsersDTO;
import ForoHub.Blog.Domain.Models.RegisterUser;
import ForoHub.Blog.Domain.Models.users.Users;
import ForoHub.Blog.Repository.UsersRepository;
import ForoHub.Blog.Services.UsersService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/register")

public class UserController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersRepository repository;

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody @Valid UsersDTO usersDTO) {
        try {
            if (usersDTO.document() == null || usersDTO.name_profile() == null ||
                    usersDTO.phone() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(null);
            }
            Users creatUsers = usersService.createInsertUser(usersDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(creatUsers);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }

    }

    public ResponseEntity<RegisterUser> registerUser(@RequestBody @Valid UsersDTO usersDTO) {
        RegisterUser creatUsers = usersService.registerUser(usersDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creatUsers);

    }

}