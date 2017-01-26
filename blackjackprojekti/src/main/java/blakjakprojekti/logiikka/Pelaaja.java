
package blakjakprojekti.logiikka;

import java.util.*;

public class Pelaaja {
    private String nimi;
    private List<Kortti> kortit;
    private int rahamaara;

    public Pelaaja() {
        this.kortit = new ArrayList<>();
    }

    public List<Kortti> getKortit() {
        return kortit;
    }
    
    public void setKortti(Kortti kortti) {
        this.kortit.add(kortti);
    }
    
    
    
    
    
}
