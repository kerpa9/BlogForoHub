package ForoHub.Blog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ForoHub.Blog.Domain.DTOs.RegisterUsersDTO;
import ForoHub.Blog.Domain.Models.RegisterUser;
import ForoHub.Blog.Domain.Models.users.Users;
import ForoHub.Blog.Repository.RegisterRepository;
import ForoHub.Blog.Repository.UsersRepository;
import jakarta.validation.Valid;

@Service
public class RegisterService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RegisterRepository registerRepository;


    public RegisterUser inserDatabase(@Valid RegisterUsersDTO register) {
        RegisterUser registerUser = new RegisterUser();
        registerUser.setEmail(register.email());
        registerUser.setPassword(register.password());

        RegisterUser savedRegisterUser = registerRepository.save(registerUser);

        return savedRegisterUser;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        RegisterUser register = registerRepository.findByEmail(email);
        Users user = usersRepository.findByEmail(email);

        if (register == null) {
            throw new UsernameNotFoundException("User not found in RegisterRepository");
        }

        if (user == null) {
            throw new UsernameNotFoundException("User not found in UsersRepository");
        }

        if (!register.getEmail().equals(user.getEmail())) {
            throw new UsernameNotFoundException("Emails do not match");
        }


        return registerRepository.findByEmail(email);
    }
}
