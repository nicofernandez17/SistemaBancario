package app.controllers;

import app.domain.Cuenta;
import app.domain.Usuario;
import app.enums.TipoCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import app.servicios.CuentaService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/cuentas")
public class CuentaController {


    private CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping
    public String mostrarCuentas(Model model) {
        Cuenta cuenta1 = new Cuenta();
        cuenta1.setNumero(1001L);
        cuenta1.setTipo(TipoCuenta.CREDITO);
        cuenta1.setSaldo(new BigDecimal("15250.75"));
        cuenta1.setFechaCreacion(LocalDate.now());

        Cuenta cuenta2 = new Cuenta();
        cuenta2.setNumero(1002L);
        cuenta2.setTipo(TipoCuenta.DEBITO);
        cuenta2.setSaldo(new BigDecimal("8900.00"));
        cuenta2.setFechaCreacion(LocalDate.now());

        model.addAttribute("cuentas", List.of(cuenta1, cuenta2));
        return "cuentas"; // se refiere a cuentas.html en templates
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
