package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Bienvenido al Home");
        model.addAttribute("activeMenu", "home");
        model.addAttribute("content", "homeContent"); // Aquí le asignas el contenido a insertar
        return "home";
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {
        model.addAttribute("title", "Perfil");
        model.addAttribute("activeMenu", "perfil");
        model.addAttribute("content", "perfilContent"); // Contenido específico
        return "home";
    }
}