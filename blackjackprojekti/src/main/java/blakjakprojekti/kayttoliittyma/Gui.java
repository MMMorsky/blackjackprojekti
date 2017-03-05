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
     *
     * @param pelipoyta Pelipöydän toiminnallisuus
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
        frame.setResizable(false);
    }

    private void luoKomponentit(Container container) {

        container.add(kayttoliittymanAsettelija.getUlkoasu());

    }

    public JFrame getFrame() {
        return frame;
    }
}
