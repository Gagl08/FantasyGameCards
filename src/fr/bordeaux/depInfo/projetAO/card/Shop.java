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
import fr.bordeaux.depInfo.projetAO.capacity.Stone_capacity;
import fr.bordeaux.depInfo.projetAO.ressouce.*;

import java.util.HashMap;

public class Shop extends Decorateur {

    private final StockageRessource getRessourceConsome = new StockageRessource();
    private final StockageRessource getRessourceConstruct = new StockageRessource();
    private final StockageRessource getRessourceProduct = new StockageRessource();
    private final StockageCapacity getCapacity = new StockageCapacity();

    public Shop(Building_Interface building_interface) {
        super(building_interface);
        Gold gold = new Gold(1);
        Food food = new Food(5);
        this.getRessourceConsome.addRessource(gold);
        this.getRessourceConsome.addRessource(food);
        Wood wood = new Wood(15);
        HashMap<String,Ressource> list = new HashMap<>();
        list.put(wood.getName(), wood);
        list.put(gold.getName(),gold);
        this.getRessourceConstruct.addRessource(list);
        gold = new Gold(6);
        this.getRessourceProduct.addRessource(gold);
    }

    @Override
    public String getName() {
        return super.getName()+"Shop";
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
