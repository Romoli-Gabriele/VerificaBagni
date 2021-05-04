/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagni;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author informatica
 */
public class Persona extends Thread{
    String nome; //nome per distingure le persone
    String genere;// genere per capire in che bagno deve andare
    Bagno uomini;//entrambi i bagni
    Bagno donne;

    public Persona(String genere, Bagno donne, Bagno uomini, String name) {
        this.genere = genere;
        this.donne = donne;
        this.uomini = uomini;
        nome = name;
    }
    
    
    @Override
    public void run() {
        
        if("uomini".equals(genere)){//se è un uomo va nel bagno degli uomini
            try {
                uomini.controllo.acquire();//controlla se il bagno è libero altrimanti si mette in coda
                uomini.utilizza(this);//la persona entra nel bagno
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
            uomini.controllo.release();//la persona esce dal bagno e permette agli altri di entrare
        }else{//altrimenti va in quello delle donne
            try {
                donne.controllo.acquire();
                donne.utilizza(this);
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
            donne.controllo.release();
            
        }
    
    
    }
}