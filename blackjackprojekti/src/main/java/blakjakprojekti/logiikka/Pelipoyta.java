package blakjakprojekti.logiikka;

/**
 * Tässä on ohjelma loogikan ylin aste, jolla voidaan ohjailla pelipöytää.
 */
public class Pelipoyta {

    private Pelaaja pelaaja;
    private Jakaja jakaja;
    private Korttipakka korttipakka;

    /**
     * Alustaa pelipöydän.
     */
    public Pelipoyta() {
        uusiKierros();
    }

    /**
     * Sekoittaa korttipakan ja jakaa pelaajille kortit.
     */
    public void aloita() {
        korttipakka.sekoita();
        jaaKortit();

    }

    /**
     * Alustaa/resetoi pelipöydän.
     */
    public void uusiKierros() {
        this.jakaja = new Jakaja();
        this.pelaaja = new Pelaaja();
        this.korttipakka = new Korttipakka();
    }

    /**
     * Jakaa aloituksessa pelaajalle ja jakajalle 2 korttia.
     */
    public void jaaKortit() {
        pelaaja.setKortti(korttipakka.annaKortti());
        pelaaja.setKortti(korttipakka.annaKortti());

        jakaja.setKortti(korttipakka.annaKortti());
        jakaja.setKortti(korttipakka.annaKortti());
    }

    /**
     * kertoo kayttoliittymalle nostaako jakaja lisää kortteja.
     *
     * @return palauttaa true mikäli jakaja nostaa lisää.
     */
    public boolean nostaakoJakaja() {
        int temp1 = 0;
        int temp2 = 0;
        for (Integer arvo : jakaja.palautaPisteet()) {
            if (arvo > 16) {
                temp1++;
                temp2++;
            } else {
                temp1++;
            }
        }
        if (kenellaEnitenPisteita() == 3) {
            return false;
        } else if (temp1 == 1 && temp2 == 1) {
            return false;
        } else if (temp1 == 2 && temp2 == 2) {
            return false;
        } else if (temp1 == 0 && temp2 == 0) {
            return false;
        }
        return true;
    }

    /**
     * Palauttaa sen kenellä on eniten pisteitä.
     *
     * @return 1 jos pelaajalla 2 jos tasapeli 3 jos jakajalla.
     */
    public int kenellaEnitenPisteita() {
        int pelaajanKorkein = 0;
        int jakajanKorkein = 0;

        for (Integer arvo : pelaaja.palautaPisteet()) {
            if (arvo > pelaajanKorkein) {
                pelaajanKorkein = arvo;
            }
        }

        for (Integer arvo : jakaja.palautaPisteet()) {
            if (arvo > jakajanKorkein) {
                jakajanKorkein = arvo;
            }
        }

        if (pelaajanKorkein < jakajanKorkein) {
            return 3;
        } else if (pelaajanKorkein > jakajanKorkein) {
            return 1;
        } else {
            return 2;
        }

    }
    /**
     * Jakaja nostaa korttipakasta yhden kortin.
     */
    public void jakajaNostaa() {
        this.jakaja.setKortti(korttipakka.annaKortti());
    }
    /**
     * Pelaaja nostaa korttipakasta yhden kortin.
     */
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
