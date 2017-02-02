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
public class KorttiTest {
    Kortti kortti;
    
    public KorttiTest() {
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

    @Test
    public void korttiPalauttaaNumeron() {
        kortti = new Kortti(Maa.PATA, 4);
        assertEquals(kortti.annaArvo(), Integer.toString(4));
    }
    
    @Test
    public void korttiPalauttaaJatkan() {
        kortti = new Kortti(Maa.PATA, 11);
        assertEquals(kortti.annaArvo(), "J");
    }
    
    @Test
    public void korttiPalauttaaKuningataren() {
        kortti = new Kortti(Maa.PATA, 12);
        assertEquals(kortti.annaArvo(), "Q");
    }
    
    @Test
    public void korttiPalauttaaKuninkaan() {
        kortti = new Kortti(Maa.PATA, 13);
        assertEquals(kortti.annaArvo(), "K");
    }
    
    @Test
    public void korttiPalauttaaAssan()  {
        kortti = new Kortti(Maa.PATA, 1);
        assertEquals(kortti.annaArvo(), "A");
    }
}
