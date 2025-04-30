package app.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String dni;
    private String password;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cuenta> cuentas;

    public Usuario(String nombre, String email, String password, List<Cuenta> cuentas) {}

    public Usuario() {

    }

    public List<Cuenta> getCuentas() {return cuentas;}

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

}
