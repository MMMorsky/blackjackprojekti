package blakjakprojekti.logiikka;

public class Pelipoyta {

    private Pelaaja pelaaja;
    private Jakaja jakaja;
    private Korttipakka korttipakka;

    public Pelipoyta() {
        this.jakaja = new Jakaja();
        this.pelaaja = new Pelaaja();
        this.korttipakka = new Korttipakka();
    }

    public void aloita() {
        korttipakka.sekoita();
        jaaKortit();

    }

    public void uusiKierros() {
        this.jakaja = new Jakaja();
        this.pelaaja = new Pelaaja();
        this.korttipakka = new Korttipakka();
    }

    public void jaaKortit() {
        pelaaja.setKortti(korttipakka.annaKortti());
        pelaaja.setKortti(korttipakka.annaKortti());

        jakaja.setKortti(korttipakka.annaKortti());
        jakaja.setKortti(korttipakka.annaKortti());
    }

    public boolean kenellaOnEnitenPisteita() { //true jos pelaajalla false jos jakajalla
        int pelaajanKorkein = 0;
        int jakajanKorkein = 0;

        for (Integer arvo : pelaaja.palautaPisteet()) {
            if (arvo > pelaajanKorkein) {
                pelaajanKorkein = arvo;
            }
        }

        for ( Integer arvo : jakaja.palautaPisteet()) {
            if (arvo > jakajanKorkein) {
                jakajanKorkein = arvo;
            }
        }

        if (pelaajanKorkein < jakajanKorkein) {
            return false;
        }
        return true;
    }

    public void jakajaNostaa() {
        this.jakaja.setKortti(korttipakka.annaKortti());
    }

    public void pelaajaNostaa() {
        this.pelaaja.setKortti(korttipakka.annaKortti());
    }

    //getterit ja setterit
    public Toimija getPelaaja() {
        return pelaaja;
    }

    public void setPelaaja(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }

    public Jakaja getJakaja() {
        return jakaja;
    }

    public void setJakaja(Jakaja jakaja) {
        this.jakaja = jakaja;
    }

    public Korttipakka getKorttipakka() {
        return korttipakka;
    }

    public void setKorttipakka(Korttipakka korttipakka) {
        this.korttipakka = korttipakka;
    }

}
