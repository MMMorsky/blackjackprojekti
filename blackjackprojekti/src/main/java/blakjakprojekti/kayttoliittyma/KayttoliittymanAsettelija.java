package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.kayttoliittymakuuntelijat.NostaKuuntelija;
import blakjakprojekti.kayttoliittymakuuntelijat.JaaKuuntelija;
import blakjakprojekti.kayttoliittymakuuntelijat.AloitaKuuntelija;
import blakjakprojekti.kayttoliittymakuuntelijat.LainaaKuuntelija;
import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
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
     * @param pelipoyta Pelipöydän toiminnallisuus
     */
    public KayttoliittymanAsettelija(Pelipoyta pelipoyta) {
        this.pelipoyta = pelipoyta;
        this.ulkoasu = new JPanel(new GridLayout(0, 10));
        this.kortinvalitsin = new KortinValitsin(this.pelipoyta);

    }

    /**
     * Asettelee käyttöliittymän komponentit.
     *
     *
     */
    public void asettele() {
        ulkoasu.removeAll();
        ulkoasu.setBackground(new Color(105, 233, 41));

        for (int i = 0; i < 90; i++) {
            if (i == 0 && pelipoyta.getPelinTila() != 1 && pelipoyta.getPelaaja().getPanos() != 0) {
                this.ulkoasu.add(luoAloitaPainike());
            } else if (i == 3 && pelipoyta.getPelinTila() != 1) {
                JLabel panos = new JLabel("Aseta panos:");
                panos.setFont(new Font("Arial", Font.PLAIN, 12));
                this.ulkoasu.add(panos);
            } else if (i == 4 && pelipoyta.getPelinTila() != 1) {
                this.ulkoasu.add(new JLabel(Integer.toString(pelipoyta.getPelaaja().getPanos())));
            } else if (i == 5) {
                this.ulkoasu.add(new PanostajaNappi(pelipoyta, this));
            } else if (i == 6 && pelipoyta.getPelaaja().getPanos() != 0) {
                this.ulkoasu.add(luoNollaaPainike());
            } else if (i == 7) {
                this.ulkoasu.add(new JLabel("Valuutta:"));
            } else if (i == 8) {
                this.ulkoasu.add(new JLabel(Integer.toString(pelipoyta.getPelaaja().getRahamaara())));
            } else if (i == 9) {
                this.ulkoasu.add(luoPelinTilaIlmoitus());
            } else if (i == 30 && pelipoyta.getPelinTila() != 0) {
                JLabel panos = new JLabel("Jakaja:");
                panos.setFont(new Font("Arial", Font.PLAIN, 15));
                this.ulkoasu.add(panos);
            } else if (i == 40 && !kortinvalitsin.palautaJakajanKortit().isEmpty()) {
                for (JLabel jLabel : kortinvalitsin.palautaJakajanKortit()) {
                    this.ulkoasu.add(jLabel);
                    i++;
                }
                i--;
            } else if (i == 50 && pelipoyta.getPelinTila() != 0) {
                JLabel panos = new JLabel("Pelaaja:");
                panos.setFont(new Font("Arial", Font.PLAIN, 15));
                this.ulkoasu.add(panos);
            } else if (i == 60 && !kortinvalitsin.palautaPelaajanKortit().isEmpty()) {
                for (JLabel jLabel : kortinvalitsin.palautaPelaajanKortit()) {
                    this.ulkoasu.add(jLabel);
                    i++;
                }
                i--;
            } else if (i == 80 && pelipoyta.getPelinTila() == 1) {
                this.ulkoasu.add(luoNostaPainike());
            } else if (i == 82 && pelipoyta.getPelinTila() == 1) {
                this.ulkoasu.add(luoJaaPainike());
            } else if (i == 89) {
                if (pelipoyta.getPelaaja().getRahamaara() <= 100 && pelipoyta.getPelinTila() != 1) {
                    this.ulkoasu.add(luoLainaaPainike());
                }
            } else {
                this.ulkoasu.add(new JLabel());
            }
        }

    }

    /**
     * Palauttaa ulkoasun käyttöliittymälle.
     *
     * @return palauttaa ulkoasun
     */
    public JPanel getUlkoasu() {
        asettele();
        return ulkoasu;
    }

    /**
     * Päivittää ulkoasun.
     */
    public void paivita() {
        asettele();
        ulkoasu.revalidate();
        ulkoasu.repaint();
    }

    private JPanel luoNollaaPainike() {
        JPanel nollaa = new JPanel(new GridLayout(3, 1));
        nollaa.setBackground(new Color(105, 233, 41));
        JButton nolla = new JButton(new AbstractAction("Nollaa") {
            @Override
            public void actionPerformed(ActionEvent e) {
                pelipoyta.getPelaaja().setPanos(0);
                paivita();
            }
        });
        if (pelipoyta.getPelinTila() != 1) {
            nolla.setFont(new Font("Arial", Font.PLAIN, 15));
            nollaa.add(nolla);
        }

        return nollaa;
    }

    private JButton luoAloitaPainike() {
        JButton painike = new JButton("<html>Uusi<br>Kierros</html>");
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

    private JButton luoLainaaPainike() {

        JButton painike = new JButton("<html>Lainaa<br>kaverilta</html>");
        painike.setFont(new Font("Arial", Font.PLAIN, 15));
        painike.addActionListener(new LainaaKuuntelija(pelipoyta, this));
        return painike;
    }

    private JLabel luoPelinTilaIlmoitus() {
        if (pelipoyta.getPelinTila() == 2) {
            return new JLabel("Hävisit!");
        } else if (pelipoyta.getPelinTila() == 3) {
            return new JLabel("Voitit!");
        } else if (pelipoyta.getPelinTila() == 4) {
            return new JLabel("Tasapeli!");
        } else if (pelipoyta.getPelinTila() == 5) {
            return new JLabel("Blackjack!");
        } else {
            return new JLabel();
        }
    }

}
