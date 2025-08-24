package ec.edu.espol.tarea3.builder;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import ec.edu.espol.tarea3.composite.PaqueteCompuesto;
import ec.edu.espol.tarea3.estadosTipos.*;

public class ReservaTest {

    @Test
    @DisplayName("RES-01: Reserva con paquete nulo debe lanzar excepción")
    public void testReservaPaqueteNulo() {
        assertThrows(NullPointerException.class, () -> {
            new Reserva(null);
        });
    }

    @Test
    @DisplayName("RES-02: ID de reserva no debe ser nulo o vacío")
    public void testIdReservaNoNulo() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        Reserva reserva = new Reserva(paquete);
        
        assertNotNull(reserva.getId());
        assertFalse(reserva.getId().isEmpty());
        assertTrue(reserva.getId().startsWith("RES-"));
    }

    @Test
    @DisplayName("RES-03: Estado inicial debe ser PENDIENTE")
    public void testEstadoInicialPendiente() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        Reserva reserva = new Reserva(paquete);
        
        assertEquals(EstadoReserva.PENDIENTE, reserva.getEstado());
    }


    @Test
    @DisplayName("RES-04: Agregar observador nulo debe lanzar excepción")
    public void testObservadorNulo() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        Reserva reserva = new Reserva(paquete);
        
        assertThrows(NullPointerException.class, () -> {
            reserva.agregarObservador(null);
        });
    }


    @Test
    @DisplayName("RES-05: Paquete debe ser el mismo asignado en constructor")
    public void testPaqueteConsistente() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        Reserva reserva = new Reserva(paquete);
        
        assertEquals(paquete, reserva.getPaquete());
    }


}