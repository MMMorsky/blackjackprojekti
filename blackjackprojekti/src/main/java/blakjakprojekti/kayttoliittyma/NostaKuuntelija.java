package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NostaKuuntelija implements ActionListener {

    private Pelipoyta pelipoyta;

    /**
     * Luo Nosta painikkeen kuuntelijan.
     * @param pelipoyta Ottaa pelipöytä luokan.
     * 
     */
    public NostaKuuntelija(Pelipoyta pelipoyta) {
        this.pelipoyta = pelipoyta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
