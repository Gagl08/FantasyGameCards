/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import fr.bordeaux.depInfo.projetAO.ressouce.Ressource;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Object Stockage. Il contient toutes les ressources du jeu ainsi que les capacité de stockage de celles-ci
 */
public class StockageRessource {

    HashMap<String,Ressource> list_ressource;

    /**
     * Constructor
     */
    public StockageRessource(){
        this.list_ressource = new HashMap<>();
    }

    public StockageRessource(HashMap<String,Ressource> list_ressource){
        this.list_ressource = new HashMap<>();
        this.list_ressource.putAll(list_ressource);
    }

    /**
     * Add a liste of Ressource to list ressource
     * @param ressource list to add
     */
    public void addRessource(HashMap<String,Ressource> ressource) {
        this.list_ressource.putAll(ressource);
    }

    /**
     * Add A Ressource to list ressource
     * @param ressource to add
     */
    public void addRessource(Ressource ressource) {
        this.list_ressource.put(ressource.getName(), ressource);
    }

    /**
     * @return actual number of food
     */
    public HashMap<String,Ressource> getList_ressource() {
        return list_ressource;
    }

    public void setList_ressource(HashMap<String,Ressource> list_ressource) {
        this.list_ressource=list_ressource;
    }
}