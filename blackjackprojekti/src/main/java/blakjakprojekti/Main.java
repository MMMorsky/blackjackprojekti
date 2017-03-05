package blakjakprojekti;

import blakjakprojekti.kayttoliittyma.Gui;
import blakjakprojekti.logiikka.Pelipoyta;
import javax.swing.SwingUtilities;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Pelipoyta pelipoyta = new Pelipoyta();
        Gui gui = new Gui(pelipoyta);
        SwingUtilities.invokeLater(gui);
    }

}
