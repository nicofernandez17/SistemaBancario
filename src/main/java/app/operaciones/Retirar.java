package app.operaciones;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Retiro")
public class Retirar extends Operacion {

    @Override
    public void ejecutar() {
        cuenta.retirar(valor);
    }
}
