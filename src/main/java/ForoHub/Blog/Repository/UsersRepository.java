package ForoHub.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ForoHub.Blog.Domain.Models.users.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}