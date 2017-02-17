package blakjakprojekti.logiikka;

/**
 * Blackjack pelin pelaaja.
 *
 * @author max
 */
public class Pelaaja extends Toimija {

    private int rahamaara;

    /**
     * Alustaa pelaajan.
     */
    public Pelaaja() {
        this.rahamaara = 500;
    }
}
