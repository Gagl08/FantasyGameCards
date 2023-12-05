/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO.card;

import fr.bordeaux.depInfo.projetAO.Building_Interface;
import fr.bordeaux.depInfo.projetAO.StockageCapacity;
import fr.bordeaux.depInfo.projetAO.StockageRessource;
import fr.bordeaux.depInfo.projetAO.capacity.Capacity;
import fr.bordeaux.depInfo.projetAO.capacity.Lumber_capacity;
import fr.bordeaux.depInfo.projetAO.capacity.Wood_capacity;
import fr.bordeaux.depInfo.projetAO.ressouce.*;

import java.util.HashMap;

public class Sawmill extends Decorateur {

    private final StockageRessource getRessourceConsome = new StockageRessource();
    private final StockageRessource getRessourceConstruct = new StockageRessource();
    private final StockageRessource getRessourceProduct = new StockageRessource();
    private final StockageCapacity getCapacity = new StockageCapacity();
    private int tempsDeConstruction;

    public Sawmill(Building_Interface building_interface) {
        super(building_interface);

        Wood wood = new Wood(5);
        Gold gold = new Gold(5);
        HashMap<String,Ressource> hashMap = new HashMap<>();
        hashMap.put(gold.getName(),gold);
        hashMap.put(wood.getName(),wood);
        getRessourceConsome.addRessource(hashMap);

        wood = new Wood(40);
        Stone stone = new Stone(20);
        gold = new Gold(20);
        HashMap<String,Ressource> arrayList = new HashMap<>();
        arrayList.put(gold.getName(),gold);
        arrayList.put(wood.getName(),wood);
        arrayList.put(stone.getName(),stone);
        getRessourceConstruct.addRessource(arrayList);

        Lumber lumber = new Lumber(10);
        getRessourceProduct.addRessource(lumber);

        Wood_capacity wood_capacity = new Wood_capacity(100);
        Lumber_capacity lumber_capacity = new Lumber_capacity(100);
        HashMap<String,Capacity> hashMap2 = new HashMap<>();
        hashMap2.put(wood_capacity.getName(), wood_capacity);
        hashMap2.put(lumber_capacity.getName(), lumber_capacity);
        getCapacity.addCapacity(hashMap2);

        this.tempsDeConstruction = 2;
    }

    @Override
    public String getName() {
        return super.getName()+"Sawmill";
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
