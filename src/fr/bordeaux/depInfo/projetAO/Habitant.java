/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

/**
 * Object Habitant use to make usefull the building
 * Compose by a useless name and a var to know if is working or not
 */
public class Habitant implements Habitant_Inteface {
    private boolean work;

    public Habitant() {
        this.work = false;
    }

    @Override
    public void update(Building_Interface building) {
        if (building.getNbWorkerNeeded() > building.getNbWorkerActual()) {
            this.work = true;
            building.setNbWorkerActual(building.getNbWorkerActual()+1);
            System.out.println(building.getNbWorkerActual());
        }
    }

    public boolean getWork() {
        return this.work;
    }
}