package ForoHub.Blog.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import ForoHub.Blog.Domain.Models.users.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

    UserDetails findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("""
            select u from Users u where u.active=true

                 """)
    Page<Users> listUsers(Pageable pageable);

}