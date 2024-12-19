package ForoHub.Blog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ForoHub.Blog.Domain.DTOs.CourseDTO;
import ForoHub.Blog.Domain.Models.Course;
import ForoHub.Blog.Repository.CourseRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public Course createCourse(@Valid CourseDTO courseDTO) {
        Course course = new Course();
        course.setName(courseDTO.name());
        course.setCategory(courseDTO.category());
        
        return courseRepository.save(course);
    }

}
