package ForoHub.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ForoHub.Blog.Domain.Models.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
