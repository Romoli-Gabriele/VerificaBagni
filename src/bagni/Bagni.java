/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagni;
import java.util.concurrent.Semaphore;
/**
 *
 * @author informatica
 */
public class Bagni {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    Semaphore U = new Semaphore(1);//un semaforo per genere
    Semaphore D = new Semaphore(1);
    
    Bagno Man = new Bagno("uomini", U);//un bagno per genere
    Bagno Women = new Bagno("donne", D);
    
    Persona u1 = new Persona("uomini",Women,Man,"Giovanni");//tutte le persone
    Persona u2 = new Persona("uomini",Women,Man, "Dante");
    Persona u3 = new Persona("uomini",Women,Man, "Raffaele");
    Persona d1 = new Persona("donne",Women,Man,"Maria");
    Persona d2 = new Persona("donne",Women,Man,"Giulia");
    Persona d3 = new Persona("donne",Women,Man,"Gertrude");
    
    u1.start();
    u2.start();
    u3.start();
    d1.start();
    d2.start();
    d3.start();
    
    }
    
    
}
