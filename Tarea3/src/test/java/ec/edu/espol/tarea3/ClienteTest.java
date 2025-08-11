package ec.edu.espol.tarea3;

import ec.edu.espol.tarea3.estadosTipos.EstadoReserva;
import ec.edu.espol.tarea3.estadosTipos.Resultado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ec.edu.espol.tarea3.estadosTipos.EstadoHabitacion;

class ClienteTest {

    @Test
    @DisplayName("Reserva con paquete disponible se confirma")
    void crearReserva_PaqueteDisponible_Confirma() {
        // Configuración simple
        PaqueteBuilder builder = new PaqueteConcreteBuilder()
            .agregarHabitacion("101", 50.0); // Habitación disponible por defecto
        
        Cliente cliente = new Cliente(new AgenteSoporte());

        Reserva reserva = cliente.crearReserva(builder);
        
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
    }

    @Test
    @DisplayName("Reserva con paquete no disponible se rechaza")
    void crearReserva_PaqueteNoDisponible_Rechaza() {
        // Configuración con habitación ocupada
        Habitacion habitacion = new Habitacion("102", 60.0);
        habitacion.setEstado(EstadoHabitacion.OCUPADA);
        
        PaqueteCompuesto paquete = new PaqueteCompuesto();
        paquete.agregar(habitacion);
        
        PaqueteBuilder builder = new PaqueteConcreteBuilder() {
            @Override
            public Reserva construir() {
                return new Reserva(paquete);
            }
        };

        Cliente cliente = new Cliente(new AgenteSoporte());
        
        Reserva reserva = cliente.crearReserva(builder);
        assertEquals(EstadoReserva.RECHAZADA, reserva.getEstado());
    }

    @Test
    @DisplayName("Reportar incidente retorna resultado exitoso")
    void reportarIncidente_RetornaResultado() {
        Cliente cliente = new Cliente(new AgenteSoporte());
        Resultado resultado = cliente.reportarIncidente("Problema test");
        
        assertNotNull(resultado);
        assertTrue(resultado.isExito());
    }

    @Test
    @DisplayName("Agregar observador se ejecuta sin errores")
    void agregarObservador_NoLanzaExcepcion() {
        Cliente cliente = new Cliente(new AgenteSoporte());
        ObservadorReserva observador = reserva -> {};
        
        assertDoesNotThrow(() -> cliente.agregarObservador(observador));
    }
}