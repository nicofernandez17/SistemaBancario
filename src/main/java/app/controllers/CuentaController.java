package app.controllers;

import app.models.domain.Cuenta;
import app.models.domain.Usuario;
import app.models.enums.TipoCuenta;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import app.servicios.CuentaService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping
    public List<Cuenta> listarCuentas() {
        // En lugar de crear cuentas estáticas, llama a tu servicio que las obtenga de BD
        return cuentaService.obtenerCuentas();
    }

    @PostMapping
    public Long crear(@RequestBody Cuenta cuenta) {
        return cuentaService.crear(cuenta);
    }

    @GetMapping("/{numero}")
    public ResponseEntity<Cuenta> obtener(@PathVariable Long numero) {
        return cuentaService.obtenerPorNumero(numero)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Cuenta> cuentasDeUsuario(@PathVariable Long usuarioId) {
        return cuentaService.obtenerPorUsuarioId(usuarioId);
    }
}
