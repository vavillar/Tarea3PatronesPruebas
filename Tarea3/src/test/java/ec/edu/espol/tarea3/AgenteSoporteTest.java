/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.tarea3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ec.edu.espol.tarea3.estadosTipos.Resultado;

/**
 *
 * @author Victor
 */
public class AgenteSoporteTest {
    
    public AgenteSoporteTest() {
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

    /**
     * Test of manejar method, of class AgenteSoporte.
     */
    @Test
    public void testManejar() {
        AgenteSoporte instance = new AgenteSoporte();
        Incidente incidente = new Incidente("INC-0", "Incidente simple: luz no funciona");
        Resultado expResult = Resultado.RESUELTO;
        Resultado result = instance.manejar(incidente);
        assertEquals(expResult, result);
    }
    
    @Test
    void testManejarIncidenteSimple() {
        AgenteSoporte agente = new AgenteSoporte();
        Incidente incidente = new Incidente("INC-1", "Incidente simple: TV no prende");
        Resultado resultado = agente.manejar(incidente);
        assertEquals(Resultado.RESUELTO, resultado);
    }

    @Test
    void testManejarIncidenteNoResueltoSinSiguiente() {
        AgenteSoporte agente = new AgenteSoporte();
        Incidente incidente = new Incidente("INC-2", "Incidente complejo: fuga de agua");
        Resultado resultado = agente.manejar(incidente);
        assertEquals(Resultado.NO_RESUELTO, resultado);
    }

    @Test
    void testManejarIncidenteNoResueltoConSiguiente() {
        AgenteSoporte agente = new AgenteSoporte();
        // Stub para siguiente manejador
        ManejadorIncidente siguienteStub = new ManejadorIncidente() {
            @Override
            public Resultado manejar(Incidente incidente) {
                return Resultado.RESUELTO;
            }
        };
        agente.setSiguiente(siguienteStub);

        Incidente incidente = new Incidente("INC-3", "Incidente complejo: fuga de agua");
        Resultado resultado = agente.manejar(incidente);
        assertEquals(Resultado.RESUELTO, resultado);
    }
}
