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

    @Test
    public void kortinAntaminenPoistaaKortin() {
        korttipakka.annaKortti();
        assertEquals(51, korttipakka.getKortit().size());
    }

    @Test
    public void kortinVastaanottaminenKasvattaaPakkaa() {
        korttipakka.annaKortti();
        korttipakka.otaKortti(new Kortti(Maa.HERTTA, 1));
        assertEquals(korttipakka.getKortit().size(), 52);
    }

    @Test
    public void kortinVastaanottaminenLisaaSenListaan() {
        Kortti kortti = new Kortti(Maa.HERTTA, 1);
        korttipakka.otaKortti(kortti);
        assertEquals(korttipakka.getKortit().get(52), kortti);
    }

    @Test
    public void uusiPeliMetodiToimii() {
        korttipakka.uusiPeli();
        assertEquals(52, korttipakka.getKortit().size());
    }

    @Test
    public void kortinAntaminenAntaaOikeanKortinJaTarkastaaMaan() {
        Kortti kortti = korttipakka.annaKortti();
        assertEquals(Maa.HERTTA, kortti.getMaa());
    }

}
