package blakjakprojekti.logiikka;

/**
 * Blackjack pelin kortti luokka, jolle on annettu arvo ja maa.
 *
 * @author max
 */
public class Kortti {

    private Maa maa;
    private int arvo;

    /**
     * Luokan konstruktori.
     *
     * @param maa Kortin maa, enum luokkana.
     * @param arvo Kortin arvo.
     */
    public Kortti(Maa maa, int arvo) {
        this.maa = maa;
        this.arvo = arvo;
    }

    public Maa getMaa() {
        return this.maa;
    }

    public int getArvo() {
        return this.arvo;
    }

    /**
     * Palauttaa tiedostonpäätteen, jotta voidaan valita oikea kuva käyttöliittymälle.
     * @return oikean tiedostopäätteen
     */
    public String palautaTiedostopaate() {
        return "" + this.maa + this.arvo + ".jpg";
    }

}
