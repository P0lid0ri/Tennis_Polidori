/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tennis_polidori;

/**
 *
 * @author GABRIELE
 */
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tennis_Polidori {

    public static void main(String[] args) {
// Creazione dei giocatori
        Giocatore g1 = new Giocatore(1, "Pippo");
        Giocatore g2 = new Giocatore(2, "Pluto");

// Avvio dei thread dei giocatori
        g1.start();
        g2.start();

// Attesa che i thread dei giocatori terminino
        try {
            g1.join();
            g2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tennis_Polidori.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore join");
        }

        System.out.println("Partita finita!");
    }
}
