package ForoHub.Blog.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ForoHub.Blog.Domain.Models.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query("SELECT t.title, t.message FROM Topic t WHERE t.id = :id")
    Object[] findTitleAndMessageById(@Param("id") Long id);

        @Query("""
        select t from Topic t where t.active = true
    """)
    Page<Topic> findAllActive(Pageable pageable);

        @Query("""
                select t from Topic t
                where
                t.active=TRUE
                and
                t.id= :id
                """)
    Topic findByIdActive(@Param("id")  Long id);
}
