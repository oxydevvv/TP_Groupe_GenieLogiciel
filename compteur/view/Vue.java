package fr.ufrsciencestech.compteur.view;

import fr.ufrsciencestech.compteur.controler.Controler;
import java.awt.*;
import javax.swing.*;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class Vue extends JFrame implements VueG {
    private JButton inc;
    private JButton dec;
    private JLabel affiche;
    private JComboBox<String> cbox;

   public Vue(){
       super("CompteurSwing");
       inc = new JButton("+");
       dec=new JButton("-");
       affiche=new JLabel("0",JLabel.CENTER);
       String[] fruits= new String[]{ "Orange","Pamplemousse","Mure" };
       cbox=new JComboBox(fruits);
       
       add(inc, BorderLayout.NORTH);
        add(dec, BorderLayout.SOUTH);
        add(affiche, BorderLayout.CENTER);
        
        inc.setName("Plus");
        dec.setName("Moins");
        affiche.setName("Affichage");
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
   public Vue(int c){
       super("CompteurSwing");
       inc = new JButton("+");
       dec=new JButton("-");
       affiche=new JLabel(""+c,JLabel.CENTER);
       String[] fruits= new String[]{"Orange","Pamplemousse","Mure"};
       cbox=new JComboBox(fruits);
       
       add(inc, BorderLayout.NORTH);
       add(cbox,BorderLayout.NORTH);
        add(dec, BorderLayout.SOUTH);
        add(affiche, BorderLayout.CENTER);
        
        inc.setName("Plus");
        dec.setName("Moins");
        affiche.setName("Affichage");
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton getInc() {
        return inc;
    }

    public void setInc(JButton inc) {
        this.inc = inc;
    }

    public void setDec(JButton dec) {
        this.dec = dec;
    }

    public void setAffiche(JLabel affiche) {
        this.affiche = affiche;
    }

    public JButton getDec() {
        return dec;
    }

    public JLabel getAffiche() {
        return affiche;
    }
    
    public JComboBox<String> getCombo(){
        return cbox;
    }
    
    public void setCombo(JComboBox<String> box){
        this.cbox=box;
    }
    
    @Override
    public void update(Observable m, Object compte){     //This method is called whenever the observed object is changed
        getAffiche().setText(((Integer) compte).toString());
    }
    
     public void addControleur(Controler c){
        getInc().addActionListener(c);
        getDec().addActionListener(c);
    }
    
}
