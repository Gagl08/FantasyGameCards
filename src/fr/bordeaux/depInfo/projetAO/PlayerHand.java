/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import fr.bordeaux.depInfo.projetAO.exception.RessourceException;
import fr.bordeaux.depInfo.projetAO.ressouce.Ressource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
    public void constructCard(Card card, StockageRessource stockageRessource) throws RessourceException {
        HashMap<String, Ressource> ressourcesCard;
        HashMap<String, Ressource> ressourcesStockage;

        ressourcesCard = card.getBuilding().getResConstruct().list_ressource;
        ressourcesStockage = stockageRessource.list_ressource;

        for (String key : ressourcesCard.keySet()) {
            if (! (ressourcesCard.get(key).getQuantity() <= ressourcesStockage.get(key).getQuantity())){
                throw new RessourceException("You Don't have the found to construct this !");
            }else{
                ressourcesStockage.get(key).lessQuantity(ressourcesCard.get(key).getQuantity());
            }
        }
        stockageRessource.setList_ressource(ressourcesStockage);
    }

    public void deleteOneCard (){
        Scanner entree=new Scanner(System.in);
        String deletedChoice;
        System.out.println("Delete one of your card : ");
        deletedChoice=entree.nextLine();
        int delChoice = Integer.parseInt(deletedChoice);
        this.hand.remove(delChoice);
    }
}
