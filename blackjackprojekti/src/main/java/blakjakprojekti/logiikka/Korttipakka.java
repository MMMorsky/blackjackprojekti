package blakjakprojekti.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Blackjackpöydän kortti pakka.
 *
 * @author max
 */
public class Korttipakka {

    private List<Kortti> kortit;

    /**
     * Luo korttipakan.
     */
    public Korttipakka() {
        this.kortit = new ArrayList<>();
        luoPakka();
    }

    /**
     * Sekoittaa korttipakan.
     */
    public void sekoita() {
        Collections.shuffle(this.kortit);
    }

    /**
     * Luo korttipakkaan oikean määrän oikeita kortteja.
     */
    public void luoPakka() {
        for (int i = 1; i < 14; i++) {
            kortit.add(new Kortti(Maa.HERTTA, i));
        }
        for (int i = 1; i < 14; i++) {
            kortit.add(new Kortti(Maa.PATA, i));
        }
        for (int i = 1; i < 14; i++) {
            kortit.add(new Kortti(Maa.RISTI, i));
        }
        for (int i = 1; i < 14; i++) {
            kortit.add(new Kortti(Maa.RUUTU, i));
        }
    }

    /**
     * Aloittaa uudenpelin.
     */
    public void uusiPeli() {
        this.kortit.clear();
        luoPakka();
    }

    public List<Kortti> getKortit() {
        return kortit;
    }

    /**
     * Ottaa kortin pakasta.
     *
     * @param kortti ottaa kortin.
     */
    public void otaKortti(Kortti kortti) {
        this.kortit.add(kortti);
    }

    /**
     * Antaa kortin kortin pakasta.
     *
     * @return palauttaa otetun kortin.
     */
    public Kortti annaKortti() {
        Kortti kortti = kortit.get(0);
        kortit.remove(0);
        return kortti;
    }

}
