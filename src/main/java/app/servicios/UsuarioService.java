package app.servicios;

import app.models.domain.Usuario;
import app.repositorios.RepoUsuarios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private RepoUsuarios repoUsuarios;

    public Usuario crear(Usuario usuario) { return repoUsuarios.save(usuario);}
    public Usuario obtener(String dni) { return repoUsuarios.findByDni(dni); }
    public List<Usuario> listar() { return repoUsuarios.findAll(); }
}
