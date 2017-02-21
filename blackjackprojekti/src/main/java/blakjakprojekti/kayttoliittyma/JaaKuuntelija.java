package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JaaKuuntelija implements ActionListener {

    private Pelipoyta pelipoyta;

    
    /**
     * Luo Jää napin kuuntelija.
     * @param pelipoyta Vastaanottaa logiikan.
     * @param container Vastaanottaa containerin.
     */
    public JaaKuuntelija(Pelipoyta pelipoyta) {
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
