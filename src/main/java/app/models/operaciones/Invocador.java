package app.models.operaciones;

import java.util.List;

public class Invocador {

    private List<Operacion> operaciones;

    private static final Invocador instance = new Invocador();

    private Invocador() {}

    public static Invocador getInstance() {
        return instance;
    }

    public void agregarOperacion(Operacion operacion) {operaciones.add(operacion);}

    public void eliminarOperacion(Operacion operacion) {operaciones.remove(operacion);}


}
