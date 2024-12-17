package ForoHub.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ForoHub.Blog.Domain.Models.Profile;

public interface ProfileRepository extends JpaRepository <Profile, Long> {
    
}
