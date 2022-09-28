package cybersoft.javabackend.java18.gira.roles.models;

import cybersoft.javabackend.java18.gira.commons.models.BaseEntity;
import cybersoft.javabackend.java18.gira.roles.validation.annotation.UniqueRoleName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = RoleEntity.Role.TABLE_NAME)
public class Role extends BaseEntity {

    @Column(name = RoleEntity.Role.NAME, unique = true)
    @Size(min = 5, max = 20, message = "Role name's characters must be between {min} and {max}")
    private String name;

    @Column(name = RoleEntity.Role.CODE)
    @Size(min = 2, max = 10, message = "Role code's characters must be between {min} and {max}")
    private String code;

    @Column(name = RoleEntity.Role.DESCRIPTION)
    @NotBlank(message = "Role description can't be blank")
    private String description;

    @Override
    public boolean equals(Object obj) {
        Role roleObj = (Role) obj;
        return super.equals(obj)
                && roleObj.name.equals(name)
                && roleObj.code.equals(code);
    }
}
