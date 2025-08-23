/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.tarea3.composite;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Victor
 */
public class PaqueteCompuestoTest {
    
    public PaqueteCompuestoTest() {
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
     * Test of agregar method, of class PaqueteCompuesto.
     */
    @Test
    public void testAgregar() {
        System.out.println("agregar");
        Componente c = null;
        PaqueteCompuesto instance = new PaqueteCompuesto();
        instance.agregar(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of precio method, of class PaqueteCompuesto.
     */
    @Test
    public void testPrecio() {
        System.out.println("precio");
        PaqueteCompuesto instance = new PaqueteCompuesto();
        double expResult = 0.0;
        double result = instance.precio();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estaDisponible method, of class PaqueteCompuesto.
     */
    @Test
    public void testEstaDisponible() {
        System.out.println("estaDisponible");
        PaqueteCompuesto instance = new PaqueteCompuesto();
        boolean expResult = false;
        boolean result = instance.estaDisponible();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComponentes method, of class PaqueteCompuesto.
     */
    @Test
    public void testGetComponentes() {
        System.out.println("getComponentes");
        PaqueteCompuesto instance = new PaqueteCompuesto();
        List<Componente> expResult = null;
        List<Componente> result = instance.getComponentes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
