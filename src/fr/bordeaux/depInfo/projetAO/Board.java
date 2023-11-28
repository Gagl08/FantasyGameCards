/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Board game is where the player places the cards, it is the "map" of the game.
 */
public class Board {
    List<Card> cardsPlayed;

    public Board(){
        this.cardsPlayed = new ArrayList<>();
    }
    public void addCard(Card card){
        this.cardsPlayed.add(card);
    }
    public void removeCard(Card card){
        this.cardsPlayed.remove(card);
    }
    public void deactivateBuilding(int indexCard){
        this.cardsPlayed.get(indexCard).getBuilding().setActive(false);
    }
    public void activateBuilding(int indexCard){
        this.cardsPlayed.get(indexCard).getBuilding().setActive(true);
    }
    public void consumeRessources(PlayerHand player){
        //Parcourt chaque carte pour consommer les ressources du joueur pour maintenir les bâtiments
        for (Card card : this.cardsPlayed) {
            card.getBuilding().consumeRessource(player);
        }
    }
    public void gatherRessources(PlayerHand player){
        //Parcourt chaque carte pour augmenter les ressources du joueur
        for (Card card : this.cardsPlayed) {
            card.getBuilding().produceRessource(player);
        }
    }
}
