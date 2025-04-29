package app.servicios;

import app.domain.Cuenta;
import app.domain.Usuario;
import app.repositorios.RepoCuentas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {

    private RepoCuentas repoCuentas;

    public Cuenta crear(Cuenta c) { return repoCuentas.save(c); }
    public Cuenta obtener(Long numero) { return repoCuentas.findCuentaByNumero(numero);}
    public List<Cuenta> obtenerPorUsuario(Usuario usuario) { return repoCuentas.findCuentaByUsuario(usuario);}

}
