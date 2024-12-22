package ForoHub.Blog.Services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ForoHub.Blog.Domain.DTOs.TopicDTO;
import ForoHub.Blog.Domain.Models.Response;
import ForoHub.Blog.Domain.Models.Topic;
import ForoHub.Blog.Repository.TopicRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class TopicService {

        @Autowired
        private TopicRepository topicRepository;

        @Transactional
        public Topic createTopic(@Valid TopicDTO topicDTO) {
                Topic topic = new Topic(
                                null, topicDTO.title(),
                                topicDTO.message(),
                                topicDTO.create_date(),
                                topicDTO.active(), null);

                if (topicDTO.response() != null) {
                        topic.setResponses(
                                        topicDTO.response().stream()
                                                        .map(r -> new Response(
                                                                        null, r.message(),
                                                                        r.create_date(),
                                                                        topic, r.active(), r.solution()))
                                                        .peek(r -> r.setTopic(topic))
                                                        .collect(Collectors.toList()));
                }

                return topicRepository.save(topic);
        }

}
