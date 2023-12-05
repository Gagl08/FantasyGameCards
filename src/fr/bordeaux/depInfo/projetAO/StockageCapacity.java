/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import fr.bordeaux.depInfo.projetAO.capacity.Capacity;
import fr.bordeaux.depInfo.projetAO.ressouce.Gold;

import java.util.HashMap;

/**
 * Object Stockage. Il contient toutes les ressources du jeu ainsi que les capacité de stockage de celles-ci
 */
public class StockageCapacity {

    HashMap<String, Capacity> list_capacity;

    public StockageCapacity (){
        this.list_capacity = new HashMap<>();
    }

    public StockageCapacity( HashMap<String,Capacity> list_capacity){
        this.list_capacity = new HashMap<>();
        this.list_capacity.putAll(list_capacity);
    }

    /**
     * @return actual number of food
     */
    public HashMap<String,Capacity> getList_capacity() {
        return list_capacity;
    }

    /**
     * Add a liste of Capacity to list Capacity
     * @param capacity list to add
     */
    public void addCapacity(HashMap<String,Capacity> capacity) {
        this.list_capacity.putAll(capacity);
    }

    /**
     * Add A Capacity to list Capacity
     * @param capacity to add
     */
    public void addCapacity(Capacity capacity) {
        this.list_capacity.put(capacity.getName(), capacity);
    }

    public void setList_capacity(HashMap<String, Capacity> list_capacity) {
        this.list_capacity=list_capacity;
    }
}