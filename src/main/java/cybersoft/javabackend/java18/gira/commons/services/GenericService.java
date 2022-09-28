package cybersoft.javabackend.java18.gira.commons.services;

import cybersoft.javabackend.java18.gira.commons.models.BaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface GenericService <T extends BaseEntity, D, I> {
    JpaRepository<T, I> getRepository();
    ModelMapper getMapper();

    default Optional<T> findById(I id) {
        return getRepository().findById(id);
    }
    default List<T> findAll() {
        return getRepository().findAll();
    }

    default List<D> findAllDto(Class<D> clazz, Pageable page) {
        return getRepository().findAll(page).stream()
                .map(model -> getMapper().map(model, clazz))
                .toList();
    }

    default List<D> findAllDto(Class<D> clazz) {
        return getRepository().findAll().stream()
                .map(model -> getMapper().map(model, clazz))
                .toList();
    }

    default T save(T entity) {
        return getRepository().save(entity);
    }

    default T update(T entity) {
        return getRepository().save(entity);
    }

    default void deleteById(I id) {
        getRepository().deleteById(id);
    }
}
