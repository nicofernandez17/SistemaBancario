package app.servicios;

import app.enums.EstadoOperacion;
import app.operaciones.Operacion;
import app.repositorios.RepoOperaciones;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperacionService {

    private RepoOperaciones repoOperaciones;

    public Operacion crear(Operacion o) { return repoOperaciones.save(o); }
    public List<Operacion> listar() { return repoOperaciones.findAll(); }
    public List<Operacion> obtenerPendientes() { return repoOperaciones.findByEstado(EstadoOperacion.PENDIENTE); }
    public void ejecutarPendientes() {  }

}
