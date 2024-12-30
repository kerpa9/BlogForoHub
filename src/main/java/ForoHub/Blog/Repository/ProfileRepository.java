package ForoHub.Blog.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ForoHub.Blog.Domain.Models.Profile;
import ForoHub.Blog.Domain.Models.Response;
import ForoHub.Blog.Repository.BaseRepository.BaseRepository;

public interface ProfileRepository extends BaseRepository<Profile> {

    @Override
    Optional<Profile> findByIdAndIdLogin(Long id, Long id_login);

    @Override
    List<Profile> findAllByIdLogin(Long id_login);

    @Query("SELECT COALESCE(MAX(p.id_profile), 0) FROM Profile p WHERE p.id_login = :id_login")
    Long generatedInsertSequential(@Param("id_login") Long id_profile);

    @Query("""
                select p from Profile p where p.active = true
            """)
    Page<Profile> findAllActive(Pageable pageable);

    @Query("""
            select p from Profile p
            where
            p.active=TRUE
            and
            p.id= :id
            """)
    Response findByIdActive(@Param("id") Long id);

    @Query("""
        select p from Profile p where p.active=TRUE
        and p.id_login = :id_login and p.id_profile = :id_profile""")
Response findByIdUserLogin(
        @Param("id_profile") Long id_profile,
        @Param("id_login") Long id_login);

}
