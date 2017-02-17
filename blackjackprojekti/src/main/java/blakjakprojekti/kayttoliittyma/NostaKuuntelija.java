package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NostaKuuntelija implements ActionListener {

    private Container container;
    private Pelipoyta pelipoyta;

    /**
     * Luo Nosta painikkeen kuuntelijan.
     * @param pelipoyta Ottaa pelipöytä luokan.
     * @param container Ottaa container viitteen.
     */
    public NostaKuuntelija(Pelipoyta pelipoyta, Container container) {
        this.container = container;
        this.pelipoyta = pelipoyta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
