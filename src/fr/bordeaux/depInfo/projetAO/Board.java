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
import java.util.Iterator;
import java.util.List;


/**
 * Board game is where the player places the cards, it is the "map" of the game.
 */
public class Board {
    private final List<Habitant_Inteface> habitantsAvaillable=new ArrayList<>();

    public List<Card> cardsPlayed;

    /**
     * Constructor
     */
    public Board(){
        this.cardsPlayed = new ArrayList<>();
        for(int i = 0; i<5;i++){
            habitantsAvaillable.add(new Habitant());
        }
    }

    /**
     * When you add a card to the board you need to know how many people work an live in this building
     * You need to notify the Jobless if the building have a job
     * @param card to add
     */
    public void addCard(Card card) {
        this.cardsPlayed.add(card);

        // Add residents to the building observers list
        for (Habitant_Inteface observer : habitantsAvaillable) {
            card.getBuilding().addObserver(observer);
        }

        // Add new inhabitants to the available list
        for (int i = 0; i < card.getBuilding().getNbHabAllowed(); i++) {
            Habitant_Inteface newHabitant = new Habitant();
            habitantsAvaillable.add(newHabitant);
            for(Card cardbis : this.cardsPlayed){
                cardbis.getBuilding().addObserver(newHabitant);
            }
            card.getBuilding().addObserver(newHabitant);
        }

        // Update the number of workers needed
        card.getBuilding().setNbWorkerNeeded(card.getBuilding().getNbHabAllowed());
        card.getBuilding().getNbWorkerNeeded();

        //Notify observers after additions
        card.getBuilding().notifyObservers();
    }

    /**
     * Dellete the ressource consume by the card
     * @param stockageRessource stockage to delete
     * @throws RessourceException raise if you don t have all ressource s
     */
    public void consumeRessources(StockageRessource stockageRessource) throws RessourceException {
        //Parcourt chaque carte pour consommer les ressources du joueur pour maintenir les bâtiments
        HashMap<String, Ressource> ressourcesStockage;
        ressourcesStockage = stockageRessource.list_ressource;

        for (Card card : this.cardsPlayed) {
            if(card.building.isActive()){
                HashMap<String, Ressource> ressourcesCard;
                ressourcesCard = card.getBuilding().getResConso().list_ressource;

                for (String key : ressourcesCard.keySet()) {
                    if (!(ressourcesCard.get(key).getQuantity() <= ressourcesStockage.get(key).getQuantity())) {
                        throw new RessourceException("No ressources available now !");
                    } else {
                        ressourcesStockage.get(key).lessQuantity(ressourcesCard.get(key).getQuantity());
                    }
                }
            }
        }
        stockageRessource.setList_ressource(ressourcesStockage);
    }

    /**
     * Get all ressource to add to a Stockage ressource Ans add it one to one
     * @param capacity max to add the ressource
     * @param stockageRessource stockage to add
     */
    public void gatherRessources(StockageCapacity capacity,StockageRessource stockageRessource){
        //Parcourt chaque carte pour augmenter les ressources du joueur
        HashMap<String, Ressource> ressourcesStockage;
        ressourcesStockage = stockageRessource.list_ressource;

        for (Card card : this.cardsPlayed) {
            if(card.building.isActive()) {
                HashMap<String, Ressource> ressourcesCard;
                ressourcesCard = card.getBuilding().getResProd().list_ressource;

                for (String key : ressourcesCard.keySet()) {
                    ressourcesStockage.get(key).addQuantity(capacity, key + "_Capacity", ressourcesCard.get(key).getQuantity());
                }
            }
        }
        stockageRessource.setList_ressource(ressourcesStockage);
    }

    /**
     * Know if a building is ready to work or if in construction or if is have anoth worker
     */
    public void updateBuilding(){
        for (Card card : this.cardsPlayed){
            if(!card.getBuilding().isActive()){
                int time = card.getBuilding().getTimerBuild();
                if(time>0){
                    card.getBuilding().setTimerBuild(time-1);
                }else{
                    if(card.getBuilding().getNbWorkerActual()==card.getBuilding().getNbWorkerNeeded()){
                        card.getBuilding().setActive(true);
                    }else{
                        card.getBuilding().notifyObservers();
                    }
                }
            }
        }
    }

    /**
     * Know if somone can find a Job
     */
    public void updateHabitant() {
        Iterator<Habitant_Inteface> iterator = habitantsAvaillable.iterator();
        while (iterator.hasNext()) {
            Habitant_Inteface habitant = iterator.next();
            if (habitant.getWork()) {
                for (Card card : cardsPlayed) {
                    card.getBuilding().removeObserver(habitant);
                }
                iterator.remove();
            }
        }
    }

    /**
     * Call all fonction to update the board at the end of a turn
     * @param stockageRessource to moddify
     * @param stockageCapacity to moddify
     * @throws RessourceException raise if you don t have all ressource s
     */
    public void updateBoard(StockageRessource stockageRessource,StockageCapacity stockageCapacity)throws RessourceException{
        updateHabitant();
        updateBuilding();
        System.out.println("Nb Jobless : "+ habitantsAvaillable.size());
        gatherRessources(stockageCapacity, stockageRessource);
        consumeRessources(stockageRessource);
    }
}
