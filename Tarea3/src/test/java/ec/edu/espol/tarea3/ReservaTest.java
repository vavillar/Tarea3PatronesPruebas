package ec.edu.espol.tarea3;

import ec.edu.espol.tarea3.estadosTipos.EstadoReserva;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReservaTest {
    
    @Test
    @DisplayName("Cambio de estado debe notificar a los observadores")
    void testNotificacionObservadores() {
        Reserva reserva = new Reserva(new PaqueteCompuesto());
        TestObservador obs = new TestObservador();
        reserva.agregarObservador(obs);
        
        reserva.setEstado(EstadoReserva.CONFIRMADA);
        assertTrue(obs.fueNotificado());
    }
    
    private static class TestObservador implements ObservadorReserva {
        private boolean notificado = false;
        
        @Override
        public void actualizar(Reserva reserva) {
            this.notificado = true;
        }
        
        public boolean fueNotificado() {
            return notificado;
        }
    }
}