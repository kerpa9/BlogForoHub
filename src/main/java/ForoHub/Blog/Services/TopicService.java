package ForoHub.Blog.Services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ForoHub.Blog.Domain.DTOs.TopicDTO;
import ForoHub.Blog.Domain.Models.Response;
import ForoHub.Blog.Domain.Models.Topic;
import ForoHub.Blog.Repository.CourseRepository;
import ForoHub.Blog.Repository.TopicRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class TopicService {

        @Autowired
        private TopicRepository topicRepository;

        @Autowired
        private CourseRepository courseRepository;

        @Transactional
        public Topic createTopic(@Valid TopicDTO topicDTO) {
                var course = courseRepository.findById(topicDTO.idCourse()).get();
                String nameCourse = courseRepository.findNameCourse(topicDTO.idCourse());
                Topic topic = new Topic();

                topic.setMessage(topicDTO.message());
                topic.setTitle(topicDTO.title());
                topic.setCreate_date(topicDTO.create_date());
                topic.setActive(true);
                topic.setCourse(course);
                topic.setNameCourse(nameCourse);
                // Set Response
                if (topicDTO.response() != null) {
                        topic.setResponses(
                                        topicDTO.response().stream()
                                                        .map(r -> new Response(
                                                                        null, r.message(),
                                                                        r.create_date(),
                                                                        topic, null, r.active(), r.solution()))
                                                        .peek(r -> r.setTopic(topic))
                                                        .collect(Collectors.toList()));
                }

                return topicRepository.save(topic);
        }

}
