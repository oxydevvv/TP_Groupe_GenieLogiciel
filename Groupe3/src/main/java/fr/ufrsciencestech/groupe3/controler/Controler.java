package fr.ufrsciencestech.groupe3.controler;

import fr.ufrsciencestech.groupe3.view.*;
import fr.ufrsciencestech.groupe3.model.*;
import java.awt.*;
import java.awt.event.*;



public class Controler implements ActionListener {
    private Modele m;
    private VueIHM vg;

    public Modele getModele() {
        return m;
    }

    public void setModele(Modele m) {
        this.m = m;
    }

    public VueIHM getVg() {
        return vg;
    }

    public void setVg(VueIHM vg) {
        this.vg = vg;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){   //Invoked when an action occurs
        if(((Component)e.getSource()).getName().equals("Plus")) 
            m.update(1);
        else
            m.update(-1); 
    }
    
    
}
