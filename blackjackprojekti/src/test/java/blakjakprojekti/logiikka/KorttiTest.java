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
    public void korttiPalauttaaOikeanTiedostoPaatteen() {
        kortti = new Kortti(Maa.HERTTA, 4);
        assertEquals("HERTTA4.jpg", kortti.palautaTiedostopaate());
    }

    @Test
    public void korttiPalauttaaOikeanEnumLuokan() {
        kortti = new Kortti(Maa.RUUTU, 4);
        assertEquals(Maa.RUUTU, kortti.getMaa());
    }

    @Test
    public void korttiPalauttaaNumeron() {
        kortti = new Kortti(Maa.PATA, 4);
        assertEquals(4, kortti.getArvo());
    }

    @Test
    public void korttiPalauttaaOikeanMaaLuokan() {
        kortti = new Kortti(Maa.PATA, 4);
        assertEquals(Maa.PATA, kortti.getMaa());
    }

}
