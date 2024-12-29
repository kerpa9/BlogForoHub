package ForoHub.Blog.Services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

        @Autowired
        private FilterLoginService filter;

        @Transactional
        public Topic createTopic(@Valid TopicDTO topicDTO) {
                Topic topic = new Topic();
                var course = courseRepository.findById(topicDTO.idCourse()).get();
                String nameCourse = courseRepository.findNameCourse(topicDTO.idCourse());

                Long userId = filter.getUserLogin();

                Long sequentialTopic = topicRepository.generatedInsertSequential(userId) + 1;

                topic.setId_login(filter.getUserLogin());
                topic.setId_topic(sequentialTopic);
                topic.setMessage(topicDTO.message());
                topic.setTitle(topicDTO.title());
                topic.setCreate_date(topicDTO.create_date());
                topic.setActive(topicDTO.active());
                topic.setCourse(course);
                topic.setName_course(nameCourse);
                // Set Response
                if (topicDTO.response() != null) {
                        topic.setResponses(
                                        topicDTO.response().stream()
                                                        .map(r -> new Response(
                                                                        null, null, null, r.message(),
                                                                        r.create_date(),
                                                                        topic, null, r.active(), r.solution()))
                                                        .peek(r -> r.setTopic(topic))
                                                        .collect(Collectors.toList()));
                }

                return topicRepository.save(topic);
        }

        @Transactional
        public Page<Topic> getAllTopics(Pageable pageable) {

                Long loggedUserId = filter.getUserLogin();
                return topicRepository.findAllActive(loggedUserId, pageable);

        }

        @Transactional
        public Topic getOneTopicByID(Long id) {

                // System.out.println("******************************");
                // System.out.println(topicRepository.findByIdUserLogin(id,
                // filter.getUserLogin()));
                // System.out.println("******************************");

                return topicRepository.findByIdUserLogin(id, filter.getUserLogin());

        }

        @Transactional
        public void deleteTopic(Long id) {
                Topic topicModel = topicRepository.findByIdUserLogin(id, filter.getUserLogin());
                topicModel.setStausInactiveTopic();
        }

}
