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

public class Windmill extends Decorateur {

    public Windmill(Building_Interface building_interface) {
        super(building_interface);
    }

    @Override
    public String getName() {
        return super.getName()+"Windmill";
    }

    @Override
    public StockageRessource getResConso() {
        Gold gold = new Gold(2);
        Wood wood = new Wood(5);
        ArrayList<Ressource> arrayList = new ArrayList<>();
        arrayList.add(gold);
        arrayList.add(wood);
        super.getResConso().addRessource(arrayList);
        return super.getResConso();
    }

    @Override
    public StockageRessource getResConstruct() {
        Wood wood = new Wood(40);
        Stone stone = new Stone(20);
        Gold gold = new Gold(20);
        ArrayList<Ressource> list = new ArrayList<>();
        list.add(wood);
        list.add(stone);
        list.add(gold);
        super.getResConstruct().addRessource(list);
        return super.getResConstruct();
    }

    public StockageRessource getResProd(){
        Food food = new Food(10);
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
