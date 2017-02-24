package blakjakprojekti.logiikka;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ToimijaTest {

    Toimija toimija;
    List<Integer> lista;

    public ToimijaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        toimija = new Toimija();
        lista = new ArrayList<>();
    }

    @After
    public void tearDown() {
    }

    public void pisteidenPalautusToimii() {
        toimija.setKortti(new Kortti(Maa.HERTTA, 1));
        lista.add(1);

        assertEquals(toimija.palautaPisteet(), lista);
    }

    @Test
    public void pisteidenPalautusToimiiAssanKanssa() {
        toimija.setKortti(new Kortti(Maa.HERTTA, 1));
        toimija.setKortti(new Kortti(Maa.HERTTA, 1));

        lista.add(2);

        assertEquals(toimija.palautaPisteet(), lista);
    }

    @Test
    public void pisteidenPalatusToimiiJosMeneeYli() {
        toimija.setKortti(new Kortti(Maa.HERTTA, 11));
        toimija.setKortti(new Kortti(Maa.HERTTA, 12));
        toimija.setKortti(new Kortti(Maa.HERTTA, 2));

        assertTrue(toimija.palautaPisteet().isEmpty());

    }

    @Test
    public void meneekoYliTestiYksYli() {
        toimija.setKortti(new Kortti(Maa.HERTTA, 11));
        toimija.setKortti(new Kortti(Maa.HERTTA, 12));
        toimija.setKortti(new Kortti(Maa.HERTTA, 2));

        assertTrue(toimija.meneekoYli());
    }

    @Test
    public void pisteidenPalautusToimiiJosArvo16() {
        toimija.setKortti(new Kortti(Maa.HERTTA, 10));
        toimija.setKortti(new Kortti(Maa.HERTTA, 6));
        assertEquals(toimija.palautaPisteet().stream().mapToInt(Integer::intValue).sum(), 16);
    }

    @Test
    public void meneekoYliTasan() {
        toimija.setKortti(new Kortti(Maa.HERTTA, 11));
        toimija.setKortti(new Kortti(Maa.HERTTA, 12));
        toimija.setKortti(new Kortti(Maa.HERTTA, 1));

        assertFalse(toimija.meneekoYli());
    }

    @Test
    public void meneekoYliYksAlle() {
        toimija.setKortti(new Kortti(Maa.HERTTA, 11));
        toimija.setKortti(new Kortti(Maa.HERTTA, 12));

        assertFalse(toimija.meneekoYli());
    }

}
