package app.repositorios;

import app.domain.Cuenta;
import app.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoCuentas extends JpaRepository<Cuenta, Long> {

    public Cuenta findCuentaByNumero(Long numero);
    public List<Cuenta> findCuentaByUsuario(Usuario usuario);


}
