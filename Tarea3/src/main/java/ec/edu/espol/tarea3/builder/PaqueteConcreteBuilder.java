package ec.edu.espol.tarea3.builder;

import ec.edu.espol.tarea3.composite.Componente;
import ec.edu.espol.tarea3.composite.Habitacion;
import ec.edu.espol.tarea3.composite.PaqueteCompuesto;
import ec.edu.espol.tarea3.composite.Paseo;

public class PaqueteConcreteBuilder implements PaqueteBuilder {
    private PaqueteCompuesto paquete = new PaqueteCompuesto();
    

    @Override
    public PaqueteBuilder agregarHabitacion(String numero, double precio) {
        paquete.agregar(new Habitacion(numero, precio));
        return this;
    }

    @Override
    public PaqueteBuilder agregarPaseo(String nombre, double precio) {
        paquete.agregar(new Paseo(nombre, precio));
        return this;
    }

    @Override
    public PaqueteBuilder agregarExtra(Componente extra) {
        paquete.agregar(extra);
        return this;
    }

    @Override
    public Reserva construir() {
        return new Reserva(paquete);
    }
}

