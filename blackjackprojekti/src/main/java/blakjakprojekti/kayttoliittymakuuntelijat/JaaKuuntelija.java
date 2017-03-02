package blakjakprojekti.kayttoliittymakuuntelijat;

import blakjakprojekti.kayttoliittyma.KayttoliittymanAsettelija;
import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class JaaKuuntelija implements ActionListener {

    private Pelipoyta pelipoyta;
    private KayttoliittymanAsettelija asettelija;

    /**
     * Luo jakajan Jakamis painikkeen.
     *
     * @param pelipoyta Ohjelman päälogiikka.
     * @param asettelija Ohjelman käyttöliittymän päivittäjä.
     */
    public JaaKuuntelija(Pelipoyta pelipoyta, KayttoliittymanAsettelija asettelija) {
        this.pelipoyta = pelipoyta;
        this.asettelija = asettelija;
    }

    /**
     * Jää kuuntelijan painikkeen toiminta.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {        

        while (pelipoyta.getPelinTila() == 1) {
            if (pelipoyta.nostaakoJakaja()) {
                pelipoyta.jakajaNostaa();
            }
            if (pelipoyta.getJakaja().meneekoYli()) {
                pelipoyta.setPelinTila(3);
            } else if (pelipoyta.kenellaEnitenPisteita() == 3) {
                pelipoyta.setPelinTila(2);
            } else if (pelipoyta.kenellaEnitenPisteita() == 1 && !pelipoyta.nostaakoJakaja()) {
                pelipoyta.setPelinTila(3);
            } else if (pelipoyta.kenellaEnitenPisteita() == 2) {
                pelipoyta.setPelinTila(4);
            }
            
            asettelija.paivita();
           
        }
    }

}
