package ec.edu.espol.tarea3;

import ec.edu.espol.tarea3.estadosTipos.EstadoReserva;
import ec.edu.espol.tarea3.estadosTipos.Resultado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
<<<<<<< Updated upstream
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
    
    @Test
    @DisplayName("Crear reserva con paquete disponible debe confirmar")
    void testCrearReservaDisponible() {
        Cliente cliente = new Cliente(new AgenteSoporte());
        PaqueteBuilder builder = new PaqueteConcreteBuilder()
            .agregarHabitacion("101", 80.0);
        
        Reserva reserva = cliente.crearReserva(builder);
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
    }
    
    @Test
    @DisplayName("Reportar incidente debe retornar resultado adecuado")
    void testReportarIncidente() {
        Cliente cliente = new Cliente(new AgenteSoporte());
        Resultado resultado = cliente.reportarIncidente("Problema test");
        assertEquals(Resultado.RESUELTO, resultado);
    }
}
=======

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    // ----- Clases de prueba (stubs) -----
    static class PaqueteStub implements Paquete {
        private final boolean disponible;

        PaqueteStub(boolean disponible) {
            this.disponible = disponible;
        }

        @Override
        public boolean estaDisponible() {
            return disponible;
        }
    }

    static class PaqueteBuilderStub extends PaqueteBuilder {
        private final Paquete paquete;

        PaqueteBuilderStub(Paquete paquete) {
            this.paquete = paquete;
        }

        @Override
        public Reserva construir() {
            return new Reserva(paquete);
        }
    }

    static class ManejadorIncidenteStub extends ManejadorIncidente {
        @Override
        public Resultado manejar(Incidente incidente) {
            return new Resultado(true, "Incidente procesado: " + incidente.getDescripcion());
        }
    }

    static class ObservadorReservaStub implements ObservadorReserva {
        boolean notificado = false;

        @Override
        public void actualizar(Reserva reserva) {
            notificado = true;
        }
    }

    // ----- Pruebas -----

    @Test
    @DisplayName("Debe confirmar reserva cuando el paquete está disponible")
    void testCrearReservaDisponible() {
        Paquete paquete = new PaqueteStub(true);
        PaqueteBuilder builder = new PaqueteBuilderStub(paquete);
        Cliente cliente = new Cliente(new ManejadorIncidenteStub());

        Reserva reserva = cliente.crearReserva(builder);

        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
    }

    @Test
    @DisplayName("Debe rechazar reserva cuando el paquete NO está disponible")
    void testCrearReservaNoDisponible() {
        Paquete paquete = new PaqueteStub(false);
        PaqueteBuilder builder = new PaqueteBuilderStub(paquete);
        Cliente cliente = new Cliente(new ManejadorIncidenteStub());

        Reserva reserva = cliente.crearReserva(builder);

        assertEquals(EstadoReserva.RECHAZADA, reserva.getEstado());
    }

    @Test
    @DisplayName("Debe reportar incidente correctamente")
    void testReportarIncidente() {
        Cliente cliente = new Cliente(new ManejadorIncidenteStub());

        Resultado resultado = cliente.reportarIncidente("Prueba de incidente");

        assertTrue(resultado.isExito());
        assertTrue(resultado.getMensaje().contains("Prueba de incidente"));
    }

    @Test
    @DisplayName("Debe agregar observador a la lista interna")
    void testAgregarObservador() throws Exception {
        Cliente cliente = new Cliente(new ManejadorIncidenteStub());
        ObservadorReservaStub observador = new ObservadorReservaStub();

        cliente.agregarObservador(observador);

        // Acceso a la lista interna usando reflexión
        var campo = Cliente.class.getDeclaredField("observadores");
        campo.setAccessible(true);
        List<?> lista = (List<?>) campo.get(cliente);

        assertTrue(lista.contains(observador));
    }
}
>>>>>>> Stashed changes
