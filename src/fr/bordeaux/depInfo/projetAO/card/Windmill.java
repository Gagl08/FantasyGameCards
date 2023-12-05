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
import fr.bordeaux.depInfo.projetAO.ressouce.*;

import java.util.HashMap;

public class Windmill extends Decorateur {

    private final StockageRessource getRessourceConsome = new StockageRessource();
    private final StockageRessource getRessourceConstruct = new StockageRessource();
    private final StockageRessource getRessourceProduct = new StockageRessource();
    private final StockageCapacity getCapacity = new StockageCapacity();
    private int tempsDeConstruction;

    public Windmill(Building_Interface building_interface) {
        super(building_interface);

        Gold gold = new Gold(2);
        Wood wood = new Wood(5);
        HashMap<String, Ressource> list = new HashMap<>();
        list.put(gold.getName(),gold);
        list.put(wood.getName(), wood);
        getRessourceConsome.addRessource(list);

        wood = new Wood(40);
        Stone stone = new Stone(20);
        gold = new Gold(20);
        HashMap<String, Ressource> list2 = new HashMap<>();
        list2.put(gold.getName(), gold);
        list2.put(stone.getName(), stone);
        list2.put(wood.getName(), wood);
        getRessourceConstruct.addRessource(list2);

        Food food = new Food(10);
        getRessourceProduct.addRessource(food);

        Food_capacity food_capacity = new Food_capacity(100);
        getCapacity.addCapacity(food_capacity);

        this.tempsDeConstruction = 2;
    }

    @Override
    public String getName() {
        return super.getName()+"Windmill";
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
        super.setNbWorkerNeeded(5);
        return super.getNbWorkerNeeded();
    }

    @Override
    public int getNbHabAllowed() {
        return super.getNbHabAllowed()+2;
    }

    @Override
    public int getTimerBuild() {
        return tempsDeConstruction;
    }

    public void setTimerBuild(int time){
        tempsDeConstruction = time;
    }
}
