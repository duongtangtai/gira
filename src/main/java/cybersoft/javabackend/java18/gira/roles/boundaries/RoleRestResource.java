package cybersoft.javabackend.java18.gira.roles.boundaries;

import cybersoft.javabackend.java18.gira.roles.models.Role;
import cybersoft.javabackend.java18.gira.roles.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RoleRestResource {
    private final RoleService service;

    @GetMapping
    public Object findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public Object save(@RequestBody Role role) {
        return new ResponseEntity<>(service.save(role), HttpStatus.CREATED);
    }

    @PutMapping
    public Object update(@RequestBody Role role) {
        return new ResponseEntity<>(service.update(role, role.getCode()), HttpStatus.OK);
    }

    @DeleteMapping
    public Object delete(@RequestBody Role role) {
        service.delete(role.getCode());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
