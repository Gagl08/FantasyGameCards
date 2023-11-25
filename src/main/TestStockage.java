package main;

import fr.bordeaux.depInfo.projetAO.StockageCapacity;
import fr.bordeaux.depInfo.projetAO.StockageRessource;
import fr.bordeaux.depInfo.projetAO.capacity.Capacity;
import fr.bordeaux.depInfo.projetAO.capacity.Food_capacity;
import fr.bordeaux.depInfo.projetAO.capacity.Gold_capacity;
import fr.bordeaux.depInfo.projetAO.ressouce.Food;
import fr.bordeaux.depInfo.projetAO.ressouce.Gold;
import fr.bordeaux.depInfo.projetAO.ressouce.Ressource;
import fr.bordeaux.depInfo.projetAO.ressouce.Wood;

import java.util.ArrayList;

public class TestStockage {
    public static void main(String[] args) {

        StockageRessource stocktest;
        StockageCapacity stocktest2;

        Gold gold = new Gold(5);
        Food food = new Food(20);

        Gold_capacity gold_capacity = new Gold_capacity(10);
        Food_capacity food_capacity = new Food_capacity(50);

        ArrayList<Ressource> test = new ArrayList<>();
        test.add(gold);
        test.add(food);

        ArrayList<Capacity> test2 = new ArrayList<>();
        test2.add(gold_capacity);
        test2.add(food_capacity);

        stocktest = new StockageRessource(test);
        stocktest2 = new StockageCapacity(test2);


        System.out.println(stocktest.getList_ressource());
        System.out.println(stocktest2.getList_capacity());

        Wood wood = new Wood(7);

        stocktest.addRessource(wood);

        System.out.println(stocktest.getList_ressource());


    }
}
