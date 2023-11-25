/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import fr.bordeaux.depInfo.projetAO.capacity.Capacity;
import fr.bordeaux.depInfo.projetAO.ressouce.Ressource;

import java.util.ArrayList;

/**
 * Object Stockage. Il contient toutes les ressources du jeu ainsi que les capacité de stockage de celles-ci
 */
public class StockageCapacity {

    ArrayList<Capacity> list_capacity;

    public StockageCapacity (){
        this.list_capacity = new ArrayList<>();
    }

    public StockageCapacity( ArrayList<Capacity> list_capacity){
        this.list_capacity = new ArrayList<>();
        this.list_capacity.addAll(list_capacity);
    }

    /**
     * @return actual number of food
     */
    public ArrayList<Capacity> getList_capacity() {
        return list_capacity;
    }

    /**
     * Add a liste of Capacity to list Capacity
     * @param capacity list to add
     */
    public void addCapacity(ArrayList<Capacity> capacity) {
        this.list_capacity.addAll(capacity);
    }

    /**
     * Add A Capacity to list Capacity
     * @param capacity to add
     */
    public void addCapacity(Capacity capacity) {
        this.list_capacity.add(capacity);
    }
}