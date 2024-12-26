package ForoHub.Blog.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ForoHub.Blog.Config.RegisterFilterID.IUserOwnedEntity;
import ForoHub.Blog.Config.Security.UserPrincipal;

@Service
public abstract class SecuredEntityService<T extends IUserOwnedEntity> {

    @Autowired
    protected JpaRepository<T, Long> repository;

    protected T findByIdSecured(Long id) {
        Long currentUserId = getCurrentUserId();
        return findByIdAndUserId(id, currentUserId)
                .orElseThrow(() -> new RuntimeException("Entity not found or access denied"));
    }

    protected List<T> findAllSecured() {
        Long currentUserId = getCurrentUserId();
        return findAllByUserId(currentUserId);
    }

    protected T saveSecured(T entity) {
        entity.setUserId(getCurrentUserId());
        return repository.save(entity);
    }

    protected Long getCurrentUserId() {  // Cambié a protected para que las clases hijas puedan acceder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserPrincipal) {
            return ((UserPrincipal) authentication.getPrincipal()).getId();
        }
        throw new RuntimeException("User not authenticated");
    }

    protected abstract Optional<T> findByIdAndUserId(Long id, Long userId);
    protected abstract List<T> findAllByUserId(Long userId);
}