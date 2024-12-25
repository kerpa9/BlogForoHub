package ForoHub.Blog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ForoHub.Blog.Domain.Models.RegisterUser;
import ForoHub.Blog.Repository.RegisterRepository;

@Service
public class FilterLoginService {

    @Autowired
    private RegisterRepository registerRepository;

    public Long getUserLogin() {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        RegisterUser user = registerRepository.findRegisterByEmail(auth.getName());

        return user.getId();
    }

}
