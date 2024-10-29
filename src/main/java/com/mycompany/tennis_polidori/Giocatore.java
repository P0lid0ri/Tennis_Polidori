/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tennis_polidori;

/**
 *
 * @author GABRIELE
 */
import java.util.logging.Level;
import java.util.logging.Logger;

public class Giocatore extends Thread {

    private static boolean pallaInGioco = true; // Variabile condivisa per simulare la palla
    private static int turnoGiocatore = 1; // Variabile per il turno del giocatore
    private int idGiocatore;
    private String nomeGiocatore;
    private int palleggi;

    public Giocatore(int idGiocatore, String nomeGiocatore) {
        this.idGiocatore = idGiocatore;
        this.nomeGiocatore = nomeGiocatore;
        this.palleggi = 0;
    }

    @Override
    public void run() {
// Ciclo infinito o finito (cambialo a piacere)
        while (palleggi < 10 && pallaInGioco) {
// Controlla se è il turno di questo giocatore
            if (turnoGiocatore == idGiocatore) {
                palleggi++;
                System.out.println(nomeGiocatore + " (Giocatore " + idGiocatore + ") ha fatto il palleggio " + palleggi);

// Simula il tempo del palleggio
                try {
                    Thread.sleep(1000); // Pausa di 1 secondo
                } catch (InterruptedException ex) {
                    Logger.getLogger(Giocatore.class.getName()).log(Level.SEVERE, null, ex);
                }

// Passa la palla all'altro giocatore
                turnoGiocatore = (idGiocatore == 1) ? 2 : 1;

// Usa yield per cedere il controllo al prossimo giocatore
                Thread.yield();
            }
        }

// Se il ciclo è finito, termina il gioco
        if (palleggi >= 10) {
            pallaInGioco = false;
            System.out.println("Giocatore " + idGiocatore + " ha terminato i palleggi!");
        }
    }
}
