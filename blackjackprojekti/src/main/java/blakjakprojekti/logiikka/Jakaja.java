package blakjakprojekti.logiikka;

import java.util.ArrayList;
import java.util.List;

public class Jakaja extends Toimija {

    public boolean nostaakoJakaja() {
        int temp1 = 0;
        int temp2 = 0;
        for (Integer arvo : palautaPisteet()) {
            if (arvo > 16) {
                temp1++;
                temp2++;
            } else {
                temp1++;
            }
        }

        if (temp1 == 1 && temp2 == 1 ) {
            return false;
        } else if (temp1 == 2 && temp2 == 2) {
            return false;
        } else if (temp1 == 0 && temp2 == 0) {
            return false;
        }
        return true;
    }

}
