package ForoHub.Blog.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ForoHub.Blog.Domain.Models.Response;

public interface ResponseRepository extends JpaRepository<Response, Long> {

    @Query("""
        select r from Response r where r.active = true
    """)
    Page<Response> findAllActive(Pageable pageable);

      @Query("""
                select r from Response r
                where
                r.active=TRUE
                and
                r.id= :id
                """)
    Response findByIdActive(@Param("id")  Long id);
}
