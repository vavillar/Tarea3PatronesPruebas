
package ec.edu.espol.tarea3.composite;

import ec.edu.espol.tarea3.estadosTipos.EstadoHabitacion;

public class Habitacion implements Componente {
    private final String numero;
    private double precio;
    private EstadoHabitacion estado = EstadoHabitacion.DISPONIBLE;

    public Habitacion(String numero, double precio) {
        if (numero == null || numero.isBlank()) throw new IllegalArgumentException("número inválido");
        if (precio < 0) throw new IllegalArgumentException("precio inválido");
        this.numero = numero;
        this.precio = precio;
    }

    @Override
    public double precio() { return precio; }

    @Override
    public boolean estaDisponible() { 
        return estado == EstadoHabitacion.DISPONIBLE; 
    }

    public boolean reservar() {
        if (!estaDisponible()) return false;
        estado = EstadoHabitacion.OCUPADA;
        return true;
    }

    public boolean ocupar() {
        if (estado != EstadoHabitacion.OCUPADA) return false;
        estado = EstadoHabitacion.OCUPADA;
        return true;
    }

    public boolean liberar() {
        if (estado != EstadoHabitacion.OCUPADA && estado != EstadoHabitacion.OCUPADA) return false;
        estado = EstadoHabitacion.DISPONIBLE;
        return true;
    }

    public String getNumero() {
        return numero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }
    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }
}
