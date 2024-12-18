package ForoHub.Blog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ForoHub.Blog.Domain.DTOs.TopicDTO;
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
        Topic topic = new Topic();
        topic.setTitle(topicDTO.title());
        topic.setMessage(topicDTO.message());
        topic.setCreate_date(topicDTO.create_date());
        return topicRepository.save(topic);
    }

}
