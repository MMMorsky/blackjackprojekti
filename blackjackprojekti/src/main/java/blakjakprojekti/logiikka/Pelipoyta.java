
package blakjakprojekti.logiikka;

import java.util.ArrayList;
import java.util.List;

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
        
        pelaaja.setKortti(korttipakka.annaKortti());
        pelaaja.setKortti(korttipakka.annaKortti());
        
        jakaja.setKortti(korttipakka.annaKortti());
        jakaja.setKortti(korttipakka.annaKortti());

    }

    
    //getterit ja setterit
    public Pelaaja getPelaaja() {
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
