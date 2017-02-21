package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.logiikka.Kortti;
import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class KortinValitsin {

    private Pelipoyta pelipoyta;

    public KortinValitsin(Pelipoyta pelipoyta) {
        this.pelipoyta = pelipoyta;
    }

    public JLabel palautaKuva() {
        BufferedImage kuva = null;

        try {
            kuva = ImageIO.read(new File("HERTTA1.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Gui.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JLabel picLabel = new JLabel(new ImageIcon(kuva));
        return picLabel;
    }

    public List<JLabel> palautaPelaajanKortit() {
        List<JLabel> pelaajankuvat = new ArrayList<>();

        
        BufferedImage kuva = null;
        for (Kortti kortti : pelipoyta.getPelaaja().getKortit()) {
            try {
                kuva = ImageIO.read(new File(kortti.palautaTiedostopaate()));
            } catch (IOException ex) {
                Logger.getLogger(Gui.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            JLabel picLabel = new JLabel(new ImageIcon(kuva));
            pelaajankuvat.add(picLabel);
        }

        return pelaajankuvat;
    }
}
