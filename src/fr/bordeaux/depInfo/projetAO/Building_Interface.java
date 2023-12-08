/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import java.util.ArrayList;

/**
 * Interface of Buildind to create the Decorator on a Building
 */
public interface Building_Interface {
    String getName();
    int getNbHabAllowed();
    void setNbHabAllowed(int nbHabAllowed);
    int getNbWorkerNeeded();
    void setNbWorkerNeeded(int nbWorkerNeeded);
    int getNbWorkerActual();
    void setNbWorkerActual(int nbWorkerNeeded);
    StockageRessource getResConstruct();
    StockageRessource getResConso();

    StockageRessource getResProd();
    StockageCapacity getCapacity();
    boolean isActive();
    void setActive(boolean active);
    int getTimerBuild();
    void setTimerBuild(int timerBuild);
    boolean isFunctional();

    void addObserver(Habitant_Inteface observer);
    void removeObserver(Habitant_Inteface observer);
    void notifyObservers();

    ArrayList<Habitant_Inteface> getObservers();
}
