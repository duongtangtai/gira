package cybersoft.javabackend.java18.gira.roles.repositories;

import cybersoft.javabackend.java18.gira.roles.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByCode(String code);
    void deleteByCode(String code);
    Optional<Role> findByName(String name);
    Optional<Role> findByNameAndCode(String name, String code);
}
