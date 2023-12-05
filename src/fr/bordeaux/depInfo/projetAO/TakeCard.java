/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import fr.bordeaux.depInfo.projetAO.card.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * Instruction when you Draw a Card
 * able to Draw a random card, create carte
 */
public class TakeCard {

    public ArrayList<Building_Interface> loadDraw(int turn){
        ArrayList<Building_Interface> list = new ArrayList<>();

        //Early Card
        Building_Interface building = new Building("");
        //Building_Interface farm = new Farm(building);
        //Building_Interface forest = new Forest(building);
        //Building_Interface farmhouse = new Farmhouse(building);
        //Building_Interface lumberjack = new Lumberjack(building);
        //Building_Interface cow = new Cow(building);
        //Building_Interface sheep = new Sheep(building);
        //Building_Interface stoneMine = new StoneMine(building);
        Building_Interface goldMine = new GoldMine(building);

        /*list.add(farm);
        list.add(forest);
        list.add(farmhouse);
        list.add(lumberjack);
        list.add(sheep);
        list.add(stoneMine);*/
        list.add(goldMine);

        //Late Card
        /*if (turn > 10) {
            Building_Interface sawmill = new Sawmill(building);
            Building_Interface windmill = new Windmill(building);

            list.add(cow);
            list.add(windmill);
            list.add(sawmill);
        }*/
        return list;
    }

    /**
     * Add a ramdom Card to the hand
     * @param turn actual
     * @return Card to draw
     */
    public Card takeCard(int turn){

        ArrayList<Building_Interface> list = new ArrayList<>(loadDraw(turn));
        Random rand = new Random();
        Building_Interface building = list.get(rand.nextInt(list.size()));

        return new Card(building);
    }
}
