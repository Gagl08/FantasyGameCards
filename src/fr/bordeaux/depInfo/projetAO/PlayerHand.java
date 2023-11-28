/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import fr.bordeaux.depInfo.projetAO.ressouce.Ressource;

import java.util.ArrayList;

/**
 * Player Hand
 */
public class PlayerHand {
    //Carte playable of the player
    ArrayList <Card> hand = new ArrayList<>();
    TakeCard cardLoader = new TakeCard();

    /**
     * Fonction to Draw a Card
     * @param turn actual
     */
    public void draw(int turn){
        hand.add(cardLoader.takeCard(turn));
    }

    /**
     * put a Card of the hand of the player on the Board
     * @param card to play
     * @param board general
     */
    public void playCard(Card card, Board board){
        for (int i = 0; i<hand.size();i++){
            if(hand.get(i).equals(card)){
                board.addCard(card);
                hand.remove(i);
            }
        }
    }

    /**
     * Decrease the Ressources use on the construction of a building
     * @param card card to play
     * @param stockageRessource general to decrease
     */
    public void constructCard(Card card, StockageRessource stockageRessource){
        ArrayList<Ressource> ressourcesCard;
        ArrayList<Ressource> ressourcesStockage;

        ressourcesCard = card.getBuilding().getResConstruct().list_ressource;
        ressourcesStockage = stockageRessource.list_ressource;

        for (Ressource value : ressourcesCard) {
            for (Ressource ressource : ressourcesStockage) {
                if (value.getName().equals(ressource.getName())) {
                    ressource.lessQuantity(value.getQuantity());
                }
            }
        }
        stockageRessource.setList_ressource(ressourcesStockage);
    }

    /**
     * Check if the player can play a card.
     * Verifing the ressource of the player are anougth
     * @param card to check
     * @param stockageRessource general
     * @return true if is possible false else
     */
    public boolean canPlay(Card card, StockageRessource stockageRessource){
        ArrayList<Ressource> ressourcesCard;
        ArrayList<Ressource> ressourcesStockage;

        ressourcesCard = card.getBuilding().getResConstruct().list_ressource;
        ressourcesStockage = stockageRessource.list_ressource;

        for (Ressource ressource : ressourcesStockage) {
            for (Ressource value : ressourcesCard) {
                if (value.getName().equals(ressource.getName())) {
                    if (! (value.getQuantity() <= ressource.getQuantity())){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
