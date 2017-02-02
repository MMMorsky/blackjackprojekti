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
            kortit.add(new Kortti(Maa.HERTTA, i));
        }
        for (int i = 1; i < 14; i++) {
            kortit.add(new Kortti(Maa.PATA, i));
        }
        for (int i = 1; i < 14; i++) {
            kortit.add(new Kortti(Maa.RISTI, i));
        }
        for (int i = 1; i < 14; i++) {
            kortit.add(new Kortti(Maa.RUUTU, i));
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
