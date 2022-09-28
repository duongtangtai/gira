package cybersoft.javabackend.java18.gira.roles.validation.annotation;

import cybersoft.javabackend.java18.gira.roles.validation.validator.UniqueRoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueRoleValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UniqueRole {
    String message() default "Role is existed";

    Class<?> [] groups() default {};

    Class<? extends Payload> [] payload() default {};
}
