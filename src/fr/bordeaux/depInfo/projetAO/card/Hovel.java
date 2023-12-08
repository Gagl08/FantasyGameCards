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
import fr.bordeaux.depInfo.projetAO.ressouce.Food;
import fr.bordeaux.depInfo.projetAO.ressouce.Gold;
import fr.bordeaux.depInfo.projetAO.ressouce.Ressource;
import fr.bordeaux.depInfo.projetAO.ressouce.Wood;

import java.util.HashMap;

public class Hovel extends Decorateur {

    private final StockageRessource getRessourceConsome = new StockageRessource();
    private final StockageRessource getRessourceConstruct = new StockageRessource();
    private final StockageRessource getRessourceProduct = new StockageRessource();
    private final StockageCapacity getCapacity = new StockageCapacity();
    private int tempsDeConstruction;

    public Hovel(Building_Interface building_interface) {
        super(building_interface);
        Gold gold = new Gold(1);
        Food food = new Food(10);
        HashMap<String,Ressource> list1 = new HashMap<>();
        list1.put(gold.getName(),gold);
        list1.put(food.getName(),food);
        getRessourceConsome.addRessource(list1);

        Wood wood = new Wood(15);
        gold = new Gold(10);
        HashMap<String,Ressource> list2 = new HashMap<>();
        list2.put(wood.getName(),wood);
        list2.put(gold.getName(),gold);
        getRessourceConstruct.addRessource(list2);

        Habitant_capacity habitant_capacity = new Habitant_capacity(10);
        getCapacity.addCapacity(habitant_capacity);

        tempsDeConstruction = 1;
    }

    @Override
    public String getName() {
        return super.getName()+"Hovel";
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
        super.setNbWorkerNeeded(0);
        return super.getNbWorkerNeeded();
    }

    @Override
    public int getNbHabAllowed() {
        return super.getNbHabAllowed()+7;
    }

    @Override
    public int getTimerBuild() {
        return tempsDeConstruction;
    }

    public void setTimerBuild(int time){
        tempsDeConstruction = time;
    }
}
