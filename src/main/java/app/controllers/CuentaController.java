package app.controllers;

import app.domain.Cuenta;
import app.domain.Usuario;
import org.springframework.web.bind.annotation.*;
import app.servicios.CuentaService;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @PostMapping
    public Cuenta crear(@RequestBody Cuenta cuenta) {
        return cuentaService.crear(cuenta);
    }

    @GetMapping("/{id}")
    public Cuenta obtener(@PathVariable Long numero) {
        return cuentaService.obtener(numero);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Cuenta> cuentasDeUsuario(@PathVariable Usuario usuario) {
        return cuentaService.obtenerPorUsuario(usuario);
    }
}
