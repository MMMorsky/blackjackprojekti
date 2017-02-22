package blakjakprojekti.logiikka;

/**
 * Blackjack pelin pelaaja.
 *
 * @author max
 */
public class Pelaaja extends Toimija {

    private int rahamaara;
    private int panos;

    /**
     * Alustaa pelaajan.
     */
    public Pelaaja() {
        this.rahamaara = 500;
    }

    public int getRahamaara() {
        return rahamaara;
    }

    public void setRahamaara(int rahamaara) {
        this.rahamaara = rahamaara;
    }

    public int getPanos() {
        return panos;
    }

    public void setPanos(int panos) {
        this.panos = panos;
    }
    
    
}
