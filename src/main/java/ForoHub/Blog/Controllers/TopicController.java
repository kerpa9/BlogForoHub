package ForoHub.Blog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
