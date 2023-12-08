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
        Building_Interface farm = new Farm(building);
        Building_Interface forest = new Forest(building);
        Building_Interface farmhouse = new Farmhouse(building);
        Building_Interface lumberjack = new Lumberjack(building);
        Building_Interface cow = new Cow(building);
        Building_Interface sheep = new Sheep(building);
        Building_Interface goldMine = new GoldMine(building);
        Building_Interface hovel = new Hovel(building);

        list.add(farm);
        list.add(forest);
        list.add(farmhouse);
        list.add(lumberjack);
        list.add(sheep);
        list.add(goldMine);
        list.add(hovel);

        if (turn>5){
            Building_Interface stoneMine = new StoneMine(building);
            Building_Interface shop = new Shop(building);

            list.add(shop);
            list.add(stoneMine);
        }
        //Late Card
        if (turn > 10) {
            Building_Interface sawmill = new Sawmill(building);
            Building_Interface windmill = new Windmill(building);
            Building_Interface stonecutter = new StoneCutter(building);
            Building_Interface house = new House(building);
            Building_Interface tavern = new Tavern(building);

            list.add(tavern);
            list.add(house);
            list.add(stonecutter);
            list.add(cow);
            list.add(windmill);
            list.add(sawmill);
        }

        if (turn>20){
            Building_Interface manor = new Manor(building);

            list.add(manor);
        }
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
