package app.controllers;

import app.models.operaciones.Operacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import app.servicios.OperacionService;

import java.util.List;

@RestController
@RequestMapping("/operaciones")
public class OperacionController {

    @Autowired
    private final OperacionService operacionService;

    public OperacionController(OperacionService operacionService) {
        this.operacionService = operacionService;
    }

    @PostMapping
    public Operacion crear(@RequestBody Operacion operacion) {

        return operacionService.crear(operacion);
    }

    @GetMapping
    public List<Operacion> listarTodas() {

        return operacionService.listar();
    }

    @GetMapping("/pendientes")
    public List<Operacion> listarPendientes() {

        return operacionService.obtenerPendientes();
    }

    @PostMapping("/ejecutar")
    public void ejecutarPendientes() {

        operacionService.ejecutarPendientes();
    }
}
