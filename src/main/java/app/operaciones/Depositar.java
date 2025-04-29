package app.operaciones;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Deposito")
public class Depositar extends Operacion {


    @Override
    public void ejecutar() {
        this.cuenta.depositar(valor);
    }


}
