package cybersoft.javabackend.java18.gira.roles.dto;

import cybersoft.javabackend.java18.gira.roles.validation.annotation.UniqueRole;
import cybersoft.javabackend.java18.gira.roles.validation.annotation.UniqueRoleName;
import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@UniqueRole(message = "{role.existed}")
public class RoleDTO {
    private UUID id;

    @Size(min = 5, max = 20, message = "{role.name.size}")
    //@UniqueRoleName(message = "{role.name.existed}")
    private String name;

    @Size(min = 2, max = 10, message = "{role.code.size}}")
    private String code;

    @NotBlank(message = "{role.description.blank}")
    private String description;
}
