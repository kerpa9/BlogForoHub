package ForoHub.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ForoHub.Blog.Domain.Models.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query("SELECT t.title, t.message FROM Topic t WHERE t.id = :id")
    Object[] findTitleAndMessageById(@Param("id") Long id);
}
