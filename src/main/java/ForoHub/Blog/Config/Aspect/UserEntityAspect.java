package ForoHub.Blog.Config.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import ForoHub.Blog.Config.RegisterFilterID.IUserOwnedEntity;
import ForoHub.Blog.Domain.Models.users.Users;

public class UserEntityAspect {
       @Autowired
    private SecurityContextHolder securityContextHolder;
    
    @Before("execution(* ForoHub.Blog.Repository.*.save*(..)) && args(entity)")
    public void beforeSave(JoinPoint joinPoint, Object entity) {
        if (entity instanceof IUserOwnedEntity) {
            IUserOwnedEntity userEntity = (IUserOwnedEntity) entity;
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Users currentUser = (Users) auth.getPrincipal();
            userEntity.setUserId(currentUser.getId());
        }
    }
    
}
