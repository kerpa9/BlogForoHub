package ForoHub.Blog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import ForoHub.Blog.Domain.DTOs.UsersDTO;
import ForoHub.Blog.Domain.Models.users.Users;
import ForoHub.Blog.Repository.UsersRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public Users createInsertUser(@RequestBody @Valid UsersDTO usersDTO) {
        // if(usersRepository)

        Users users = usersDTO.validateModeluser();
        return usersRepository.save(users);
    }

    Users users = new Users();

}
