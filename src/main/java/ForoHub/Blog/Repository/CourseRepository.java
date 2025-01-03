package ForoHub.Blog.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ForoHub.Blog.Domain.Models.Course;
import ForoHub.Blog.Repository.BaseRepository.BaseRepository;

public interface CourseRepository extends BaseRepository<Course> {

        @Override
        Optional<Course> findByIdAndIdLogin(Long id, Long id_login);

        @Override
        List<Course> findAllByIdLogin(Long id_login);

        @Query("SELECT c.name FROM Course c WHERE c.id = :id")
        String findNameCourse(@Param("id") Long id);

        @Query("SELECT COALESCE(MAX(c.id_course), 0) FROM Course c WHERE c.id_login = :id_login")
        Long findMaxSequentialIdForUser(@Param("id_login") Long id_login);

        @Query("""
                        select c from Course c
                        where
                        c.active = TRUE
                        and
                        c.id_login = :id_login
                        order by c.id_course
                        """)
        Page<Course> findAllActive(@Param("id_login") Long id_login, Pageable pageable);

        @Query("""
                        select c from Course c
                        where c.active = TRUE and
                        c.id_login = :id_login
                        and c.id_course = :id_course
                        """)
        Course findBySequentialIdAndId_login(
                        @Param("id_course") Long id_course,
                        @Param("id_login") Long id_login);
}