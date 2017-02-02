package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.logiikka.Kortti;
import blakjakprojekti.logiikka.Pelipoyta;
import java.util.Scanner;

public class Kayttoliittyma {

    private Scanner lukija;
    private Pelipoyta pelipoyta;

    public Kayttoliittyma(Scanner lukija) {
        this.pelipoyta = new Pelipoyta();
        this.lukija = lukija;
    }

    public void kaynnista() {
        pelipoyta.aloita();

        tulostaKortit();

        System.out.println("");

        tulostaPisteet();

        pelaajanNosto();

        jakajanNosto();

    }

    public boolean jakajanNosto() {

        while (true) {
            System.out.println("Jakaja Nostaa");
            System.out.println();
            pelipoyta.jakajaNostaa();

            tulostaKortit();
            tulostaPisteet();

            if (pelipoyta.getJakaja().meneekoYli()) {
                return false;
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

            if (pelipoyta.getPelaaja().meneekoYli()) {
                break;
            }

            tulostaPisteet();

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
        System.out.println("Pelaajan pisteet:");
        System.out.print("Pisteet: ");
        for (Integer arvo : pelipoyta.getPelaaja().palautaPisteet()) {
            System.out.print(arvo + " ");
        }
        System.out.println();
        System.out.println("Jakanpisteet");
        System.out.print("Pisteet: ");

        for (Integer arvo : pelipoyta.getJakaja().palautaPisteet()) {
            System.out.print(arvo + " ");
        }
        System.out.println();
    }
}
