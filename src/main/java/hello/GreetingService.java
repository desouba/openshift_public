package hello;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingService {

    public String greet() {
        return Optional
                .ofNullable(System.getenv("GREETING_DEFAULT"))
                .orElse("World!");
    }

}
