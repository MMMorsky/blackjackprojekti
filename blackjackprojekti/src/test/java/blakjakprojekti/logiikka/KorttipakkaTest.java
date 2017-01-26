package blakjakprojekti.logiikka;

import blakjakprojekti.logiikka.Korttipakka;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KorttipakkaTest {
    
    Korttipakka korttipakka;
    
    public KorttipakkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.korttipakka = new Korttipakka();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void oikeamaaraKortteja() {
        assertEquals(52, korttipakka.getKortit().size());
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
