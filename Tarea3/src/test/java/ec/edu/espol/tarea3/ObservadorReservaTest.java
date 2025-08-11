package ec.edu.espol.tarea3;

import ec.edu.espol.tarea3.estadosTipos.EstadoReserva;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObservadorReservaTest {

    static class ObservadorPrueba implements ObservadorReserva {
        boolean actualizado = false;
        Reserva reservaRecibida = null;

        @Override
        public void actualizar(Reserva reserva) {
            actualizado = true;
            reservaRecibida = reserva;
        }
    }

    @Test
    @DisplayName("Debe llamar al método actualizar con la reserva correcta")
    void testActualizarRecibeReserva() {
        // Crear reserva de prueba
        Paquete paquete = new Paquete() {
            @Override
            public boolean estaDisponible() {
                return true;
            }

            @Override
            public double precio() {
                return 50.0;
            }
        };

        Reserva reserva = new Reserva(paquete);
        reserva.setId("R100");
        reserva.setEstado(EstadoReserva.CONFIRMADA);

        // Crear observador y ejecutar actualización
        ObservadorPrueba observador = new ObservadorPrueba();
        observador.actualizar(reserva);

        // Verificaciones
        assertTrue(observador.actualizado, "El método actualizar debería haber sido llamado");
        assertEquals(reserva, observador.reservaRecibida, "La reserva recibida no coincide");
    }
}