package blakjakprojekti;

import blakjakprojekti.kayttoliittyma.Gui;
import blakjakprojekti.logiikka.Pelipoyta;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        
        Pelipoyta pelipoyta = new Pelipoyta();
        Gui gui = new Gui(pelipoyta);
        SwingUtilities.invokeLater(gui);
//        Scanner lukija = new Scanner(System.in);
//        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lukija);
//        kayttoliittyma.kaynnista();
    }

}
