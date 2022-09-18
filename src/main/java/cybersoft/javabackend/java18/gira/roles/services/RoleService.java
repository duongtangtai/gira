package cybersoft.javabackend.java18.gira.roles.services;

import cybersoft.javabackend.java18.gira.roles.models.Role;
import cybersoft.javabackend.java18.gira.roles.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role save(Role role);
    Role update(Role role, String code);
    void delete(String code);
}
@Service
@AllArgsConstructor
@Transactional
class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public Role update(Role role, String code) {
        Role curRole = repository.findByCode(code);
        curRole.setName(role.getName());
        curRole.setDescription(role.getDescription());
        return curRole;
    }

    @Override
    public void delete(String code) {
        repository.deleteByCode(code);
    }
}