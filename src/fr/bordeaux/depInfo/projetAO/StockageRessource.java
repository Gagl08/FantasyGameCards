/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import fr.bordeaux.depInfo.projetAO.ressouce.Ressource;

import java.util.ArrayList;

/**
 * Object Stockage. Il contient toutes les ressources du jeu ainsi que les capacité de stockage de celles-ci
 */
public class StockageRessource {

    ArrayList<Ressource> list_ressource;

    public StockageRessource(ArrayList<Ressource> list_ressource){
        this.list_ressource = new ArrayList<>();
        this.list_ressource.addAll(list_ressource);
    }

    /**
     * Add a liste of Ressource to list ressource
     * @param ressource list to add
     */
    public void addRessource(ArrayList<Ressource> ressource) {
        this.list_ressource.addAll(ressource);
    }

    /**
     * Add A Ressource to list ressource
     * @param ressource to add
     */
    public void addRessource(Ressource ressource) {
        this.list_ressource.add(ressource);
    }

    /**
     * @return actual number of food
     */
    public ArrayList<Ressource> getList_ressource() {
        return list_ressource;
    }
}