package ForoHub.Blog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ForoHub.Blog.Domain.DTOs.CourseDTO;
import ForoHub.Blog.Domain.DTOs.PageableDTO;
import ForoHub.Blog.Domain.Models.Course;
import ForoHub.Blog.Services.CourseService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/course")
@SecurityRequirement(name = "bearer-key")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@AuthenticationPrincipal @RequestBody @Valid CourseDTO courseDTO) {

        Course createCourse = courseService.createCourse(courseDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createCourse);
    }

    @GetMapping
    private ResponseEntity<PageableDTO> listCouses(@PageableDefault(size = 5) Pageable pageable) {

        Page<Course> courses = courseService.getAllCourse(pageable);

        Page<CourseDTO> courseDTO = courses
                .map((var course) -> new CourseDTO(null, course.getName(), course.getCategory(), null));

        return ResponseEntity.ok(PageableDTO.fromPage(courseDTO));

    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable @Valid Long id) {
        return courseService.findBySequentialId(id);

    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable @Valid Long id) {
        courseService.deleteCourse(id);
    }

}
