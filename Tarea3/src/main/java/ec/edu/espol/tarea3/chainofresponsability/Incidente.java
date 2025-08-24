package ec.edu.espol.tarea3.chainofresponsability;

import ec.edu.espol.tarea3.estadosTipos.EstadoIncidente;

public class Incidente {
    
    private String id;
    private String descripcion;
    private EstadoIncidente estado;

    public Incidente(String id, String descripcion) {
        if (id == null) {
            throw new NullPointerException("El ID no puede ser null");
        }
        if (descripcion == null) {
            throw new NullPointerException("La descripción no puede ser null");
        }
        this.id = id;
        this.descripcion = descripcion;
        this.estado = EstadoIncidente.ABIERTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null) {
            throw new NullPointerException("El ID no puede ser null");
        }
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null) {
            throw new NullPointerException("La descripción no puede ser null");
        }
        this.descripcion = descripcion;
    }

    public EstadoIncidente getEstado() {
        return estado;
    }

    public void cerrar() { 
        this.estado = EstadoIncidente.CERRADO; 
    }
}


