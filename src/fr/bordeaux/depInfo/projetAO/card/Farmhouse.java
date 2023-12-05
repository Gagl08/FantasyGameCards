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
import fr.bordeaux.depInfo.projetAO.ressouce.Food;
import fr.bordeaux.depInfo.projetAO.ressouce.Gold;
import fr.bordeaux.depInfo.projetAO.ressouce.Ressource;
import fr.bordeaux.depInfo.projetAO.ressouce.Wood;

import java.util.HashMap;

public class Farmhouse extends Decorateur {

    private final StockageRessource getRessourceConsome = new StockageRessource();
    private final StockageRessource getRessourceConstruct = new StockageRessource();
    private final StockageRessource getRessourceProduct = new StockageRessource();
    private final StockageCapacity getCapacity = new StockageCapacity();
    private final int tempsDeConstruction;

    public Farmhouse(Building_Interface building_interface) {
        super(building_interface);
        Gold gold = new Gold(1);
        Wood wood = new Wood(10);
        HashMap<String,Ressource> list1 = new HashMap<>();
        list1.put(gold.getName(),gold);
        list1.put(wood.getName(),wood);
        getRessourceConsome.addRessource(list1);

        wood = new Wood(10);
        gold = new Gold(10);
        HashMap<String,Ressource> list2 = new HashMap<>();
        list2.put(wood.getName(),wood);
        list2.put(gold.getName(),gold);
        getRessourceConstruct.addRessource(list2);

        Food food = new Food(5);
        getRessourceProduct.addRessource(food);

        Food_capacity food_capacity = new Food_capacity(100);
        getCapacity.addCapacity(food_capacity);

        tempsDeConstruction = 1;
    }

    @Override
    public String getName() {
        return super.getName()+"Farmhouse";
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
        return super.getNbHabAllowed()+5;
    }

    @Override
    public int getTimerBuild() {
        return super.getTimerBuild()+1;
    }
}
