package app.repositorios;

import app.models.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUsuarios extends JpaRepository<Usuario, Long> {

    public Usuario findByNombre(String nombre);
    public Usuario findByEmail(String email);
    public Usuario findByDni(String dni);
    public Usuario save(Usuario usuario);
    public void delete(Usuario usuario);
}
