/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

/**
 * Interface of Habitant use by an Observer Building in building Interface
 */
public interface Habitant_Inteface {
    void update(Building_Interface building);
    boolean getWork();
}