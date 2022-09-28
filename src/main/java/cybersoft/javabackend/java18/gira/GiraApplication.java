package cybersoft.javabackend.java18.gira;

import cybersoft.javabackend.java18.gira.roles.models.Role;
import cybersoft.javabackend.java18.gira.roles.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class GiraApplication implements CommandLineRunner{

    private final RoleService service;

    @Autowired
    public GiraApplication(RoleService service) {
        this.service = service;
    }


    public static void main(String[] args) {
        SpringApplication.run(GiraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Role role1 = Role.builder()
                .id(UUID.randomUUID())
                .version(1)
                .createdAt(LocalDateTime.now())
                .lastModifiedAt(LocalDateTime.now())
                .name("MANAGER")
                .code("MA")
                .description("This is the manager's code")
                .build();
        Role role2 = Role.builder()
                .id(UUID.randomUUID())
                .version(1)
                .createdAt(LocalDateTime.now())
                .lastModifiedAt(LocalDateTime.now())
                .name("LEADER")
                .code("LD")
                .description("This is the leader's code")
                .build();
        Role role3 = Role.builder()
                .id(UUID.randomUUID())
                .version(1)
                .createdAt(LocalDateTime.now())
                .lastModifiedAt(LocalDateTime.now())
                .name("STAFF")
                .code("ST")
                .description("This is the staff's code")
                .build();
        service.save(role1);
        service.save(role2);
        service.save(role3);
    }
}
