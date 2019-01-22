package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class GreetingController {

    private final GreetingService greetingService;

    @Value("${background-color:white}")
    private String backgroundColor;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", greetingService.greet());
        model.addAttribute("backgroundColor", backgroundColor);
        model.addAttribute("userDir", System.getProperty("user.dir"));
        model.addAttribute("password", Optional.ofNullable(System.getenv("PASSWORD")).orElse("unknown"));
        return "greeting";
    }

}
