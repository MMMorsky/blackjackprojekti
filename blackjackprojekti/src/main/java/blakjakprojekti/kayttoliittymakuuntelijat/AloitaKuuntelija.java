package blakjakprojekti.kayttoliittymakuuntelijat;

import blakjakprojekti.kayttoliittyma.KayttoliittymanAsettelija;
import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

public class AloitaKuuntelija implements ActionListener {

    private Pelipoyta pelipoyta;
    private KayttoliittymanAsettelija asettelija;
    private JFormattedTextField panos;

    /**
     * Luo kuuntelijan.
     *
     * @param pelipoyta
     *
     */
    public AloitaKuuntelija(Pelipoyta pelipoyta, KayttoliittymanAsettelija asettelija, JFormattedTextField panos) {
        this.pelipoyta = pelipoyta;
        this.asettelija = asettelija;
        this.panos = panos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (panos.getText().matches("[0-9]+")) {
            pelipoyta.getPelaaja().setPanos(Integer.parseInt(panos.getText()));
            pelipoyta.uusiKierros();
            pelipoyta.aloita();
            pelipoyta.setPelinTila(1);
        } else {
            panos.setText("Uusi Yritys");
        }
        asettelija.paivita();
    }

}
