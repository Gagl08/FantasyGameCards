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

public class GoldMine extends Decorateur {

    private final StockageRessource getRessourceConsome = new StockageRessource();
    private final StockageRessource getRessourceConstruct = new StockageRessource();
    private final StockageRessource getRessourceProduct = new StockageRessource();
    private final StockageCapacity getCapacity = new StockageCapacity();


    public GoldMine(Building_Interface building_interface) {
        super(building_interface);
        Gold gold = new Gold(1);
        Wood wood = new Wood(2);
        this.getRessourceConsome.addRessource(gold);
        this.getRessourceConsome.addRessource(wood);
        wood = new Wood(15);
        HashMap<String,Ressource> list = new HashMap<>();
        list.put(wood.getName(), wood);
        list.put(gold.getName(),gold);
        this.getRessourceConstruct.addRessource(list);
        gold = new Gold(15);
        this.getRessourceProduct.addRessource(gold);

        Food_capacity food_capacity = new Food_capacity(50);
        this.getCapacity.addCapacity(food_capacity);
    }

    @Override
    public String getName() {
        return super.getName()+"Gold Mine";
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
