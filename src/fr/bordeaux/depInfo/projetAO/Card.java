/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */
package fr.bordeaux.depInfo.projetAO;

/**
 *
 */
public class Card {
    int compteur = 1;
    int id;
    Building building;

    public Card (Building building){
        this.id=compteur;
        compteur++;
        this.building=building;
    }

    public int getId() {
        return id;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
