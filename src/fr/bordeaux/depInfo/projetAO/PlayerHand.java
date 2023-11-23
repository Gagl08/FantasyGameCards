/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import java.util.ArrayList;

/**
 * Player Hand
 */
public class PlayerHand {
    //General Ressources use by the player
    Stockage general_Ressources;
    //Carte playable of the player
    ArrayList <Building> hand = new ArrayList<Building>();

    public void playCard(Card card, Board board){
        board.addCard(card);
        for (int i = 0; i<hand.size();i++){
            if(hand.get(i).equals(card)){
                hand.remove(i);
            }
        }
    }

}
