package app.repositorios;

import app.models.domain.Cuenta;
import app.models.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICuentasRepository extends JpaRepository<Cuenta, Long> {

    public List<Cuenta> findByUsuario(Usuario usuario);
    public List<Cuenta> findByUsuarioId(Long id);
}
