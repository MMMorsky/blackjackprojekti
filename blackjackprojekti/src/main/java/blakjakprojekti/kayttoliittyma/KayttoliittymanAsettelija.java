package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.kayttoliittymakuuntelijat.NostaKuuntelija;
import blakjakprojekti.kayttoliittymakuuntelijat.JaaKuuntelija;
import blakjakprojekti.kayttoliittymakuuntelijat.AloitaKuuntelija;
import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KayttoliittymanAsettelija {

    private Pelipoyta pelipoyta;
    private JPanel ulkoasu;
    private KortinValitsin kortinvalitsin;

    /**
     * Luo käyttöliittymän asettelijan.
     *
     * @param pelipoyta
     */
    public KayttoliittymanAsettelija(Pelipoyta pelipoyta) {
        this.pelipoyta = pelipoyta;
        this.ulkoasu = new JPanel(new GridLayout(0, 10));
        this.kortinvalitsin = new KortinValitsin(this.pelipoyta);
    }

    /**
     * Asettelee käyttöliittymän komponentit.
     *
     * @return Palauttaa käyttöliittymän komponentit.
     */
    public void asettele() {
        ulkoasu.removeAll();

        for (int i = 0; i < 100; i++) {
            if (i == 0) {
                this.ulkoasu.add(luoAloitaPainike());
            } else if (i == 90) {
                this.ulkoasu.add(luoNostaPainike());
            } else if (i == 92) {
                this.ulkoasu.add(luoJaaPainike());
            } else if (i == 70 && !kortinvalitsin.palautaPelaajanKortit().isEmpty()) {
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
        JButton painike = new JButton("Aloita");
        painike.setFont(new Font("Arial", Font.PLAIN, 15));
        painike.addActionListener(new AloitaKuuntelija(pelipoyta, this));
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
