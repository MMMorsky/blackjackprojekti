
package blakjakprojekti.logiikka;

import java.util.Collections;
import java.util.List;

public class Korttipakka {
    private List<Kortti> kortit;

    public Korttipakka() {
        
    }
    
    public void sekoita() {
        Collections.shuffle(this.kortit);
    }
    
    
}
