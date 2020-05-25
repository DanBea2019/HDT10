import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * 
 * @author Daniela Batz
 *
 */
public class FloydTest {

	public FloydTest() {
		// TODO Auto-generated constructor stub
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
     * Test of CamCorto method, of class Floyd.
     */
    @Test
    public void testCorto() {
        System.out.println("Corto");
        Floyd instance = new Floyd();
        instance.CamCorto();
    }

    /**
     * Test of CentGrafo method, of class Floyd.
     */
    @Test
    public void testGrafo() {
        System.out.println("Grafo");
        Floyd instance = new Floyd();
        instance.CentGrafo();
    }

    /**
     * Test of Intermedios method, of class Floyd.
     */
    @Test
    public void testIntermedias() {
        System.out.println("Intermedias");
        int num = 0;
        int num2 = 0;
        Floyd instance = new Floyd();
        instance.Intermedios(num1, num2);
    }
    
}

}
