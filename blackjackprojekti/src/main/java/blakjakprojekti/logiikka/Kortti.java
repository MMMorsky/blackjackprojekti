package blakjakprojekti.logiikka;
/**
 * Blackjack pelin kortti luokka, jolle on annettu arvo ja maa
 * @author max
 */
public class Kortti {

    private Maa maa;
    private int arvo;

    public Kortti(Maa maa, int arvo) {
        this.maa = maa;
        this.arvo = arvo;
    }

    public Maa getMaa() {
        return maa;
    }

    public int getArvo() {
        return arvo;
    }

    public Maa annaMaa() {
        return this.maa;
    }

    public String annaArvo() {
        if (arvo == 11) {
            return "J";
        } else if (arvo == 12) {
            return "Q";
        } else if (arvo == 13) {
            return "K";
        } else if (arvo == 1) {
            return "A";
        } else {
            return Integer.toString(this.arvo);
        }

    }

    @Override
    public String toString() {
        return annaMaa() + " " + annaArvo();
    }

}
