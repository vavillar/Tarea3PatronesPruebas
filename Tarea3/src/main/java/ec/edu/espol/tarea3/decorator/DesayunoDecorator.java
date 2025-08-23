package ec.edu.espol.tarea3.decorator;

import ec.edu.espol.tarea3.composite.Componente;

public class DesayunoDecorator extends ExtraDecorator {
    private double precioExtra;
    public DesayunoDecorator(Componente componente, double precioExtra){
        super(componente);
        this.precioExtra=precioExtra;
    }
    @Override
    public double precio(){
        return super.precio() + precioExtra;}
    
}
