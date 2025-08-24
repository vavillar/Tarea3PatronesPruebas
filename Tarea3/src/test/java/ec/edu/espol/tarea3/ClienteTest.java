package ec.edu.espol.tarea3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ec.edu.espol.tarea3.builder.Reserva;
import ec.edu.espol.tarea3.estadosTipos.Resultado;

class ClienteTest {
    
    private Cliente cliente;
    private ReservaServiceStub reservaService;
    private IncidenteServiceStub incidenteService;

    static class ReservaServiceStub extends ReservaService {
        private boolean llamadoCrearYConfirmar = false;

        @Override
        public Reserva crearYConfirmar() {
            llamadoCrearYConfirmar = true;
            return new Reserva(null) {
                @Override
                public double getPrecioTotal() {
                    return 100.0;
                }
            };
        }

        public boolean fueLlamadoCrearYConfirmar() {
            return llamadoCrearYConfirmar;
        }
    }

    static class IncidenteServiceStub extends IncidenteService {
        private String ultimaDescripcion;

        public IncidenteServiceStub() {
            super(null);
        }

        @Override
        public Resultado reportar(String descripcion) {
            if (descripcion == null) {
                throw new IllegalArgumentException("La descripción no puede ser null");
            }
            this.ultimaDescripcion = descripcion;
            return Resultado.RESUELTO;
        }

        public String getUltimaDescripcion() {
            return ultimaDescripcion;
        }
    }

    @BeforeEach
    void setUp() {
        reservaService = new ReservaServiceStub();
        incidenteService = new IncidenteServiceStub();
        cliente = new Cliente(reservaService, incidenteService);
    }

    @Test
    void testCrearReserva() {
        Reserva reserva = cliente.crearReserva();
        
        assertAll("Creación de reserva",
            () -> assertNotNull(reserva, "La reserva no debe ser null"),
            () -> assertEquals(100.0, reserva.getPrecioTotal(), "El precio total debe ser 100"),
            () -> assertTrue(reservaService.fueLlamadoCrearYConfirmar(), "Debe llamar a crearYConfirmar")
        );
    }

    @Test
    void testReportarIncidente() {
        String descripcion = "Problema con la habitación";
        Resultado resultado = cliente.reportarIncidente(descripcion);
        
        assertAll("Reporte de incidente",
            () -> assertEquals(Resultado.RESUELTO, resultado, "El resultado debe ser RESUELTO"),
            () -> assertEquals(descripcion, incidenteService.getUltimaDescripcion(), 
                    "La descripción debe coincidir con la enviada")
        );
    }

    @Test
    void testConstructorConParametrosNulos() {
        assertAll("Constructor con parámetros nulos",
            () -> assertThrows(NullPointerException.class, 
                () -> new Cliente(null, incidenteService), 
                "Debe lanzar excepción si reservaService es null"),
            () -> assertThrows(NullPointerException.class, 
                () -> new Cliente(reservaService, null),
                "Debe lanzar excepción si incidenteService es null")
        );
    }

    @Test
    void testReportarIncidenteConDescripcionNula() {
        assertThrows(IllegalArgumentException.class,
            () -> cliente.reportarIncidente(null),
            "Debe lanzar excepción si la descripción es null"
        );
    }
}
