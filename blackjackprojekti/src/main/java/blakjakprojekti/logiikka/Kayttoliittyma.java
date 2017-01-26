
package blakjakprojekti.logiikka;

import java.util.Scanner;


public class Kayttoliittyma {
    private Scanner lukija;

    public Kayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
    }
    
    public void kaynnista() {
        Pelipoyta pelipoyta = new Pelipoyta();
        pelipoyta.aloita();
        
        System.out.println("Omat kortit: ");
        for (Kortti kortti : pelipoyta.getPelaaja().getKortit()) {
            System.out.println(kortti);
        }
        
        System.out.println("Jakajan kortit: ");
        

    }
}
