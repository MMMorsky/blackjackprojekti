package blakjakprojekti.kayttoliittymakuuntelijat;

import blakjakprojekti.kayttoliittyma.KayttoliittymanAsettelija;
import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LainaaKuuntelija implements ActionListener {

    private Pelipoyta pelipoyta;
    private KayttoliittymanAsettelija asettelija;

    /**
     * Luo Nosta painikkeen kuuntelijan.
     *
     * @param pelipoyta Ottaa pelipöytä luokan.
     *
     */
    public LainaaKuuntelija(Pelipoyta pelipoyta, KayttoliittymanAsettelija asettelija) {
        this.pelipoyta = pelipoyta;
        this.asettelija = asettelija;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pelipoyta.getPelaaja().setRahamaara(pelipoyta.getPelaaja().getRahamaara() + 500);
        pelipoyta.getPelaaja().setPanos(0);
        asettelija.paivita();

    }

}
