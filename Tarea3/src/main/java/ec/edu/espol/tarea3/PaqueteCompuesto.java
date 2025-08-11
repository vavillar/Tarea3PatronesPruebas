
package ec.edu.espol.tarea3;
import java.util.List;
import java.util.ArrayList;

public class PaqueteCompuesto implements Componente {
    private List<Componente> componentes = new ArrayList<>();

    public void agregar(Componente c) { componentes.add(c); }

    @Override
    public double precio() {
        return componentes.stream().mapToDouble(Componente::precio).sum();
    }

    @Override
    public boolean estaDisponible() {
        return componentes.stream().allMatch(Componente::estaDisponible);
    }
}