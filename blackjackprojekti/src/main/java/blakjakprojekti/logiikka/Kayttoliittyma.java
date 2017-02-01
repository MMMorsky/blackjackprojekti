package blakjakprojekti.logiikka;

import java.util.Scanner;

public class Kayttoliittyma {

    private Scanner lukija;
    private Pelipoyta pelipoyta;

    public Kayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
    }

    public void kaynnista() {
        this.pelipoyta = new Pelipoyta();
        pelipoyta.aloita();

        System.out.println("Omat kortit: ");
        for (Kortti kortti : pelipoyta.getPelaaja().getKortit()) {
            System.out.println(kortti);
        }

        System.out.println("Jakajan kortit: ");
        System.out.println(pelipoyta.getJakaja().getKortit().get(0));
        System.out.println("-----");

        System.out.println("");

        tulostaPisteet();

        pelaajanNosto();

        while (true) {

            jakajanNosto();
            if (pelipoyta.getJakaja().meneekoYli()) {
                break;
            }
            tulostaKortit();
            tulostaPisteet();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }





    }

    public void jakajanNosto() {
        System.out.println("Jakaja Nostaa");
        System.out.println();
        pelipoyta.jakajaNostaa();



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
