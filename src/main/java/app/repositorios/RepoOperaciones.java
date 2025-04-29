package app.repositorios;

import app.enums.EstadoOperacion;
import app.operaciones.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoOperaciones extends JpaRepository<Operacion, Long> {

    List<Operacion> findByEstado(EstadoOperacion estado);

}
