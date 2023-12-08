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

public class Manor extends Decorateur {

    private final StockageRessource getRessourceConsome = new StockageRessource();
    private final StockageRessource getRessourceConstruct = new StockageRessource();
    private final StockageRessource getRessourceProduct = new StockageRessource();
    private final StockageCapacity getCapacity = new StockageCapacity();
    private int tempsDeConstruction;

    public Manor(Building_Interface building_interface) {
        super(building_interface);
        Gold gold = new Gold(20);
        Food food = new Food(50);
        HashMap<String,Ressource> list1 = new HashMap<>();
        list1.put(gold.getName(),gold);
        list1.put(food.getName(),food);
        getRessourceConsome.addRessource(list1);

        Wood wood = new Wood(75);
        Stone stone = new Stone(50);
        Brique brique = new Brique(30);
        Lumber lumber = new Lumber(30);
        gold = new Gold(100);
        HashMap<String,Ressource> list2 = new HashMap<>();
        list2.put(wood.getName(),wood);
        list2.put(gold.getName(),gold);
        list2.put(stone.getName(),stone);
        list2.put(brique.getName(),brique);
        list2.put(lumber.getName(),lumber);
        getRessourceConstruct.addRessource(list2);

        Habitant_capacity habitant_capacity = new Habitant_capacity(50);
        getCapacity.addCapacity(habitant_capacity);

        tempsDeConstruction = 5;
    }

    @Override
    public String getName() {
        return super.getName()+"Manor";
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
        return super.getNbHabAllowed()+35;
    }

    @Override
    public int getTimerBuild() {
        return tempsDeConstruction;
    }

    public void setTimerBuild(int time){
        tempsDeConstruction = time;
    }
}
