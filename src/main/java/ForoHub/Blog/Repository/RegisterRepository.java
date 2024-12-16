package ForoHub.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import ForoHub.Blog.Domain.Models.RegisterUser;


public interface RegisterRepository extends JpaRepository<RegisterUser, Long> {

    UserDetails findByEmail(String email);
    boolean existsByEmail(String email);

}