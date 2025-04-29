package app.operaciones;

import app.domain.Cuenta;
import app.enums.EstadoOperacion;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "command_type")
public abstract class Operacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Enumerated(EnumType.STRING)
    protected EstadoOperacion estado;

    @OneToOne(cascade = CascadeType.ALL)
    protected Cuenta cuenta;

    protected BigDecimal valor;

    public abstract void ejecutar();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
