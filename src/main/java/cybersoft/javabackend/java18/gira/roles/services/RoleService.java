package cybersoft.javabackend.java18.gira.roles.services;

import cybersoft.javabackend.java18.gira.commons.services.GenericService;
import cybersoft.javabackend.java18.gira.commons.utils.GiraMapper;
import cybersoft.javabackend.java18.gira.roles.dto.RoleDTO;
import cybersoft.javabackend.java18.gira.roles.models.Role;
import cybersoft.javabackend.java18.gira.roles.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface RoleService extends GenericService<Role, RoleDTO, UUID> {
    Role update(Role role, String code);
    void deleteByCode(String code);
    RoleDTO save(RoleDTO roleDTO);
}
@Service
@AllArgsConstructor
@Transactional
class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    private final GiraMapper mapper;

    @Override
    public JpaRepository<Role, UUID> getRepository() {
        return this.repository;
    }

    @Override
    public ModelMapper getMapper() {
        return this.mapper;
    }

    @Override
    public Role update(Role role, String code) {
        Role curRole = repository.findByCode(code);
        curRole.setName(role.getName());
        curRole.setDescription(role.getDescription());
        return curRole;
    }

    @Override
    public void deleteByCode(String code) {
        repository.deleteByCode(code);
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        Role model = mapper.map(roleDTO, Role.class);
        Role savedModel = repository.save(model);
        return mapper.map(savedModel, RoleDTO.class);
    }

}
