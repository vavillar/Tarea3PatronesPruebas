package ec.edu.espol.tarea3.decorator;

import ec.edu.espol.tarea3.composite.Componente;

public abstract class ExtraDecorator implements Componente{
    protected Componente componente;
    public ExtraDecorator (Componente componente){
        this.componente=componente;
    }

    @Override
    public double precio(){
        return componente.precio();
    }
    @Override
    public boolean estaDisponible(){
        return componente.estaDisponible();
    }
    
}