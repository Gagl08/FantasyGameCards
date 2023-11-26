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

    public boolean canPlay(Card card, StockageRessource stockageRessource){
        ArrayList<Ressource> ressourcesCard;
        ArrayList<Ressource> ressourcesStockage;

        ressourcesCard = card.getBuilding().getResConstruct().list_ressource;
        ressourcesStockage = stockageRessource.list_ressource;

        for (Ressource ressource : ressourcesStockage) {
            for (Ressource value : ressourcesCard) {
                if (value.getName().equals(ressource.getName())) {
                    return value.getQuantity() < ressource.getQuantity();
                }
            }
        }
        return false;
    }
}
