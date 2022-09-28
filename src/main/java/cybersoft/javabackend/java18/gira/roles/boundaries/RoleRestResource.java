package cybersoft.javabackend.java18.gira.roles.boundaries;

import cybersoft.javabackend.java18.gira.commons.utils.ResponseUtils;
import cybersoft.javabackend.java18.gira.roles.dto.RoleDTO;
import cybersoft.javabackend.java18.gira.roles.models.Role;
import cybersoft.javabackend.java18.gira.roles.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RoleRestResource {
    private final RoleService service;

    @GetMapping
    public Object findAll() {
        return ResponseUtils.get(service.findAllDto(RoleDTO.class), HttpStatus.OK);
    }

    @GetMapping("/paging")
    public Object findAllWithPaging(@RequestParam("size") int size, @RequestParam("index") int index) {
        return ResponseUtils.get(service.findAllDto(RoleDTO.class, PageRequest.of(index, size)),HttpStatus.OK);
    }

    @PostMapping
    public Object save(@Valid @RequestBody RoleDTO roleDTO) {
        return ResponseUtils.get(service.save(roleDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public Object update(@RequestBody Role role) {
        return new ResponseEntity<>(service.update(role, role.getCode()), HttpStatus.OK);
    }

    @DeleteMapping
    public Object delete(@RequestBody Role role) {
        service.deleteByCode(role.getCode());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
