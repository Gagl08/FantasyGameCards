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

import java.util.ArrayList;
import java.util.HashMap;

public class Sheep extends Decorateur {

    private final StockageRessource getRessourceConsome = new StockageRessource();
    private final StockageRessource getRessourceConstruct = new StockageRessource();
    private final StockageRessource getRessourceProduct = new StockageRessource();
    private final StockageCapacity getCapacity = new StockageCapacity();

    public Sheep(Building_Interface building_interface) {
        super(building_interface);
        Gold gold = new Gold(1);
        getRessourceConsome.addRessource(gold);

        Wood wood = new Wood(10);
        Food food = new Food(10);
        HashMap<String, Ressource> list = new HashMap<>();
        list.put(wood.getName(), wood);
        list.put(food.getName(), food);
        list.put(gold.getName(), gold);
        getRessourceConstruct.addRessource(list);

        food = new Food(5);
        getRessourceProduct.addRessource(food);
    }

    @Override
    public String getName() {
        return super.getName()+"Sheep";
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
        Food_capacity food = new Food_capacity(25);
        super.getCapacity().addCapacity(food);
        return super.getCapacity();
    }

    @Override
    public int getNbWorkerNeeded() {
        super.setNbWorkerNeeded(1);
        return super.getNbWorkerNeeded();
    }

    @Override
    public int getTimerBuild() {
        return super.getTimerBuild()+1;
    }
}
