package ec.edu.espol.tarea3.composite;

import ec.edu.espol.tarea3.estadosTipos.EstadoPaseo;


public class Paseo implements Componente {
    private String nombre;
    private double precio;
    private EstadoPaseo estado;

    public EstadoPaseo getEstado() {
        return estado;
    }

    public void setEstado(EstadoPaseo estado) {
        this.estado = estado;
    }

    
        public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Paseo(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.estado = EstadoPaseo.DISPONIBLE;
    }

    @Override
    public double precio() { return precio; }

    @Override
    public boolean estaDisponible() { 
        return estado == EstadoPaseo.DISPONIBLE; 
    }

    public Object getNombre() {
        return this.nombre;
    }
}