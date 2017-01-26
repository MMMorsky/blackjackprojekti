package blakjakprojekti.logiikka;

public class Kortti {

    private int maa;
    private int arvo;

    public Kortti(int maa, int arvo) {
        this.maa = maa;
        this.arvo = arvo;
    }

    public int getMaa() {
        return maa;
    }

    public int getArvo() {
        return arvo;
    }

    public String annaMaa() {
        if (maa == 1) {
            return "Pata";
        } else if (maa == 2) {
            return "Ruutu";
        } else if (maa == 3) {
            return "Hertta";
        } else {
            return "Risti";
        }
    }

    public String annaArvo() {
        if (arvo == 11) {
            return "J";
        } else if (arvo == 12) {
            return "Q";
        } else if (arvo == 13) {
            return "K";
        } else if (arvo == 1) {
            return "A";
        } else {
            return Integer.toString(this.arvo);
        }

    }

    @Override
    public String toString() {
        return annaMaa() + " " + annaArvo();
    }

}
