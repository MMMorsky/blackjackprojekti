
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

    @Override
    public String toString() {
        return this.maa + " " + this.arvo;
    }
    
    
}