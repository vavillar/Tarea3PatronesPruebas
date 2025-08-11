/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.tarea3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ec.edu.espol.tarea3.estadosTipos.Resultado;

/**
 *
 * @author Victor
 */
public class ClienteTest {
    
    public ClienteTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // Stub para ManejadorIncidente
    static class ManejadorIncidenteStub extends ManejadorIncidente {
        Resultado resultadoEsperado;
        Incidente incidenteRecibido;

        public ManejadorIncidenteStub(Resultado resultadoEsperado) {
            this.resultadoEsperado = resultadoEsperado;
        }

        @Override
        public Resultado manejar(Incidente incidente) {
            this.incidenteRecibido = incidente;
            return resultadoEsperado;
        }
    }

    /**
     * Test of crearReserva method, of class Cliente.
     */
    @Test
    public void testCrearReserva() {
        System.out.println("crearReserva");
        ManejadorIncidenteStub manejadorStub = new ManejadorIncidenteStub(Resultado.RESUELTO);
        Cliente cliente = new Cliente(manejadorStub);

        Reserva reserva = cliente.crearReserva();
        assertNotNull(reserva);
        assertTrue(reserva.getPrecioTotal() > 0);
    }

    /**
     * Test of reportarIncidente method, of class Cliente.
     */
    @Test
    public void testReportarIncidente() {
        System.out.println("reportarIncidente");
        ManejadorIncidenteStub manejadorStub = new ManejadorIncidenteStub(Resultado.RESUELTO);
        Cliente cliente = new Cliente(manejadorStub);

        String descripcion = "Problema en la habitación";
        Resultado resultado = cliente.reportarIncidente(descripcion);

        assertEquals(Resultado.RESUELTO, resultado);
        assertNotNull(manejadorStub.incidenteRecibido);
        assertEquals(descripcion, manejadorStub.incidenteRecibido.getDescripcion());
    }
    
}
