package ForoHub.Blog.Domain.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ForoHub.Blog.Config.RegisterFilterID.IUserOwnedEntity;
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

@Table(name = "course")
@Entity(name = "Course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Course implements IUserOwnedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @JsonIgnore
    private Long id_login;
    private Long id_course;
    
    private String name;
    private String category;
    private Boolean active;

    public void setStausInactiveCourse() {
        this.active = false;
    }

    @Override
    public Long getUserId() {
        return id_login;
    }

    @Override
    public void setUserId(Long userId) {
        this.id_login = userId;
    }

}
