package ForoHub.Blog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ForoHub.Blog.Domain.DTOs.PageableDTO;
import ForoHub.Blog.Domain.DTOs.TopicDTO;
import ForoHub.Blog.Domain.Models.Topic;
import ForoHub.Blog.Services.TopicService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/topic")
@SecurityRequirement(name = "bearer-key")

public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody @Valid TopicDTO topicDTO) {

        Topic createTopic = topicService.createTopic(topicDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createTopic);

    }

    @GetMapping
    private ResponseEntity<PageableDTO> listTopics(@PageableDefault(size = 5) Pageable pageable) {

        Page<Topic> topics = topicService.getAllTopics(pageable);

        Page<TopicDTO> topicDTO = topics.map((var topic) -> new TopicDTO(

                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreate_date(),
                topic.getActive(),
                null,
                topic.getName_course(),
                topic.getCourse().getId()));

        return ResponseEntity.ok(PageableDTO.fromPage(topicDTO));
    }

    @GetMapping("/{id}")
    public Topic getById(@PathVariable @Valid Long id) {
        return topicService.getOneTopicByID(id);

    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }

}
