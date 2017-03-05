package blakjakprojekti.logiikka;

import java.util.*;

/**
 * BlackJackPöydässä oleva toimija ja sen toiminnallisuus.
 *
 * @author max
 */
public class Toimija {

    private List<Kortti> kortit;
    private List<Kortti> jaetutkortit;

    /**
     * Alustaa toimijan ja siihen liittyvät listat.
     */
    public Toimija() {
        this.kortit = new ArrayList<>();
        this.kortit = new ArrayList<>();
    }

    /**
     * Testaa onko toimijan korttien summa yli 21.
     *
     * @return palauttaa true jos menee yli.
     */
    public boolean meneekoYli() {
        if (palautaPisteet().isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Palauttaa toimijan pisteet listana. Mikäli on ässiä kädessä tulee listaan
     * 2 arvoa.
     *
     *
     * @return palauttaa pisteet.
     */
    public List<Integer> palautaPisteet() {
        List<Integer> palautettava = new ArrayList<>();
        List<Integer> paaArvo = new ArrayList<>();
        List<Integer> varaArvo = new ArrayList<>();

        int tuleekoToinenLuku = 0;

        for (Kortti kortti : kortit) {
            if (kortti.getArvo() == 1) {
                varaArvo.add(1);

                paaArvo.add(11);
                tuleekoToinenLuku++;
            } else if (kortti.getArvo() >= 10) {

                varaArvo.add(10);
                paaArvo.add(10);
            } else {

                varaArvo.add(kortti.getArvo());
                paaArvo.add(kortti.getArvo());
            }
        }

        int temp = 0;
        int temp2 = 0;

        int varaArvosumma = varaArvo.stream().mapToInt(Integer::intValue).sum();
        int paaArvosumma = paaArvo.stream().mapToInt(Integer::intValue).sum();

        for (Integer arvo : paaArvo) {
            temp += arvo;
        }

        if (paaArvosumma <= 21) {
            palautettava.add(temp);
        }

        if (!varaArvo.isEmpty() && tuleekoToinenLuku >= 1 && varaArvosumma <= 21) {
            for (Integer arvo : varaArvo) {
                temp2 += arvo;
            }
            palautettava.add(temp2);
        }
        return palautettava;
    }

    /**
     * Aloittaa uuden pelin.
     */
    public void uusiPeli() {
        this.kortit.clear();
    }

    public List<Kortti> getKortit() {
        return kortit;
    }

    /**
     * Asettaa kortin.
     *
     * @param kortti asettaa pelaajalle kortin
     */
    public void setKortti(Kortti kortti) {
        this.kortit.add(kortti);
    }

}
