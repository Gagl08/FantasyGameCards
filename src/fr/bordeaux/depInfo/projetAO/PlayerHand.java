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
    StockageRessource general_Ressources;
    //Carte playable of the player
    ArrayList <Card> hand = new ArrayList<>();
    TakeCard cardLoader = new TakeCard();


    public void draw(int turn){
        hand.add(cardLoader.takeCard(turn));
    }

    public void playCard(Card card, Board board){
        for (int i = 0; i<hand.size();i++){
            if(hand.get(i).equals(card)){
                board.addCard(card);
                hand.remove(i);
            }
        }
    }


}
