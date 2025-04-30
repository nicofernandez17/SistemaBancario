package app.domain;

import app.enums.TipoCuenta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private BigDecimal saldo;
    private LocalDate fechaCreacion;

    @Enumerated(EnumType.STRING)
    private TipoCuenta tipo;


    public void depositar(BigDecimal valor) {
        saldo = saldo.add(valor);
    }

    public void retirar(BigDecimal valor) {
        saldo = saldo.subtract(valor);
    }


    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
}
