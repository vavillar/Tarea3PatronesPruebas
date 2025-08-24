package ec.edu.espol.tarea3.builder;

public class Paquete {
    private boolean disponible;
    private int cupos;

    public boolean reservarPara(Reserva r) {
        if (!estaDisponible()) return false;
        cupos--;
        return true;
    }

    public boolean estaDisponible() {
        return disponible && cupos > 0;
    }
}
