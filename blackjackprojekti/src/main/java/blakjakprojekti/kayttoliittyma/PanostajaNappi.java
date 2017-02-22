
package blakjakprojekti.kayttoliittyma;

import blakjakprojekti.logiikka.Pelipoyta;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanostajaNappi extends JPanel{
    
    private Pelipoyta pelipoyta;
    private KayttoliittymanAsettelija asettelija;

    public PanostajaNappi(Pelipoyta pelipoyta, KayttoliittymanAsettelija asettelija) {
        super(new GridLayout(3, 1));
        this.pelipoyta = pelipoyta;
        this.asettelija = asettelija;
        luoKomponentit();
    }


    
    private void luoKomponentit() {
        setBackground(new Color(105, 233, 41));
        JButton sata = new JButton(new AbstractAction("100") {
            @Override
            public void actionPerformed(ActionEvent e) {
                pelipoyta.getPelaaja().panosta100();
                asettelija.paivita();
            }
        });
        JButton kakssataa = new JButton(new AbstractAction("200") {
            @Override
            public void actionPerformed(ActionEvent e) {
                pelipoyta.getPelaaja().panosta200();
                asettelija.paivita();
            }
        });

        JButton viiskyt = new JButton(new AbstractAction("50") {
            @Override
            public void actionPerformed(ActionEvent e) {
                pelipoyta.getPelaaja().panosta50();
                asettelija.paivita();
            }
        });
        if (pelipoyta.getPelinTila() != 1) {
            if (pelipoyta.getPelaaja().getRahamaara() - pelipoyta.getPelaaja().getPanos() - 50 >= 0) {
                add(viiskyt);
            }
            if (pelipoyta.getPelaaja().getRahamaara() - pelipoyta.getPelaaja().getPanos() - 100 >= 0) {
                add(sata);
            }
            if (pelipoyta.getPelaaja().getRahamaara() - pelipoyta.getPelaaja().getPanos() - 200 >= 0) {
                add(kakssataa);
            }
        }
    }
}
