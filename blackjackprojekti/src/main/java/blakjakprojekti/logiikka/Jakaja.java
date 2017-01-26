package blakjakprojekti.logiikka;

import java.util.ArrayList;
import java.util.List;

public class Jakaja {

    private List<Kortti> kortit;

    public Jakaja() {
        this.kortit = new ArrayList<>();
    }

    public List<Kortti> getKortit() {
        return kortit;
    }

    public void setKortti(Kortti kortti) {
        this.kortit.add(kortti);
    }
}
