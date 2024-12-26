package ForoHub.Blog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ForoHub.Blog.Domain.DTOs.CourseDTO;
import ForoHub.Blog.Domain.Models.Course;
import ForoHub.Blog.Repository.CourseRepository;
import ForoHub.Blog.Services.ServiceBase.BaseUserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class CourseService extends BaseUserService<Course> {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private FilterLoginService filter;

    @Transactional
    public Course createCourse(@Valid CourseDTO courseDTO) {
        Course course = new Course();

        course.setId_login(filter.getUserLogin());
        course.setName(courseDTO.name());
        course.setCategory(courseDTO.category());
        course.setActive(courseDTO.active());

        return courseRepository.save(course);
    }

    @Transactional
    public Page<Course> getAllCourse(Pageable pageable) {
        Long loggedUserId = filter.getUserLogin();
        return courseRepository.findAllActive(loggedUserId, pageable);
    }

}
