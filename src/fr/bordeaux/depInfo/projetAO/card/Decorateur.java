/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO.card;

import fr.bordeaux.depInfo.projetAO.Building_Interface;
import fr.bordeaux.depInfo.projetAO.PlayerHand;
import fr.bordeaux.depInfo.projetAO.StockageCapacity;
import fr.bordeaux.depInfo.projetAO.StockageRessource;
import fr.bordeaux.depInfo.projetAO.ressouce.Ressource;

import java.util.ArrayList;
import java.util.HashMap;

public class Decorateur implements Building_Interface {
    private final Building_Interface building_interface;

    public Decorateur(Building_Interface building_interface) {
        this.building_interface = building_interface;
    }

    @Override
    public String getName() {
        return building_interface.getName();
    }

    @Override
    public int getNbHabAllowed() {
        return building_interface.getNbHabAllowed();
    }

    @Override
    public void setNbHabAllowed(int nbHabAllowed) {
        this.building_interface.setNbHabAllowed(nbHabAllowed);
    }

    @Override
    public int getNbWorkerNeeded() {
        return this.building_interface.getNbWorkerNeeded();
    }

    @Override
    public void setNbWorkerNeeded(int nbWorkerNeeded) {
        this.building_interface.setNbWorkerNeeded(nbWorkerNeeded);
    }

    @Override
    public StockageRessource getResConstruct() {
        return this.building_interface.getResConstruct();
    }



    @Override
    public StockageRessource getResConso() {
        return this.building_interface.getResConso();
    }

    @Override
    public StockageRessource getResProd() {
        return this.building_interface.getResProd();
    }

    @Override
    public StockageCapacity getCapacity() {
        return this.building_interface.getCapacity();
    }

    @Override
    public boolean isActive() {
        return this.building_interface.isActive();
    }

    @Override
    public void setActive(boolean active) {
        this.building_interface.setActive(active);
    }

    @Override
    public int getTimerBuild() {
        return this.building_interface.getTimerBuild();
    }

    @Override
    public void setTimerBuild(int timerBuild) {
        this.building_interface.setTimerBuild(timerBuild);
    }

    @Override
    public boolean isFunctional() {
        return this.building_interface.isFunctional();
    }

}
