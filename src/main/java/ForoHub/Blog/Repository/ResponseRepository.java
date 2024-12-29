package ForoHub.Blog.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ForoHub.Blog.Domain.Models.Response;
import ForoHub.Blog.Repository.BaseRepository.BaseRepository;

public interface ResponseRepository extends BaseRepository<Response> {

    @Override
    Optional<Response> findByIdAndIdLogin(Long id, Long id_login);

    @Override
    List<Response> findAllByIdLogin(Long id_login);

    @Query("SELECT COALESCE(MAX(r.id_response), 0) FROM Response r WHERE r.id_login = :id_login")
    Long generatedInsertSequential(@Param("id_login") Long id_login);

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
    Response findByIdActive(@Param("id") Long id);

    @Query("""
            select r from Response r where r.active=TRUE
            and r.id_login = :id_login and r.id_response = :id_response""")
    Response findByIdUserLogin(
            @Param("id_response") Long id_response,
            @Param("id_login") Long id_login);
}