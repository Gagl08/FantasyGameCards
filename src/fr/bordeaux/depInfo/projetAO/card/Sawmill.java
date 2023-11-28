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

import java.util.ArrayList;
import java.util.HashMap;

public class Sawmill extends Decorateur {

    public Sawmill(Building_Interface building_interface) {
        super(building_interface);
    }

    @Override
    public String getName() {
        return super.getName()+"Sawmill";
    }



    @Override
    public StockageRessource getResConstruct() {
        Wood wood = new Wood(40);
        Stone stone = new Stone(20);
        Gold gold = new Gold(20);
        HashMap<String,Ressource> arrayList = new HashMap<>();
        arrayList.put("Gold", new Ressource(20));
        arrayList.put("Wood", new Ressource(40));
        arrayList.put("Stone", new Ressource(20));
        super.getResConstruct().addRessource(arrayList);
        return super.getResConstruct();
    }

    public StockageRessource getResProd(){
        Lumber lumber = new Lumber(10);
        super.getResProd().addRessource(lumber);
        return super.getResProd();
    }

    public StockageCapacity getCapacity(){
        Wood_capacity wood_capacity = new Wood_capacity(100);
        Lumber_capacity lumber_capacity = new Lumber_capacity(100);
        HashMap<String,Capacity> arrayList = new HashMap<>();
        arrayList.put(wood_capacity.getName(), wood_capacity);
        arrayList.put(lumber_capacity.getName(), lumber_capacity);
        super.getCapacity().addCapacity(arrayList);
        return super.getCapacity();
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
        return super.getTimerBuild()+2;
    }
}
