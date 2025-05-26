package app.servicios;

import app.models.domain.Cuenta;
import app.models.domain.Usuario;
import app.repositorios.ICuentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    private ICuentasRepository repoCuentas;


    public Long crear(Cuenta c) { return repoCuentas.save(c).getNumero(); }
    public Optional<Cuenta> obtenerPorNumero(Long numero) { return repoCuentas.findById(numero);}
    public List<Cuenta> obtenerPorUsuario(Usuario usuario) { return repoCuentas.findByUsuario(usuario);}
    public List<Cuenta> obtenerCuentas(){return repoCuentas.findAll();};
    public List<Cuenta> obtenerPorUsuarioId(Long usuarioId) {
        return repoCuentas.findByUsuarioId(usuarioId);
    }
}
