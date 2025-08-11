package ec.edu.espol.tarea3;

import ec.edu.espol.tarea3.estadosTipos.EstadoReserva;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MovilNotificacionTest {

    @Test
    @DisplayName("Debe imprimir el mensaje correcto al actualizar la reserva")
    void testActualizarImprimeMensajeCorrecto() {
        // Redirigir la salida de System.out a un buffer
        ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;
        System.setOut(new PrintStream(salidaCapturada));

        try {
            // Crear una reserva de prueba
            Paquete paquete = new Paquete() {
                @Override
                public boolean estaDisponible() {
                    return true;
                }

                @Override
                public double precio() {
                    return 100.0;
                }
            };

            Reserva reserva = new Reserva(paquete);
            reserva.setId("R001");
            reserva.setEstado(EstadoReserva.CONFIRMADA);

            // Probar la notificación
            MovilNotificacion notificacion = new MovilNotificacion();
            notificacion.actualizar(reserva);

            // Verificar que la salida contiene el mensaje esperado
            String salida = salidaCapturada.toString().trim();
            assertEquals("SMS: Reserva R001 - Estado: CONFIRMADA", salida);

        } finally {
            // Restaurar salida original
            System.setOut(salidaOriginal);
        }
    }
}
