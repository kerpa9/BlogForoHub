package ForoHub.Blog.Services.ServiceBase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ForoHub.Blog.Config.HandleException.HandleException;
import ForoHub.Blog.Config.RegisterFilterID.IUserOwnedEntity;
import ForoHub.Blog.Domain.Models.users.Users;
import ForoHub.Blog.Repository.BaseRepository.BaseRepository;

@Service
public abstract class BaseUserService<T extends IUserOwnedEntity> {

    @Autowired
    protected BaseRepository<T> repository;

    protected Long getCurrentUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = (Users) auth.getPrincipal();
        return user.getId();
    }

    @Transactional(readOnly = true)
    public List<T> findAll() {
        return repository.findAllByIdLogin(getCurrentUserId());
    }

    @Transactional(readOnly = true)
    public Page<T> findAllPaginated(Pageable pageable) {
        return repository.findAllByIdLoginPaginated(getCurrentUserId(), pageable);
    }

    @Transactional(readOnly = true)
    public Optional<T> findById(Long id) {
        return repository.findByIdAndIdLogin(id, getCurrentUserId());
    }

    @Transactional(readOnly = true)
    public T findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new HandleException("Entity not found or unauthorized"));
    }

    @Transactional(readOnly = true)
    public T save(T entity) {
        entity.setUserId(getCurrentUserId());
        return repository.save(entity);
    }

    @Transactional
    public void delete(Long id) {
        T entity = findByIdOrThrow(id);
        repository.delete(entity);
    }

    @Transactional
    public T update(Long id, T updatedEntity) {
        T existingEntity = findByIdOrThrow(id);
        updatedEntity.setId(existingEntity.getId());
        updatedEntity.setUserId(getCurrentUserId());
        return repository.save(updatedEntity);
    }
}