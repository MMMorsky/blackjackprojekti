/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blakjakprojekti.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author max
 */
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
    public void pelaajanLuominenOnnistuu() {
        assertEquals(500, pelaaja.getRahamaara());
    }
    
    @Test
    public void kahdensadanPanostusToimii() {
        pelaaja.panosta200();
        assertEquals(200, pelaaja.getPanos());
    }
    
    @Test
    public void panostaminenToimiiUseallaKaskylla() {
        pelaaja.panosta100();
        pelaaja.panosta200();
        pelaaja.panosta50();
        assertEquals(350, pelaaja.getPanos());
    }
    
    @Test
    public void setRahaMaaraToimii() {
        pelaaja.setRahamaara(500);
        assertEquals(500, pelaaja.getRahamaara());
    }
    
    @Test
    public void setPanosToimii() {
        pelaaja.setPanos(5000);
        assertEquals(5000, pelaaja.getPanos());
    }
}
