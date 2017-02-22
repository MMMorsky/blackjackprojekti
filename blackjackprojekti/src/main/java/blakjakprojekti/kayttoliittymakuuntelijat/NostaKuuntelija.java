package blakjakprojekti.kayttoliittymakuuntelijat;

import blakjakprojekti.kayttoliittyma.KayttoliittymanAsettelija;
import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NostaKuuntelija implements ActionListener {

    private Pelipoyta pelipoyta;
    private KayttoliittymanAsettelija asettelija;

    /**
     * Luo Nosta painikkeen kuuntelijan.
     *
     * @param pelipoyta Ottaa pelipöytä luokan.
     *
     */
    public NostaKuuntelija(Pelipoyta pelipoyta, KayttoliittymanAsettelija asettelija) {
        this.pelipoyta = pelipoyta;
        this.asettelija = asettelija;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pelipoyta.getPelinTila()  == 1) {
            pelipoyta.pelaajaNostaa();
            if (pelipoyta.getPelaaja().meneekoYli()) {
                pelipoyta.setPelinTila(2);
            }
        }
        asettelija.paivita();

    }

}
