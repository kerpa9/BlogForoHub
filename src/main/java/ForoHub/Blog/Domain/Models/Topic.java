package ForoHub.Blog.Domain.Models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "topic")
@Entity(name = "Topic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;
    private LocalDateTime create_date;
    private Boolean active;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "course_id")
    // private Course course;

    // @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Response> responses = new ArrayList<>();

    // @Transient
    // private List<Course> course;
    // private String response;

    // public void addResponse(Response response) {
    //     responses.add(response);
    //     response.setTopic(this);
    // }
    
    // public void removeResponse(Response response) {
    //     responses.remove(response);
    //     response.setTopic(null);
    // }



    public void setStausInactiveTopic() {
        this.active = false;
    }

}
