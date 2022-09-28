package cybersoft.javabackend.java18.gira.roles.validation.validator;

import cybersoft.javabackend.java18.gira.roles.dto.RoleDTO;
import cybersoft.javabackend.java18.gira.roles.models.Role;
import cybersoft.javabackend.java18.gira.roles.repositories.RoleRepository;
import cybersoft.javabackend.java18.gira.roles.validation.annotation.UniqueRole;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueRoleValidator
        implements ConstraintValidator<UniqueRole, RoleDTO> {
    private String message;
    private RoleRepository repository;
    public UniqueRoleValidator(RoleRepository repository) {
        this.repository = repository;
    }
    @Override
    public void initialize(UniqueRole constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(RoleDTO roleDTO, ConstraintValidatorContext context) {
        Optional<Role> role = repository.findByNameAndCode(roleDTO.getName(), roleDTO.getCode());
        if (role.isEmpty()) {
            return true;
        }
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
