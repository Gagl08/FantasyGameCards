/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package main;

import fr.bordeaux.depInfo.projetAO.Building;
import fr.bordeaux.depInfo.projetAO.Building_Interface;
import fr.bordeaux.depInfo.projetAO.Card;
import fr.bordeaux.depInfo.projetAO.card.Decorateur;
import fr.bordeaux.depInfo.projetAO.card.Farm;

public class TestCard {
    public static void main(String[] args) {
        Building_Interface building = new Building("");
        Building_Interface farm = new Farm(building);
        Card card = new Card(farm);

        System.out.println(card.getBuilding().getName());
        System.out.println(card.getBuilding().getResConso());

    }
}
