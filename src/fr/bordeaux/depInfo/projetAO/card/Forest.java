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
import fr.bordeaux.depInfo.projetAO.ressouce.Gold;
import fr.bordeaux.depInfo.projetAO.ressouce.Wood;

public class Forest extends Decorateur {

    public Forest(Building_Interface building_interface) {
        super(building_interface);
    }

    @Override
    public String getName() {
        return super.getName()+"Forest";
    }

    public StockageRessource getResProd(){
        Wood wood = new Wood(2);
        super.getResProd().addRessource(wood);
        return super.getResProd();
    }

    public StockageCapacity getCapacity(){
        Wood_capacity food = new Wood_capacity(50);
        super.getCapacity().addCapacity(food);
        return super.getCapacity();
    }

    @Override
    public StockageRessource getResConstruct() {
        Gold gold = new Gold(1);
        super.getResConstruct().addRessource(gold);
        return super.getResConstruct();
    }

    @Override
    public int getNbWorkerNeeded() {
        super.setNbWorkerNeeded(1);
        return super.getNbWorkerNeeded();
    }
}
