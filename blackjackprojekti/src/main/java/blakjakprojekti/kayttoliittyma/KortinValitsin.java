package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.logiikka.Kortti;
import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class KortinValitsin {

    private Pelipoyta pelipoyta;

    /**
     * Tämä luokka valitsee käyttöliittymälle, oikean kuvan vastaamaan korttia.
     * @param pelipoyta Ohjelman toiminnallisuus
     */
    public KortinValitsin(Pelipoyta pelipoyta) {
        this.pelipoyta = pelipoyta;
    }

    
    /**
     * Palauttaa pelaajan kortit kuvina.
     * @return Palauttaa kortit listana JLabeleita
     */
    public List<JLabel> palautaPelaajanKortit() {
        List<JLabel> pelaajankuvat = new ArrayList<>();

        BufferedImage kuva = null;
        for (Kortti kortti : pelipoyta.getPelaaja().getKortit()) {
            InputStream is = getClass().getClassLoader().getResourceAsStream("kortit/" + kortti.palautaTiedostopaate());
            try {
                kuva = ImageIO.read(is);
            } catch (IOException ex) {
                Logger.getLogger(KortinValitsin.class.getName()).log(Level.SEVERE, null, ex);
            }

            JLabel picLabel = new JLabel(new ImageIcon(kuva));
            pelaajankuvat.add(picLabel);
        }

        return pelaajankuvat;
    }

    /**
     * Palauttaa jakajankortit kuvina.
     * @return Palautuu JLabel listana
     */
    public List<JLabel> palautaJakajanKortit() {
        List<JLabel> jakajankuvat = new ArrayList<>();

        BufferedImage kuva = null;
        for (Kortti kortti : pelipoyta.getJakaja().getKortit()) {
            InputStream is = getClass().getClassLoader().getResourceAsStream("kortit/" + kortti.palautaTiedostopaate());
            try {
                kuva = ImageIO.read(is);
            } catch (IOException ex) {
                Logger.getLogger(KortinValitsin.class.getName()).log(Level.SEVERE, null, ex);
            }

            JLabel picLabel = new JLabel(new ImageIcon(kuva));
            jakajankuvat.add(picLabel);
        }

        return jakajankuvat;
    }
}
