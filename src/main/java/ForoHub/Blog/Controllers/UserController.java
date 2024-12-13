package ForoHub.Blog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ForoHub.Blog.Domain.DTOs.UsersDTO;
import ForoHub.Blog.Domain.Models.users.Users;
import ForoHub.Blog.Services.UsersService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/register")

public class UserController {
    @Autowired
    UsersService usersService;

    @PostMapping
    public ResponseEntity<Users> createUser(@Valid UsersDTO usersDTO) {
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println(usersDTO);
        System.out.println("+++++++++++++++++++++++++++++++++");
        Users creatUsers = usersService.createInsertUser(usersDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creatUsers);

    }

}
