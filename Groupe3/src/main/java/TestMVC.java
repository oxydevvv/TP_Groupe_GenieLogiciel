

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fr.ufrsciencestech.groupe3.controler.Controler;
import fr.ufrsciencestech.groupe3.view.*;
import fr.ufrsciencestech.groupe3.model.Modele;

//utilise pour springIoC :
import javax.swing.*;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author celine
 */
public class TestMVC {
    private VueG vueg;      //pour pouvoir changer de vue si on le souhaite
    private Controler controleur;  //pour pouvoir changer de controleur si on le souhaite
    public Modele modele;
    
    
    /**
     * @return the vueg
     */
    public VueG getVueg() {
        return vueg;
    }

    /**
     * @param vueg the vueg to set
     */
    public void setVueg(VueG vueg) {
        this.vueg = vueg;
    }

    /**
     * @return the controleur
     */
    public Controler getControleur() {
        return controleur;
    }

    /**
     * @param controleur the controleur to set
     */
    public void setControleur(Controler controleur) {
        this.controleur = controleur;
    }
    
    
    public TestMVC(){
        //sans utiliser SpringIoC :
        vueg = new Vue();
        controleur = new Controler();
        modele = new Modele();
        VueConsole vuec = new VueConsole();

        controleur.setModele(modele);                 
        modele.addObserver(vueg);        
        modele.addObserver(vuec);         
        vueg.addControleur(controleur);
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }
    
    public TestMVC(int c,int v){
        //sans utiliser SpringIoC :
        vueg = new VueIHM(c);
        controleur = new Controler();
        modele = new Modele(c);
        modele.setMax(v);
        VueConsole vuec = new VueConsole(c);;

        controleur.setModele(modele);                 
        modele.addObserver(vueg);        
        modele.addObserver(vuec);         
        vueg.addControleur(controleur);
    }
    
    public static void main(String[] args){
        //TestMVC test = new TestMVC();    //sans utiliser SpringIoC
        
        //La meme chose mais avec SpringIoC :
        /*ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TestMVC test = (TestMVC)context.getBean("MVC");  //SpringIoC
        test.setControleur( (Controler)context.getBean("Controleur") );  //SpringIoC
        test.setVueg( (VueG)context.getBean("Vue") );   //SpringIoC
         
        Modele m = new Modele(); 
        test.getControleur().setModele(m);  
        
        m.addObserver(test.getVueg());
        test.getVueg().addControleur(test.getControleur());
        
        VueConsole vuec = new VueConsole();
        m.addObserver(vuec);  */
    }
}
