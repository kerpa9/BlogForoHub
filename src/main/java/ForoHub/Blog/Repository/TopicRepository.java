package ForoHub.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ForoHub.Blog.Domain.Models.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
