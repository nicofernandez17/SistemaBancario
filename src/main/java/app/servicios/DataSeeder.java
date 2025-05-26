package app.servicios;

import app.models.domain.Cuenta;
import app.models.domain.Usuario;
import app.models.enums.TipoCuenta;
import app.repositorios.ICuentasRepository;
import app.repositorios.RepoUsuarios;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RepoUsuarios usuarioRepository;
    private final ICuentasRepository cuentaRepository;

    public DataSeeder(RepoUsuarios usuarioRepository, ICuentasRepository cuentaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public void run(String... args) {
        // Usuario 1
        Usuario juan = new Usuario();
        juan.setNombre("Juan Pérez");
        juan.setEmail("juan@example.com");
        juan.setDni("12345678A");
        juan.setPassword("1234");

        // Usuario 2
        Usuario maria = new Usuario();
        maria.setNombre("María García");
        maria.setEmail("maria@example.com");
        maria.setDni("87654321B");
        maria.setPassword("abcd");

        usuarioRepository.saveAll(List.of(juan, maria));

        // Cuentas de Juan
        Cuenta cuenta1 = new Cuenta();
        cuenta1.setUsuario(juan);
        cuenta1.setSaldo(new BigDecimal("1500.00"));
        cuenta1.setFechaCreacion(LocalDate.now());
        cuenta1.setTipo(TipoCuenta.CREDITO);

        Cuenta cuenta2 = new Cuenta();
        cuenta2.setUsuario(juan);
        cuenta2.setSaldo(new BigDecimal("800.00"));
        cuenta2.setFechaCreacion(LocalDate.now());
        cuenta2.setTipo(TipoCuenta.DEBITO);

        // Cuenta de María
        Cuenta cuenta3 = new Cuenta();
        cuenta3.setUsuario(maria);
        cuenta3.setSaldo(new BigDecimal("3200.00"));
        cuenta3.setFechaCreacion(LocalDate.now());
        cuenta3.setTipo(TipoCuenta.CREDITO);

        cuentaRepository.saveAll(List.of(cuenta1, cuenta2, cuenta3));
    }
}