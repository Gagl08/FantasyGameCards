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

public class Farm extends Decorateur {

    public Farm(Building_Interface building_interface) {
        super(building_interface);
    }

    @Override
    public String getName() {
        return super.getName()+"Farm";
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
        Gold gold = new Gold(1);
        ArrayList<Ressource> list = new ArrayList<>();
        list.add(wood);
        list.add(gold);
        super.getResConstruct().addRessource(list);
        return super.getResConstruct();
    }

    public StockageRessource getResProd(){
        Food food = new Food(15);
        super.getResProd().addRessource(food);
        return super.getResProd();
    }

    public StockageCapacity getCapacity(){
        Food_capacity food = new Food_capacity(50);
        super.getCapacity().addCapacity(food);
        return super.getCapacity();
    }

    @Override
    public int getNbWorkerNeeded() {
        super.setNbWorkerNeeded(5);
        return super.getNbWorkerNeeded();
    }
}
