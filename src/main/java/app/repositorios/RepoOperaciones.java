package app.repositorios;

import app.models.enums.EstadoOperacion;
import app.models.operaciones.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoOperaciones extends JpaRepository<Operacion, Long> {

    List<Operacion> findByEstado(EstadoOperacion estado);

}
