package blakjakprojekti.kayttoliittymakuuntelijat;

import blakjakprojekti.kayttoliittyma.KayttoliittymanAsettelija;
import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AloitaKuuntelija implements ActionListener {

    private Pelipoyta pelipoyta;
    private KayttoliittymanAsettelija asettelija;

    /**
     * Aloita napin kuuntelija.
     *
     * @param pelipoyta Ohjelman päälogiikka
     * @param asettelija Ohjelman asettelija, jolla päivitetään pelin näkymä.
     */
    public AloitaKuuntelija(Pelipoyta pelipoyta, KayttoliittymanAsettelija asettelija) {
        this.pelipoyta = pelipoyta;
        this.asettelija = asettelija;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (pelipoyta.getPelaaja().getRahamaara() >= pelipoyta.getPelaaja().getPanos()) {
            pelipoyta.uusiKierros();
            pelipoyta.aloita();
            pelipoyta.setPelinTila(1);
            asettelija.paivita();
        }
    }

}
