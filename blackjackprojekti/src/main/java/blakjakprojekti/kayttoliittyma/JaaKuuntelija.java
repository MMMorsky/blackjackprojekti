package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JaaKuuntelija implements ActionListener {

    private Container container;
    private Pelipoyta pelipoyta;

    
    /**
     * Luo Jää napin kuuntelija.
     * @param pelipoyta Vastaanottaa logiikan.
     * @param container Vastaanottaa containerin.
     */
    public JaaKuuntelija(Pelipoyta pelipoyta, Container container) {
        this.container = container;
        this.pelipoyta = pelipoyta;
    }

    /**
     * Jää kuuntelijan painikkeen toiminta.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
