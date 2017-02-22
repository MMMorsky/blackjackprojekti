package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.kayttoliittymakuuntelijat.NostaKuuntelija;
import blakjakprojekti.kayttoliittymakuuntelijat.JaaKuuntelija;
import blakjakprojekti.kayttoliittymakuuntelijat.AloitaKuuntelija;
import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

public class KayttoliittymanAsettelija {

    private Pelipoyta pelipoyta;
    private JPanel ulkoasu;
    private KortinValitsin kortinvalitsin;
    private JFormattedTextField panos;

    /**
     * Luo käyttöliittymän asettelijan.
     *
     * @param pelipoyta
     */
    public KayttoliittymanAsettelija(Pelipoyta pelipoyta) {
        this.pelipoyta = pelipoyta;
        this.ulkoasu = new JPanel(new GridLayout(0, 10));
        this.kortinvalitsin = new KortinValitsin(this.pelipoyta);
        this.panos = new JFormattedTextField();

    }

    /**
     * Asettelee käyttöliittymän komponentit.
     *
     * @return Palauttaa käyttöliittymän komponentit.
     */
    public void asettele() {
        ulkoasu.removeAll();

        for (int i = 0; i < 90; i++) {
            if (i == 0) {
                this.ulkoasu.add(luoAloitaPainike());
            } else if (i == 80) {
                this.ulkoasu.add(luoNostaPainike());
            } else if (i == 82) {
                this.ulkoasu.add(luoJaaPainike());
            } else if (i == 60 && !kortinvalitsin.palautaPelaajanKortit().isEmpty()) {
                for (JLabel jLabel : kortinvalitsin.palautaPelaajanKortit()) {
                    this.ulkoasu.add(jLabel);
                    i++;
                }
                i--;
            } else if (i == 40 && !kortinvalitsin.palautaJakajanKortit().isEmpty()) {
                for (JLabel jLabel : kortinvalitsin.palautaJakajanKortit()) {
                    this.ulkoasu.add(jLabel);
                    i++;
                }
                i--;
            } else if (i == 9 && pelipoyta.getPelinTila() == 2) {
                this.ulkoasu.add(new JLabel("Hävisit!"));
            } else if (i == 9 && pelipoyta.getPelinTila() == 3) {
                this.ulkoasu.add(new JLabel("Voitit!"));
            } else if (i == 9 && pelipoyta.getPelinTila() == 4) {
                this.ulkoasu.add(new JLabel("Tasapeli!"));
            } else if (i == 7) {
                this.ulkoasu.add(new JLabel("Valuutta:"));
            } else if (i == 8) {
                this.ulkoasu.add(new JLabel(Integer.toString(pelipoyta.getPelaaja().getRahamaara())));
            } else if (i == 4 && pelipoyta.getPelinTila() != 1) {
                this.ulkoasu.add(panos);
            } else if (i == 3 && pelipoyta.getPelinTila() != 1) {
                JLabel panos = new JLabel("Aseta panos:");
                panos.setFont(new Font("Arial", Font.PLAIN, 12));
                this.ulkoasu.add(panos);
            } else if (i == 30) {
                JLabel panos = new JLabel("Jakaja:");
                panos.setFont(new Font("Arial", Font.PLAIN, 15));
                this.ulkoasu.add(panos);
            } else if (i == 50) {
                JLabel panos = new JLabel("Pelaaja:");
                panos.setFont(new Font("Arial", Font.PLAIN, 15));
                this.ulkoasu.add(panos);
            } else {
                this.ulkoasu.add(new JLabel());
            }
        }

    }

    public JPanel getUlkoasu() {
        asettele();
        return ulkoasu;
    }

    public void paivita() {
        asettele();
        ulkoasu.revalidate();
        ulkoasu.repaint();
    }

    private JButton luoAloitaPainike() {
        JButton painike = new JButton("<html>Uusi<br>Kierros</html>");
        painike.setFont(new Font("Arial", Font.PLAIN, 15));
        painike.addActionListener(new AloitaKuuntelija(pelipoyta, this, panos));
        return painike;
    }

    private JButton luoNostaPainike() {
        JButton painike = new JButton("Nosta");
        painike.setFont(new Font("Arial", Font.PLAIN, 15));
        painike.addActionListener(new NostaKuuntelija(pelipoyta, this));
        return painike;
    }

    private JButton luoJaaPainike() {
        JButton painike = new JButton("Jää");
        painike.setFont(new Font("Arial", Font.PLAIN, 15));
        painike.addActionListener(new JaaKuuntelija(pelipoyta, this));
        return painike;
    }

}
