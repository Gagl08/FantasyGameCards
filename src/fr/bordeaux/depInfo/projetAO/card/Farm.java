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

import java.util.ArrayList;
import java.util.HashMap;

public class Farm extends Decorateur {

    private final StockageRessource getRessourceConsome = new StockageRessource();
    private final StockageRessource getRessourceConstruct = new StockageRessource();
    private final StockageRessource getRessourceProduct = new StockageRessource();
    private final StockageCapacity getCapacity = new StockageCapacity();


    public Farm(Building_Interface building_interface) {
        super(building_interface);
        Gold gold = new Gold(1);
        this.getRessourceConsome.addRessource(gold);
        Wood wood = new Wood(10);
        HashMap<String,Ressource> list = new HashMap<>();
        list.put(wood.getName(), wood);
        list.put(gold.getName(),gold);
        this.getRessourceConstruct.addRessource(list);
        Food food = new Food(2);
        this.getRessourceProduct.addRessource(food);

        Food_capacity food_capacity = new Food_capacity(50);
        this.getCapacity.addCapacity(food_capacity);
    }

    @Override
    public String getName() {
        return super.getName()+"Farm";
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
        super.setNbWorkerNeeded(1);
        return super.getNbWorkerNeeded();
    }
}
