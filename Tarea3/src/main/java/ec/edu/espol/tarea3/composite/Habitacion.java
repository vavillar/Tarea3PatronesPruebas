
package ec.edu.espol.tarea3.composite;

import ec.edu.espol.tarea3.estadosTipos.*;

public class Habitacion implements Componente {
    private String numero;
    private double precio;
    private EstadoHabitacion estado;

    public Habitacion(String numero, double precio) {
        this.numero = numero;
        this.precio = precio;
        this.estado = EstadoHabitacion.DISPONIBLE;
    }

    @Override
    public double precio() { return precio; }

    @Override
    public boolean estaDisponible() { 
        return estado == EstadoHabitacion.DISPONIBLE; 
    }

    public void setEstado(EstadoHabitacion ocupada) {
        this.estado = ocupada;
    }
}
