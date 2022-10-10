/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.compteur.model;
import fr.ufrsciencestech.panier.*;

import java.util.Observable;

/**
 *
 * @author celine
 */
public class Modele extends Observable{
    private int compteur;   //compteur toujours positif
    private int max;
    private Panier p;

    public Panier getPanier() {
        return p;
    }

    public void setPanier(Panier p) {
        this.p = p;
    }
    
    public Modele(){
        compteur = 0;
        max = 100;
    }
    
    public Modele(int c){
        compteur = c;
        max = 100;
    }
    
    public void update(int incr) {
        
        compteur += incr;
        if(compteur < 0)
            compteur = 0;
        if(compteur >=max)
            compteur = max;
        
        setChanged();                //marks this Observable object as having been changed; the hasChanged method will now return true
        notifyObservers(getCompteur());   //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed
    }

    /**
     * @return the compteur
     */
    public int getCompteur() {
        return compteur;
    }
    
    public void setMax(int c){
        max=c;
    }

    /**
     * @param compteur the compteur to set
     */
    public void setCompteur(int compteur) {
        this.compteur = compteur;
        if(this.compteur < 0)
            this.compteur = 0;
        if(this.compteur >= max)
            this.compteur = max;
        
        setChanged();                //marks this Observable object as having been changed; the hasChanged method will now return true
        notifyObservers(getCompteur());   //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed
    }
    
}
