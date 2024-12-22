package ForoHub.Blog.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ForoHub.Blog.Domain.Models.Response;

public interface ResponseRepository extends JpaRepository<Response, Long> {

    @Query("""
        select r from Response r where r.active = true
    """)
    Page<Response> findAllActive(Pageable pageable);
}
