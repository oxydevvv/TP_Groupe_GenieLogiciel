package fr.ufrsciencestech.compteur.view;

import fr.ufrsciencestech.compteur.controler.Controler;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author te131323
 */
public interface VueG extends Observer {
    @Override
    public void update(Observable m, Object o);
    public void addControleur(Controler c);
    
}
