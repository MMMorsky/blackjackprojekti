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
        this.panos = 0;
    }

    /**
     * Panostaa 100.
     */
    public void panosta100() {
        this.panos += 100;
    }

    /**
     * Panostaa 200.
     */
    public void panosta200() {
        this.panos += 200;
    }

    /**
     * Panostaa 50.
     */
    public void panosta50() {
        this.panos += 50;
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
