package blakjakprojekti.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Korttipakka {

    private List<Kortti> kortit;

    public Korttipakka() {
        this.kortit = new ArrayList<>();
        luoPakka();
    }

    public void sekoita() {
        Collections.shuffle(this.kortit);
    }



    public void luoPakka() {
        for (int i = 1; i < 14; i++) {
            kortit.add(new Kortti(1, i));
        }
        for (int i = 1; i < 14; i++) {
            kortit.add(new Kortti(2, i));
        }
        for (int i = 1; i < 14; i++) {
            kortit.add(new Kortti(3, i));
        }
        for (int i = 1; i < 14; i++) {
            kortit.add(new Kortti(4, i));
        }
    }

    public List<Kortti> getKortit() {
        return kortit;
    }

    public void otaKortti(Kortti kortti) {
        this.kortit.add(kortti);
    }

    public Kortti annaKortti() {
        Kortti kortti = kortit.get(0);
        kortit.remove(0);
        return kortti;
    }

}
