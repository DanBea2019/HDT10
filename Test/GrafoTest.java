import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * 
 * @author Daniela Batz 19214
 *
 */

public class GrafoTest {
    
    public GrafoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of testadd method, of class Grafo.
     */
    @Test
    public void testadd() {
        System.out.println("agregar");
        String ciudad = "Ciudad1";
        Grafo instance = new Grafo();
        instance.agregar(ciudad);
    }

    /**
     * Test of testgetEdge method, of class Grafo.
     */
    @Test
    public void testgetEdge() {
        System.out.println("agregarGrafo");
        String ciudad1 = "ciudad1";
        String ciudad2 = "ciudad2";
        int d = 2;
        Grafo instance = new Grafo();
        instance.agregarGrafo(ciudad1, ciudad2,d);
    }

}