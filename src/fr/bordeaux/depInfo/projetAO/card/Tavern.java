/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO.card;

import fr.bordeaux.depInfo.projetAO.Building_Interface;
import fr.bordeaux.depInfo.projetAO.StockageCapacity;
import fr.bordeaux.depInfo.projetAO.StockageRessource;
import fr.bordeaux.depInfo.projetAO.capacity.Food_capacity;
import fr.bordeaux.depInfo.projetAO.capacity.Habitant_capacity;
import fr.bordeaux.depInfo.projetAO.ressouce.*;

import java.util.HashMap;

public class Tavern extends Decorateur {

    private final StockageRessource getRessourceConsome = new StockageRessource();
    private final StockageRessource getRessourceConstruct = new StockageRessource();
    private final StockageRessource getRessourceProduct = new StockageRessource();
    private final StockageCapacity getCapacity = new StockageCapacity();
    private int tempsDeConstruction;

    public Tavern(Building_Interface building_interface) {
        super(building_interface);
        Gold gold = new Gold(5);
        Food food = new Food(15);
        HashMap<String,Ressource> list1 = new HashMap<>();
        list1.put(gold.getName(),gold);
        list1.put(food.getName(),food);
        getRessourceConsome.addRessource(list1);

        gold = new Gold(15);
        this.getRessourceProduct.addRessource(gold);

        Wood wood = new Wood(30);
        Stone stone = new Stone(15);
        gold = new Gold(20);
        HashMap<String,Ressource> list2 = new HashMap<>();
        list2.put(wood.getName(),wood);
        list2.put(gold.getName(),gold);
        list2.put(stone.getName(),stone);
        getRessourceConstruct.addRessource(list2);

        Habitant_capacity habitant_capacity = new Habitant_capacity(25);
        getCapacity.addCapacity(habitant_capacity);

        tempsDeConstruction = 3;
    }

    @Override
    public String getName() {
        return super.getName()+"Tavern";
    }

    @Override
    public StockageRessource getResConso() {
        return getRessourceConsome;
    }

    @Override
    public StockageRessource getResConstruct() {
        return getRessourceConstruct;
    }

    public StockageRessource getResProd(){
        return getRessourceProduct;
    }

    public StockageCapacity getCapacity(){
        return getCapacity;
    }

    @Override
    public int getNbWorkerNeeded() {
        super.setNbWorkerNeeded(2);
        return super.getNbWorkerNeeded();
    }

    @Override
    public int getNbHabAllowed() {
        return super.getNbHabAllowed()+10;
    }

    @Override
    public int getTimerBuild() {
        return tempsDeConstruction;
    }

    public void setTimerBuild(int time){
        tempsDeConstruction = time;
    }
}
