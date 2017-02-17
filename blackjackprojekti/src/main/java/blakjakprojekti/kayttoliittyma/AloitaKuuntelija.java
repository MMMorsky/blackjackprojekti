package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AloitaKuuntelija implements ActionListener {

    private Container container;
    private Pelipoyta pelipoyta;

    /**
     * Luo kuuntelijan.
     * @param pelipoyta 
     * @param container 
     */
    public AloitaKuuntelija(Pelipoyta pelipoyta, Container container) {
        this.container = container;
        this.pelipoyta = pelipoyta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
