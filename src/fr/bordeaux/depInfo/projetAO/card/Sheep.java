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

public class Sheep extends Decorateur {

    public Sheep(Building_Interface building_interface) {
        super(building_interface);
    }

    @Override
    public String getName() {
        return super.getName()+"Sheep";
    }

    @Override
    public StockageRessource getResConso() {
        Gold gold = new Gold(1);
        super.getResConso().addRessource(gold);
        return super.getResConso();
    }

    @Override
    public StockageRessource getResConstruct() {
        Wood wood = new Wood(10);
        Food food = new Food(10);
        Gold gold = new Gold(1);
        ArrayList<Ressource> list = new ArrayList<>();
        list.add(wood);
        list.add(food);
        list.add(gold);
        super.getResConstruct().addRessource(list);
        return super.getResConstruct();
    }

    public StockageRessource getResProd(){
        Food food = new Food(5);
        super.getResProd().addRessource(food);
        return super.getResProd();
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
