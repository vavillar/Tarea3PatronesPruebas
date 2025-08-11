package ec.edu.espol.tarea3;

public class SpaDecorator extends ExtraDecorator{
    private double precioExtra;
    public SpaDecorator(Componente componente, double precioExtra){
        super(componente);
        this.precioExtra = precioExtra;
    }
    @Override
    public double precio(){
        return super.precio()+ precioExtra;}
}
