package blakjakprojekti.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    Pelaaja pelaaja;

    public PelaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pelaaja = new Pelaaja();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelaajallaOikeaMaaraRahaaAlussa() {
        assertEquals(pelaaja.getRahamaara(), 500);
    }
}
