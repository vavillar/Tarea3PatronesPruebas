package ec.edu.espol.tarea3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ec.edu.espol.tarea3.estadosTipos.EstadoReserva;

class ReservaTest {

    static class ObservadorStub implements ObservadorReserva {
        boolean actualizado = false;
        Reserva reservaRecibida = null;

        @Override
        public void actualizar(Reserva reserva) {
            actualizado = true;
            reservaRecibida = reserva;
        }
    }

    @Test
    @DisplayName("Al crear reserva, el estado debe ser PENDIENTE y el id no debe ser nulo ni vacío")
    void testReservaInicial() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        Reserva reserva = new Reserva(paquete);

        assertEquals(EstadoReserva.PENDIENTE, reserva.getEstado());
        assertNotNull(reserva.getId());
        assertFalse(reserva.getId().isEmpty());
        assertEquals(paquete, reserva.getPaquete());
    }

    @Test
    @DisplayName("Cambiar estado debe actualizar y notificar observadores")
    void testSetEstadoYNotificacion() {
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        Reserva reserva = new Reserva(paquete);

        ObservadorStub observador = new ObservadorStub();
        reserva.agregarObservador(observador);

        reserva.setEstado(EstadoReserva.CONFIRMADA);

        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
        assertTrue(observador.actualizado);
        assertEquals(reserva, observador.reservaRecibida);
    }
}
