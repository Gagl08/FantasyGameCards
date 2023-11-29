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

    private final StockageRessource getRessourceConsome = new StockageRessource();
    private final StockageRessource getRessourceConstruct = new StockageRessource();
    private final StockageRessource getRessourceProduct = new StockageRessource();
    private final StockageCapacity getCapacity = new StockageCapacity();

    public Forest(Building_Interface building_interface) {
        super(building_interface);
        Gold gold = new Gold(1);
        getRessourceConstruct.addRessource(gold);
        Wood wood = new Wood(2);
        getRessourceProduct.addRessource(wood);

        Wood_capacity wood_capacity = new Wood_capacity(50);
        getCapacity.addCapacity(wood_capacity);
    }

    @Override
    public String getName() {
        return super.getName()+"Forest";
    }

    public StockageRessource getGetResCons(){
        return getRessourceConsome;
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
