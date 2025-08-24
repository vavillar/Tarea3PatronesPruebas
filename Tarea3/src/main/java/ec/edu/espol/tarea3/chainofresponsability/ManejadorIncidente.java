package ec.edu.espol.tarea3.chainofresponsability;

import ec.edu.espol.tarea3.estadosTipos.Resultado;

public abstract class ManejadorIncidente {

    public ManejadorIncidente siguiente;

    public void setSiguiente(ManejadorIncidente siguiente) {
        this.siguiente = siguiente;
    }
    public ManejadorIncidente getSiguiente(){
        return siguiente;
    }

    public abstract Resultado manejar(Incidente incidente);
}
