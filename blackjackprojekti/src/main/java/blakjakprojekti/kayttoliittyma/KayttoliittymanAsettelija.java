package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KayttoliittymanAsettelija {

    private Container container;
    private Pelipoyta pelipoyta;

    
    /**
     * Luo käyttöliittymän asettelijan.
     * @param pelipoyta 
     */
    public KayttoliittymanAsettelija(Pelipoyta pelipoyta) {
        this.pelipoyta = pelipoyta;
    }
    
    /**
     * Asettelee käyttöliittymän komponentit.
     * @return Palauttaa käyttöliittymän komponentit.
     */
    public JPanel asettele() {

        JPanel p = new JPanel(new GridLayout(0, 10));
        for (int i = 0; i < 100; i++) {
            if (i == 0) {
                p.add(luoAloitaPainike(container));
            } else if (i == 90) {
                p.add(luoNostaPainike(container));
            } else if (i == 92) {
                p.add(luoJaaPainike(container));
            } else {
                p.add(new JLabel());
            }
        }
        return p;
    }

    private JButton luoAloitaPainike(Container container) {
        JButton painike = new JButton("Aloita");
        painike.setFont(new Font("Arial", Font.PLAIN, 15));
        painike.addActionListener(new AloitaKuuntelija(pelipoyta, container));
        return painike;
    }

    private JButton luoNostaPainike(Container container) {
        JButton painike = new JButton("Nosta");
        painike.setFont(new Font("Arial", Font.PLAIN, 15));
        painike.addActionListener(new NostaKuuntelija(pelipoyta, container));
        return painike;
    }

    private JButton luoJaaPainike(Container container) {
        JButton painike = new JButton("Jää");
        painike.setFont(new Font("Arial", Font.PLAIN, 15));
        painike.addActionListener(new JaaKuuntelija(pelipoyta, container));
        return painike;
    }

}
