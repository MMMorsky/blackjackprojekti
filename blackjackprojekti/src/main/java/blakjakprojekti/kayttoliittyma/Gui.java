package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Gui implements Runnable {

    private JFrame frame;
    private Pelipoyta pelipoyta;

    public Gui(Pelipoyta pelipoyta) {
        this.pelipoyta = pelipoyta;
    }

    @Override
    public void run() {
        frame = new JFrame("BlackJackPeli");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(luoPainikkeet(), BorderLayout.SOUTH);
        
    }
    
    private JPanel luoPainikkeet() {
        JPanel panel = new JPanel(new GridLayout(1,2));
        panel.add(new JButton("Nosta"));
        panel.add(new JButton("Jää"));
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}