/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagni;
import java.util.concurrent.Semaphore;
import java.lang.Math;

/**
 *
 * @author informatica
 */
public class Bagno {
    private String genere;// Uomini o Donne
    public Semaphore controllo;//ogni bagno ha il suo semaforo e la sua coda

    public Bagno(String genere, Semaphore con) {
        this.genere = genere;
        controllo = con;
    }
    
    public void utilizza(Persona t) throws InterruptedException{
        System.out.println("Il bagno degli/lle "+genere+" è occupato da "+t.nome+"\n");
        t.sleep((long) (Math.random()*10000));//tempo di utilizzo del bagno randomico
        System.out.print(t.nome+" è uscito/a dal bagno\n");
    }
}
