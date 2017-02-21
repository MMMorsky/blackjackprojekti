package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import static sun.misc.ClassFileTransformer.add;

public class Gui implements Runnable {

    private JFrame frame;
    private Pelipoyta pelipoyta;
    private KayttoliittymanAsettelija kayttoliittymanAsettelija;

    /**
     * Luo käyttöliittymän.
     * @param pelipoyta 
     */
    public Gui(Pelipoyta pelipoyta) {
        this.pelipoyta = pelipoyta;
        this.kayttoliittymanAsettelija = new KayttoliittymanAsettelija(pelipoyta);
    }

    @Override
    public void run() {
        frame = new JFrame("BlackJackPeli");
        frame.setPreferredSize(new Dimension(750, 750));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {

        container.add(kayttoliittymanAsettelija.getUlkoasu());

    }

    private JLabel luoKortti() {
        BufferedImage kuva = null;
        try {
            kuva = ImageIO.read(new File("testikuva.gif"));
        } catch (IOException ex) {
            Logger.getLogger(Gui.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JLabel picLabel = new JLabel(new ImageIcon(kuva));
        return picLabel;
    }

    private JPanel luoPainikkeet() {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JButton("Nosta"));
        panel.add(new JButton("Jää"));

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
