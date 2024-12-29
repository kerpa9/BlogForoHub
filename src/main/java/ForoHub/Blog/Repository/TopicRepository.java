package ForoHub.Blog.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ForoHub.Blog.Domain.Models.Topic;
import ForoHub.Blog.Repository.BaseRepository.BaseRepository;

public interface TopicRepository extends BaseRepository<Topic> {

    @Override
    Optional<Topic> findByIdAndIdLogin(Long id, Long id_login);

    @Override
    List<Topic> findAllByIdLogin(Long id_login);


    @Query("SELECT COALESCE(MAX(t.id_topic), 0) FROM Topic t WHERE t.id_login = :id_login")
        Long generatedInsertSequential(@Param("id_login") Long id_login);

    @Query("SELECT t.title, t.message FROM Topic t WHERE t.id = :id")
    Object[] findTitleAndMessageById(@Param("id") Long id);

    @Query("""
                select t from Topic t where t.active = true and t.id_login=:id
            """)
    Page<Topic> findAllActive(Long id, Pageable pageable);

    @Query("""
            select t from Topic t
            where
            t.active=TRUE
            and
            t.id= :id
            """)
    Topic findByIdActive(@Param("id") Long id);

    @Query("""
            select t from Topic t where  t.active=TRUE
            and t.id_login = :id_login and t.id_topic = :id_topic""")
    Topic findByIdUserLogin(
            @Param("id_topic") Long id_topic,
            @Param("id_login") Long id_login);

}
