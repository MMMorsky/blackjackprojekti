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
public class PelipoytaTest {

    Pelipoyta pelipoyta;

    public PelipoytaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pelipoyta = new Pelipoyta();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void aloitusToimii() {
        pelipoyta.aloita();
        assertEquals(pelipoyta.getKorttipakka().getKortit().size(), 48);
    }

    @Test
    public void pelaajanNostaminenLisaaPelaajanKortteja() {
        pelipoyta.pelaajaNostaa();
        assertEquals(pelipoyta.getPelaaja().getKortit().size(), 1);
    }

    @Test
    public void korttipakanLuontiOnnistuu() {
        assertEquals(pelipoyta.getKorttipakka().getKortit().size(), 52);
    }

    @Test
    public void korttipakastaVaheneeKortitJaettassa() {
        pelipoyta.jaaKortit();
        assertEquals(pelipoyta.getKorttipakka().getKortit().size(), 48);
    }

    @Test
    public void jakajallaOikeaMaaraKorttejaJaettaessa() {
        pelipoyta.jaaKortit();
        assertEquals(2, pelipoyta.getJakaja().getKortit().size());
    }

    @Test
    public void jakajanNostaessaJakajanKortitLisaantyy() {
        pelipoyta.jakajaNostaa();
        assertEquals(pelipoyta.getJakaja().getKortit().size(), 1);
    }

    @Test
    public void jakajanNosteassaKortitVahenee() {
        pelipoyta.jakajaNostaa();
        assertEquals(pelipoyta.getKorttipakka().getKortit().size(), 51);
    }

    @Test
    public void korttienjaossaPelaajalleOikeaMaaraKortteja() {
        pelipoyta.jaaKortit();
        assertEquals(pelipoyta.getPelaaja().getKortit().size(), 2);
    }

    @Test
    public void nostaakoJakajaJosPisteet16() {
        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 7));

        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 6));
        assertTrue(pelipoyta.nostaakoJakaja());
    }

    @Test
    public void nostaakoJakajaJosPisteet18() {
        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));

        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 8));
        assertFalse(pelipoyta.nostaakoJakaja());
    }

    @Test
    public void nostaakoJakajaJospisteetAssaPakassa() {
        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));

        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 1));
        assertFalse(pelipoyta.nostaakoJakaja());
    }

    @Test
    public void nostaakoJakajaJospisteetKaksiAssaaPakassa() {
        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));

        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 2));
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 1));
        assertTrue(pelipoyta.nostaakoJakaja());
    }

    @Test
    public void pelaajallaEnemmanPisteita() {
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 8));

        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 9));

        assertEquals(pelipoyta.kenellaEnitenPisteita(), 1);
    }

    @Test
    public void jakajallaEnemmanPisteita() {
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 10));

        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 9));

        assertEquals(pelipoyta.kenellaEnitenPisteita(), 3);
    }

    @Test
    public void jakajallaEnemmanPisteitaAssaKadessa() {
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 1));
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 10));

        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 1));
        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 3));

        assertEquals(pelipoyta.kenellaEnitenPisteita(), 3);
    }

    @Test
    public void tasaPeliToimii() {
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 10));

        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));

        assertEquals(pelipoyta.kenellaEnitenPisteita(), 2);
    }

    @Test
    public void uusiKierrosToimiiPelaajalla() {
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 10));

        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));

        pelipoyta.uusiKierros();

        assertEquals(0, pelipoyta.getPelaaja().getKortit().size());
    }

    @Test
    public void uusiKierrosToimiiJakajalla() {
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 10));

        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));

        pelipoyta.uusiKierros();

        assertEquals(0, pelipoyta.getJakaja().getKortit().size());
    }

    @Test
    public void uusiKierrosToimiiPakalla() {
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getJakaja().setKortti(new Kortti(Maa.PATA, 10));

        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));
        pelipoyta.getPelaaja().setKortti(new Kortti(Maa.PATA, 10));

        pelipoyta.getKorttipakka().annaKortti();

        pelipoyta.uusiKierros();

        assertEquals(52, pelipoyta.getKorttipakka().getKortit().size());
    }

    @Test
    public void getPelinTilaToimii() {
        pelipoyta.setPelinTila(2);
        assertEquals(2, pelipoyta.getPelinTila());
    }

    @Test
    public void setPelinTilaToimiiKunKaynnistetaanPeli() {
        pelipoyta.getPelaaja().setPanos(200);
        pelipoyta.getPelaaja().setRahamaara(200);
        pelipoyta.setPelinTila(1);
        assertEquals(0, pelipoyta.getPelaaja().getRahamaara());
    }

    @Test
    public void setPelinTilaToimiiKunBlackJack() {
        pelipoyta.getPelaaja().setPanos(200);
        pelipoyta.getPelaaja().setRahamaara(200);
        pelipoyta.setPelinTila(1);
        pelipoyta.setPelinTila(5);
        assertEquals(600, pelipoyta.getPelaaja().getRahamaara());
    }

    @Test
    public void setPelinTilaToimiiKunBlackJackPanosNollataan() {
        pelipoyta.getPelaaja().setPanos(200);
        pelipoyta.getPelaaja().setRahamaara(200);
        pelipoyta.setPelinTila(1);
        pelipoyta.setPelinTila(5);
        assertEquals(0, pelipoyta.getPelaaja().getPanos());
    }

    @Test
    public void setPelinTilaToimiiKunHavitaanPeli() {
        pelipoyta.getPelaaja().setPanos(200);
        pelipoyta.getPelaaja().setRahamaara(200);
        pelipoyta.setPelinTila(1);
        pelipoyta.setPelinTila(2);
        assertEquals(0, pelipoyta.getPelaaja().getRahamaara());
    }

    @Test
    public void setPelinTilaToimiiKunHavitaanPeliPanosnollataan() {
        pelipoyta.getPelaaja().setPanos(200);
        pelipoyta.getPelaaja().setRahamaara(200);
        pelipoyta.setPelinTila(1);
        pelipoyta.setPelinTila(2);
        assertEquals(0, pelipoyta.getPelaaja().getPanos());
    }

    @Test
    public void setPelinTilaToimiiKunVoitetaanPeli() {
        pelipoyta.getPelaaja().setPanos(200);
        pelipoyta.getPelaaja().setRahamaara(200);
        pelipoyta.setPelinTila(1);
        pelipoyta.setPelinTila(3);
        assertEquals(400, pelipoyta.getPelaaja().getRahamaara());
    }

    @Test
    public void setPelinTilaToimiiKunVoitetaanPeliJaPanosnollataan() {
        pelipoyta.getPelaaja().setPanos(200);
        pelipoyta.getPelaaja().setRahamaara(200);
        pelipoyta.setPelinTila(1);
        pelipoyta.setPelinTila(3);
        assertEquals(0, pelipoyta.getPelaaja().getPanos());
    }

    @Test
    public void setPelinTilaToimiiKunTasapeli() {
        pelipoyta.getPelaaja().setPanos(200);
        pelipoyta.getPelaaja().setRahamaara(200);
        pelipoyta.setPelinTila(1);
        pelipoyta.setPelinTila(4);
        assertEquals(200, pelipoyta.getPelaaja().getRahamaara());
    }

}
