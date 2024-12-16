package ForoHub.Blog.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import ForoHub.Blog.Domain.Models.users.Users;


public interface UsersRepository extends JpaRepository<Users, Long> {
    
    UserDetails findByEmail(String email);
    boolean existsByEmail(String email);


}