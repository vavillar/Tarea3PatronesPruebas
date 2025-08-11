package ec.edu.espol.tarea3;

import java.util.ArrayList;
import java.util.List;
import ec.edu.espol.tarea3.estadosTipos.*;


public class Paseo implements Componente {
    private String nombre;
    private double precio;
    private EstadoPaseo estado;

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
}