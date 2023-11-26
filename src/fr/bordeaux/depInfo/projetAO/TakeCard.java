package fr.bordeaux.depInfo.projetAO;

import fr.bordeaux.depInfo.projetAO.card.*;

import java.util.ArrayList;
import java.util.Random;

public class TakeCard {

    public ArrayList<Building_Interface> loadDraw(int turn){
        ArrayList<Building_Interface> list = new ArrayList<>();

        Building_Interface building = new Building("");
        Building_Interface farm = new Farm(building);
        Building_Interface forest = new Forest(building);
        Building_Interface farmhouse = new Farmhouse(building);
        Building_Interface lumberjack = new Lumberjack(building);
        Building_Interface cow = new Cow(building);
        Building_Interface sheep = new Cow(building);

        list.add(farm);
        list.add(forest);
        list.add(farmhouse);
        list.add(lumberjack);
        list.add(cow);
        list.add(sheep);
        if (turn > 5) {
            Building_Interface sawmill = new Sawmill(building);
            Building_Interface windmill = new Windmill(building);

            list.add(windmill);
            list.add(sawmill);
        }
        return list;
    }

    public Card takeCard(int turn){

        ArrayList<Building_Interface> list = new ArrayList<>(loadDraw(turn));
        Random rand = new Random();
        Building_Interface building = list.get(rand.nextInt(list.size()));

        return new Card(building);
    }
}
