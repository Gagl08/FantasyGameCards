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
 * Object Ressource. Il contient toutes les ressources du jeu ainsi que les capacité de stockage de celles-ci
 */
public class Stockage {

    ArrayList<Ressource> list_ressource;
    ArrayList<Capacity> list_capacity;

    public Stockage (ArrayList<Ressource> list_ressource, ArrayList<Capacity> list_capacity){
        this.list_ressource = new ArrayList<>();
        this.list_ressource.addAll(list_ressource);

        this.list_capacity = new ArrayList<>();
        this.list_capacity.addAll(list_capacity);
    }


}