package app.operaciones;

import app.domain.Cuenta;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("Trans")
public class Transferir extends Operacion {

    @ManyToOne
    @JoinColumn(name = "target_account_numero")
    private Cuenta cuentaDestino;

    public Transferir(Cuenta targetAccount) {
        this.cuentaDestino = targetAccount;
    }

    public Transferir() {

    }

    public void ejecutar() {
        cuentaDestino.depositar(valor);
        cuenta.retirar(valor);
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

}
