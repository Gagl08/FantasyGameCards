/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */
package fr.bordeaux.depInfo.projetAO;

/**
 * Card use to play.
 * Compose by a id and a Building
 */
public class Card {
    int id;
    Building_Interface building;

    /**
     * Constructor to create a card
     * @param building to add on the card
     */
    public Card (Building_Interface building){
        this.id=1;
        this.building=building;
    }

    /**
     * Getteur of the id
     * @return id of the Card
     */
    public int getId() {
        return id;
    }


    /**
     * Getteur of the building
     * @return Building of the Card
     */
    public Building_Interface getBuilding() {
        return building;
    }

}
