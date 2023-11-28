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

public class Farmhouse extends Decorateur {

    public Farmhouse(Building_Interface building_interface) {
        super(building_interface);
    }

    @Override
    public String getName() {
        return super.getName()+"Farmhouse";
    }

    @Override
    public StockageRessource getResConso() {
        Gold gold = new Gold(1);
        Wood wood = new Wood(10);
        HashMap<String,Ressource> arrayList = new HashMap<String,Ressource>();
        arrayList.put("Gold",new Ressource(1));
        arrayList.put("Wood", new Ressource(10));
        super.getResConso().addRessource(arrayList);
        return super.getResConso();
    }

    @Override
    public StockageRessource getResConstruct() {
        Wood wood = new Wood(10);
        Gold gold = new Gold(10);
        HashMap<String,Ressource> arrayList = new HashMap<String,Ressource>();
        arrayList.put("Gold",new Ressource(10));
        arrayList.put("Wood", new Ressource(10));
        super.getResConstruct().addRessource(arrayList);
        return super.getResConstruct();
    }

    public StockageRessource getResProd(){
        Food food = new Food(5);
        super.getResProd().addRessource(food);
        return super.getResProd();
    }

    public StockageCapacity getCapacity(){
        Food_capacity food = new Food_capacity(100);
        super.getCapacity().addCapacity(food);
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
