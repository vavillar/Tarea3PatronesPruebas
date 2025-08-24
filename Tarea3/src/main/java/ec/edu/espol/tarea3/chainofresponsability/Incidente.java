package ec.edu.espol.tarea3.chainofresponsability;

import ec.edu.espol.tarea3.estadosTipos.EstadoIncidente;

public class Incidente {
    
    private String id;
    private DescripcionIncidente descripcion;
    private EstadoIncidente estado = EstadoIncidente.ABIERTO;

    public Incidente(String id, DescripcionIncidente descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public DescripcionIncidente getDescripcion() {
        return descripcion;
    }
    public void cerrar() { 
        this.estado = EstadoIncidente.CERRADO; 
    }

}

