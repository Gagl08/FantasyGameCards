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
import fr.bordeaux.depInfo.projetAO.capacity.Wood_capacity;
import fr.bordeaux.depInfo.projetAO.ressouce.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Lumberjack extends Decorateur {

    public Lumberjack(Building_Interface building_interface) {
        super(building_interface);
    }

    @Override
    public String getName() {
        return super.getName()+"Lumberjack";
    }



    @Override
    public StockageRessource getResConstruct() {
        Wood wood = new Wood(10);
        Stone stone = new Stone(10);
        Gold gold = new Gold(10);
        HashMap<String, Ressource> list = new HashMap<>();
        list.put("Wood", new Ressource(10));
        list.put("Stone", new Ressource(10));
        list.put("Gold", new Ressource(10));
        super.getResConstruct().addRessource(list);
        return super.getResConstruct();
    }

    public StockageRessource getResProd(){
        Wood wood = new Wood(5);
        super.getResProd().addRessource(wood);
        return super.getResProd();
    }

    public StockageCapacity getCapacity(){
        Wood_capacity wood_capacity = new Wood_capacity(100);
        super.getCapacity().addCapacity(wood_capacity);
        return super.getCapacity();
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
