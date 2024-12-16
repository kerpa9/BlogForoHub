package ForoHub.Blog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ForoHub.Blog.Domain.DTOs.RegisterUsersDTO;
import ForoHub.Blog.Domain.DTOs.UsersDTO;
import ForoHub.Blog.Domain.Models.RegisterUser;
import ForoHub.Blog.Domain.Models.users.Users;
import ForoHub.Blog.Repository.RegisterRepository;
import ForoHub.Blog.Repository.UsersRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RegisterRepository registerRepository;

    @Transactional
    public Users createInsertUser(@Valid UsersDTO usersDTO) {

        Users users = new Users();
        users.setFirst_name(usersDTO.first_name());
        users.setLast_name(usersDTO.last_name());
        users.setPhone(usersDTO.phone());
        users.setDocument(usersDTO.document());
        users.setEmail(usersDTO.email());
        users.setPassword(usersDTO.password());
        users.setRole_user(usersDTO.role_user());
        users.setActive(usersDTO.active());
        return usersRepository.save(users);

    }

    public RegisterUser registerUser(@Valid UsersDTO registerUser){
        RegisterUser register = new RegisterUser();
        register.setEmail(registerUser.email());
        register.setPassword(registerUser.password());
        return registerRepository.save(register);

    }

}
