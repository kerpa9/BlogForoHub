package ForoHub.Blog.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ForoHub.Blog.Domain.Models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c.name FROM Course c WHERE c.id = :id")
    String findNameCourse(@Param("id") Long id);

    @Query("""
            select c from Course c
            where
            c.active=TRUE
            and
            c.id_login= :id
                        """)
    Page<Course> findAllActive(Long id, Pageable pageable);

}
