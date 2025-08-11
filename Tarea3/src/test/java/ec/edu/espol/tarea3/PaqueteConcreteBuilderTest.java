
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.tarea3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Victor
 */
public class PaqueteConcreteBuilderTest {
    
    public PaqueteConcreteBuilderTest() {
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
     * Test of agregarHabitacion method, of class PaqueteConcreteBuilder.
     */
    @Test
    public void testAgregarHabitacion() {
        System.out.println("agregarHabitacion");
        String numero = "";
        double precio = 0.0;
        PaqueteConcreteBuilder instance = new PaqueteConcreteBuilder();
        PaqueteBuilder expResult = null;
        PaqueteBuilder result = instance.agregarHabitacion(numero, precio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarPaseo method, of class PaqueteConcreteBuilder.
     */
    @Test
    public void testAgregarPaseo() {
        System.out.println("agregarPaseo");
        String nombre = "";
        double precio = 0.0;
        PaqueteConcreteBuilder instance = new PaqueteConcreteBuilder();
        PaqueteBuilder expResult = null;
        PaqueteBuilder result = instance.agregarPaseo(nombre, precio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarExtra method, of class PaqueteConcreteBuilder.
     */
    @Test
    public void testAgregarExtra() {
        System.out.println("agregarExtra");
        Componente extra = null;
        PaqueteConcreteBuilder instance = new PaqueteConcreteBuilder();
        PaqueteBuilder expResult = null;
        PaqueteBuilder result = instance.agregarExtra(extra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of construir method, of class PaqueteConcreteBuilder.
     */
    @Test
    public void testConstruir() {
        System.out.println("construir");
        PaqueteConcreteBuilder instance = new PaqueteConcreteBuilder();
        Reserva expResult = null;
        Reserva result = instance.construir();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
