/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

/**
 * Interface of Buildind to create the Decorator on a Building
 */
public interface Building_Interface {
    String getName();
    int getNbHabAllowed();
    void setNbHabAllowed(int nbHabAllowed);
    int getNbWorkerNeeded();
    void setNbWorkerNeeded(int nbWorkerNeeded);
    StockageRessource getResConstruct();
    StockageRessource getResConso();
    StockageRessource getResProd();
    StockageCapacity getCapacity();
    boolean isActive();
    void setActive(boolean active);
    int getTimerBuild();
    void setTimerBuild(int timerBuild);
    boolean isFunctional();
    void produceRessource(PlayerHand player);
    void consumeRessource(PlayerHand player);

}
