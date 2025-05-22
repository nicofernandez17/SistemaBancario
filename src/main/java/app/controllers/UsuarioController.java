package app.controllers;

import app.models.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import app.servicios.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {

        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {

        return usuarioService.crear(usuario);
    }

    @GetMapping("/{dni}")
    public Usuario obtener(@PathVariable String dni) {

        return usuarioService.obtener(dni);
    }

    @GetMapping
    public List<Usuario> listar() {

        return usuarioService.listar();
    }
}
