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
public class VueIHM extends JFrame implements VueG {
    private JButton inc;
    private JButton dec;
    private JTextArea texte;
     private JComboBox<String> cbox;

   public VueIHM(){
       super("CompteurSwing");
       inc = new JButton("+");
       dec=new JButton("-");
       texte=new JTextArea();
       String[] fruits= new String[]{ "Orange","Pamplemousse","Mure" };
       cbox=new JComboBox(fruits);
       BoxLayout mainLayout=new BoxLayout(this,BoxLayout.X_AXIS);
      // this.setLayout(mainLayout);
       JPanel top=new JPanel();
       top.setLayout(new GridLayout(1,2));
       JButton test=new JButton("test");
       top.add(inc);
       top.add(cbox);
       
  
       add(top,BorderLayout.NORTH);
        add(dec, BorderLayout.SOUTH);
        add(texte, BorderLayout.CENTER);
        
        
       
        
        inc.setName("Plus");
        dec.setName("Moins");
        texte.setName("Affichage");
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
   public VueIHM(int c){
        super("CompteurSwing");
       inc = new JButton("+");
       dec=new JButton("-");
       texte=new JTextArea();
       String[] fruits= new String[]{ "Orange","Pamplemousse","Mure" };
       cbox=new JComboBox(fruits);
       BoxLayout mainLayout=new BoxLayout(this,BoxLayout.X_AXIS);
      // this.setLayout(mainLayout);
       JPanel top=new JPanel();
       top.setLayout(new GridLayout(1,2));
       JButton test=new JButton("test");
       top.add(inc);
       top.add(cbox);
       
  
       add(top,BorderLayout.NORTH);
        add(dec, BorderLayout.SOUTH);
        add(texte, BorderLayout.CENTER);
        
        inc.setName("Plus");
        dec.setName("Moins");
        texte.setName("Affichage");
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

    public void setAffiche(JTextArea affiche) {
        this.texte = affiche;
    }

    public JButton getDec() {
        return dec;
    }

    public JTextArea getAffiche() {
        return texte;
    }
    
    public JComboBox<String> getCombo(){
        return cbox;
    }
    
    public void setCombo(JComboBox<String> box){
        this.cbox=box;
    }
    
    @Override
    public void update(Observable m, Object compte){     //This method is called whenever the observed object is changed
  
        getAffiche().setText("Il y a "+((Integer) compte).toString()+" fruits");
        
        
    }
    
    @Override
     public void addControleur(Controler c){
        getInc().addActionListener(c);
        getDec().addActionListener(c);
    }
    
}
