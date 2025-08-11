/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.tarea3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Victor
 */
public class EmailNotificacionTest {
    
    public EmailNotificacionTest() {
    }
    
    // Stub para Reserva
    static class ReservaStub extends Reserva {
        private final String id;
        private final String estado;

        public ReservaStub(String id, String estado) {
            super(null); // No necesitamos el paquete para esta prueba
            this.id = id;
            this.estado = estado;
        }

        @Override
        public String getId() {
            return id;
        }

        public String getEstadoo() {
            return estado;
        }
    }

    @Test
    @DisplayName("Debe imprimir mensaje correcto al actualizar")
    void testActualizarImprimeMensajeCorrecto() {
        EmailNotificacion email = new EmailNotificacion();
        ReservaStub reserva = new ReservaStub("R-123", "CONFIRMADA");

        // Captura la salida estándar
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        email.actualizar(reserva);

        String expected = "Email: Reserva R-123 - Estado: CONFIRMADA" + System.lineSeparator();
        assertEquals(expected, outContent.toString());

        // Restaurar System.out
        System.setOut(System.out);
    }
}
