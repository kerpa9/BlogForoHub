package ForoHub.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ForoHub.Blog.Domain.Models.RegisterUser;

public interface RegisterRepository extends JpaRepository<RegisterUser, Long> {

    RegisterUser findByEmail(String email);
    boolean existsByEmail(String email);

}