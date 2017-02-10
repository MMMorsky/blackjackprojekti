package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.logiikka.Kortti;
import blakjakprojekti.logiikka.Pelipoyta;
import java.util.Scanner;

/**
 * Blackjack projektin käyttöliittymä
 *
 * @author max
 */
public class Kayttoliittyma {

    private Scanner lukija;
    private Pelipoyta pelipoyta;

    public Kayttoliittyma(Scanner lukija) {
        this.pelipoyta = new Pelipoyta();
        this.lukija = lukija;
    }

    public void kaynnista() {
        while (true) {

            pelipoyta.aloita();

            tulostaKortit();

            System.out.println("");

            tulostaPisteet();

            pelaajanNosto();
            jakajanNosto();

            if (pelipoyta.kenellaEnitenPisteita() == 1) {
                System.out.println("Voitit");
            } else if (pelipoyta.kenellaEnitenPisteita() == 2) {
                System.out.println("Tasapeli");
            } else {
                System.out.println("Hävisit");
            }

            System.out.println();
            System.out.println("UusiKierros");
            System.out.println();
            pelipoyta.uusiKierros();
        }
    }

    public void jakajanNosto() {

        while (true) {
            if (!pelipoyta.nostaakoJakaja()) {
                break;
            }
            System.out.println("Jakaja Nostaa");
            System.out.println();
            pelipoyta.jakajaNostaa();

            tulostaKortit();
            tulostaPisteet();

            if (pelipoyta.getJakaja().meneekoYli()) {
                break;
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void pelaajanNosto() {

        while (true) {
            System.out.println("Nostetaanko kortti?");
            System.out.println("n - Nosto  -- j Jää");
            String komento = lukija.nextLine();
            if (komento.equals("n")) {
                pelipoyta.pelaajaNostaa();
            } else if (komento.equals("j")) {
                break;
            }

            tulostaKortit();
            tulostaPisteet();

            if (pelipoyta.getPelaaja().meneekoYli()) {
                break;
            }
            System.out.println("");
        }

    }

    public void tulostaKortit() {
        System.out.println("Tämän hetkiset kortit: ");
        for (Kortti kortti : pelipoyta.getPelaaja().getKortit()) {
            System.out.print(kortti + " ");
        }
        System.out.println("");
        System.out.println("Jakajan kortit: ");
        for (Kortti kortti : pelipoyta.getJakaja().getKortit()) {
            System.out.print(kortti + " ");
        }
        System.out.println("");
    }

    public void tulostaPisteet() {
        int temp = 0;
        int temp2 = 0;
        System.out.println("Pelaajan pisteet:");
        System.out.print("Pisteet: ");
        for (Integer arvo : pelipoyta.getPelaaja().palautaPisteet()) {
            System.out.print(arvo + " ");
            temp++;
        }
        if (temp == 0) {
            System.out.println("Ylimeni");
        }
        System.out.println();
        System.out.println("Jakanpisteet");
        System.out.print("Pisteet: ");

        for (Integer arvo : pelipoyta.getJakaja().palautaPisteet()) {
            System.out.print(arvo + " ");
            temp2++;
        }
        if (temp2 == 0) {
            System.out.println("Ylimeni");
        }
        System.out.println();
    }
}
