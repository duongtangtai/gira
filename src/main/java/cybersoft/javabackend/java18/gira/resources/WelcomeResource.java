package cybersoft.javabackend.java18.gira.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class WelcomeResource {
    @GetMapping("/welcome")
    public String welcome(HttpServletRequest request) {
        return """
                Welcome %s to Gira Application
                """.formatted(request.getRemoteAddr());
    }
}
