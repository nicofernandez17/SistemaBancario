package app.repositorios;

import app.models.enums.EstadoOperacion;
import app.models.operaciones.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoOperaciones extends JpaRepository<Operacion, Long> {

    List<Operacion> findByEstado(EstadoOperacion estado);

}
