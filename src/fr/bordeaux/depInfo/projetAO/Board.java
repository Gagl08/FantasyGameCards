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
import java.util.List;

/**
 * Board game is where the player places the cards, it is the "map" of the game.
 */
public class Board {
    public List<Card> cardsPlayed;

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

    public void consumeRessources(StockageRessource stockageRessource) throws RessourceException {
        //Parcourt chaque carte pour consommer les ressources du joueur pour maintenir les bâtiments
        HashMap<String, Ressource> ressourcesStockage;
        ressourcesStockage = stockageRessource.list_ressource;

        for (Card card : this.cardsPlayed) {
            HashMap<String, Ressource> ressourcesCard;
            ressourcesCard = card.getBuilding().getResConso().list_ressource;

            for (String key : ressourcesCard.keySet()) {
                if (! (ressourcesCard.get(key).getQuantity() <= ressourcesStockage.get(key).getQuantity())) {
                    throw new RessourceException("No ressources available now !");
                }else {
                    ressourcesStockage.get(key).lessQuantity(ressourcesCard.get(key).getQuantity());
                }
            }
        }
        stockageRessource.setList_ressource(ressourcesStockage);
    }

    public void gatherRessources(StockageCapacity capacity,StockageRessource stockageRessource){
        //Parcourt chaque carte pour augmenter les ressources du joueur
        HashMap<String, Ressource> ressourcesStockage;
        ressourcesStockage = stockageRessource.list_ressource;

        for (Card card : this.cardsPlayed) {
            HashMap<String, Ressource> ressourcesCard;
            ressourcesCard = card.getBuilding().getResProd().list_ressource;

            for (String key : ressourcesCard.keySet()) {
                System.out.println(key);
                ressourcesStockage.get(key).addQuantity(capacity, key + "_Capacity", ressourcesCard.get(key).getQuantity());
            }
        }
        stockageRessource.setList_ressource(ressourcesStockage);
    }
}
