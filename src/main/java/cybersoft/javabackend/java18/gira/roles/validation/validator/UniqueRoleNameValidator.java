package cybersoft.javabackend.java18.gira.roles.validation.validator;

import cybersoft.javabackend.java18.gira.roles.models.Role;
import cybersoft.javabackend.java18.gira.roles.repositories.RoleRepository;
import cybersoft.javabackend.java18.gira.roles.validation.annotation.UniqueRoleName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueRoleNameValidator
        implements ConstraintValidator<UniqueRoleName, String> {
    private String message;
    private RoleRepository repository;

    public UniqueRoleNameValidator(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(UniqueRoleName constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        Optional<Role> role = repository.findByName(name);
        if (role.isEmpty()) {
            return true;
        }
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
