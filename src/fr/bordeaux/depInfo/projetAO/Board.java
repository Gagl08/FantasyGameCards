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
    public Board(){
        this.cardsPlayed = new ArrayList<>();
        for(int i = 0; i<5;i++){
            habitantsAvaillable.add(new Habitant());
        }
    }
    public void addCard(Card card){
        this.cardsPlayed.add(card);
        for(int i = 0; i<card.getBuilding().getNbHabAllowed();i++){
            habitantsAvaillable.add(new Habitant());
        }
        for (Habitant_Inteface observer : habitantsAvaillable) {
            card.getBuilding().addObserver(observer);
            System.out.println("Observer added");
        }
        for(int i = 0; i < card.getBuilding().getObservers().size();i++){
            System.out.println("a " + i);
        }
        System.out.println(card.getBuilding().getObservers());
        card.getBuilding().notifyObservers();
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

    public void updateBuilding(){
        for (Card card : this.cardsPlayed){
            if(!card.getBuilding().isActive()){
                int time = card.getBuilding().getTimerBuild();
                if(time>0){
                    card.getBuilding().setTimerBuild(time-1);
                }else{
                    card.getBuilding().setActive(true);
                }
            }
        }
    }

    public void updateHabitant() {
        List<Habitant_Inteface> list_bis = new ArrayList<>();
        list_bis.addAll(this.habitantsAvaillable);

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

    public void updateBoard(StockageRessource stockageRessource,StockageCapacity stockageCapacity)throws RessourceException{
        updateHabitant();
        updateBuilding();
        System.out.println("Nb Jobless : "+ habitantsAvaillable.size());
        gatherRessources(stockageCapacity, stockageRessource);
        consumeRessources(stockageRessource);
    }
}
