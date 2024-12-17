package ForoHub.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ForoHub.Blog.Domain.Models.Response;

public interface ResponseRepository extends JpaRepository<Response, Long> {

}
