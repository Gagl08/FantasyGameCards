/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import fr.bordeaux.depInfo.projetAO.capacity.Capacity;

/**
 * Object Habitant.
 */
public class Habitant implements Habitant_Inteface_Building_Observer {
    private boolean work;
    public Habitant() {
        String name = "Pierre";
        this.work = false;
    }

    @Override
    public void update(Building building) {
        if (building.nbWorkerNeeded>0){
            this.work=true;
            building.nbWorkerNeeded--;
        }
    }

    public boolean getWork(){
        return this.work;
    }
}
