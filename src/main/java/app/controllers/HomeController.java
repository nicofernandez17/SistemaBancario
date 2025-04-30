package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Página principal
    @GetMapping("/")
    public String home() {
        return "home";  // La vista para la página de inicio
    }

    
}
