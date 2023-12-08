/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import java.util.Random;

/**
 * Classe Event to Créate differnet Event random in the gamme
 */
public class Event {
    // EVENT METHODS
    public void startEvent(PlayerHand player){
        Random rand = new Random();
        int event = rand.nextInt(5);
        switch (event) {
            case 0 -> witchHunt();
            case 1 -> inflation();
            case 2 -> economicProsperity();
            case 3 -> storm();
            case 4 -> revolution();
        }
    }
    void witchHunt(){}
    void inflation(){}
    void economicProsperity(){}
    void storm(){}
    void revolution(){}
    // EVENT METHODS
}
