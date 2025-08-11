/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.tarea3;

import ec.edu.espol.tarea3.estadosTipos.Resultado;
import org.junit.jupiter.api.AfterEach;
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
        PaqueteBuilder builder = null;
        Cliente instance = null;
        Reserva expResult = null;
        Reserva result = instance.crearReserva(builder);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reportarIncidente method, of class Cliente.
     */
    @Test
    public void testReportarIncidente() {
        System.out.println("reportarIncidente");
        String descripcion = "";
        Cliente instance = null;
        Resultado expResult = null;
        Resultado result = instance.reportarIncidente(descripcion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarObservador method, of class Cliente.
     */
    @Test
    public void testAgregarObservador() {
        System.out.println("agregarObservador");
        ObservadorReserva observador = null;
        Cliente instance = null;
        instance.agregarObservador(observador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
