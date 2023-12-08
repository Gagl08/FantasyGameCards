/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO.card;

import fr.bordeaux.depInfo.projetAO.Building_Interface;
import fr.bordeaux.depInfo.projetAO.StockageCapacity;
import fr.bordeaux.depInfo.projetAO.StockageRessource;
import fr.bordeaux.depInfo.projetAO.capacity.Wood_capacity;
import fr.bordeaux.depInfo.projetAO.ressouce.*;

import java.util.HashMap;

public class Lumberjack extends Decorateur {

    private final StockageRessource getRessourceConsome = new StockageRessource();
    private final StockageRessource getRessourceConstruct = new StockageRessource();
    private final StockageRessource getRessourceProduct = new StockageRessource();
    private final StockageCapacity getCapacity = new StockageCapacity();
    private int tempsDeConstruction;

    public Lumberjack(Building_Interface building_interface) {
        super(building_interface);

        Gold gold = new Gold(1);
        this.getRessourceConsome.addRessource(gold);

        Wood wood = new Wood(10);
        Stone stone = new Stone(10);
        gold = new Gold(10);
        HashMap<String, Ressource> list = new HashMap<>();
        list.put(wood.getName(), wood);
        list.put(stone.getName(), stone);
        list.put(gold.getName(), gold);
        getRessourceConstruct.addRessource(list);

        wood = new Wood(5);
        getRessourceProduct.addRessource(wood);

        Wood_capacity wood_capacity = new Wood_capacity(100);
        getCapacity.addCapacity(wood_capacity);

        this.tempsDeConstruction = 1;
    }

    public String getName() {
        return super.getName()+"Lumbejack";
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

    public StockageCapacity getCapacity(){return getCapacity;}

    @Override
    public int getNbWorkerNeeded() {
        super.setNbWorkerNeeded(2);
        return super.getNbWorkerNeeded();
    }

    @Override
    public int getNbHabAllowed() {
        super.setNbHabAllowed(5);
        return super.getNbHabAllowed();
    }

    @Override
    public int getTimerBuild() {
        return tempsDeConstruction;
    }

    public void setTimerBuild(int time){
        tempsDeConstruction = time;
    }
}
