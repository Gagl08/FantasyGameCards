/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import fr.bordeaux.depInfo.projetAO.ressouce.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Turn {
    public void lunchGamme (){
        int turn=1;

        PlayerHand playerHand = new PlayerHand();
        Board board = new Board();

        StockageCapacity stockageCapacity = new StockageCapacity();
        StockageRessource stockageRessource;

        for (int i = 0; i < 5; i++) {
            playerHand.draw(turn);
        }
        stockageRessource=createStockageRessource();
        gamme(board,playerHand,turn,stockageRessource,stockageCapacity);
    }

    public StockageRessource createStockageRessource(){
        StockageRessource stockageRessource = new StockageRessource();

        ArrayList<Ressource> arrayList = new ArrayList<>();
        Food food = new Food(20);
        Wood wood = new Wood(15);
        Stone stone = new Stone(5);
        Coal coal = new Coal(0);
        Iron iron = new Iron(0);
        Gold gold = new Gold(25);
        Brique brique = new Brique(0);
        Lumber lumber = new Lumber(0);
        Habitant habitant = new Habitant(5);
        Weapon weapon = new Weapon(0);
        Tool tool = new Tool(0);
        Defence defence = new Defence(0);

        arrayList.add(food);
        arrayList.add(wood);
        arrayList.add(stone);
        arrayList.add(coal);
        arrayList.add(iron);
        arrayList.add(gold);
        arrayList.add(brique);
        arrayList.add(lumber);
        arrayList.add(habitant);
        arrayList.add(weapon);
        arrayList.add(tool);
        arrayList.add(defence);

        stockageRessource.addRessource(arrayList);
        return stockageRessource;
    }

    public void gamme (Board board, PlayerHand playerHand, int turn, StockageRessource stockageRessource, StockageCapacity stockageCapacity){
        boolean arret=false;
        Scanner entree=new Scanner(System.in);
        String choixMenu;
        int choix;

        while (!arret){
            System.out.println(turn);
            System.out.println("Ressource : ");
            for (int i = 0; i < stockageRessource.list_ressource.size();i++ ) {
                System.out.print(stockageRessource.list_ressource.get(i).getName()+ " : ");
                System.out.println(stockageRessource.list_ressource.get(i).getQuantity());
            }
            System.out.println("Board : ");
            for (int i = 0; i <board.cardsPlayed.size();i++ ) {
                System.out.println(board.cardsPlayed.get(i).getBuilding().getName());
            }

            System.out.println("Hand : ");
            for(int i = 0; i<playerHand.hand.size();i++){
                System.out.println(i + " to play " + playerHand.hand.get(i).getBuilding().getName());
            }

            choixMenu=entree.nextLine();
            if(Objects.equals(choixMenu, "d")){
                turn++;
                playerHand.draw(turn);
                gamme(board,playerHand,turn,stockageRessource,stockageCapacity);
            }else if(Objects.equals(choixMenu,"ff")) {
                arret = true;
            }else {
                choix=Integer.parseInt(choixMenu);
                if (choix<playerHand.hand.size()) {
                    if(playerHand.canPlay(playerHand.hand.get(choix),stockageRessource)){
                        playerHand.playCard(playerHand.hand.get(choix), board);
                        playerHand.constructCard(playerHand.hand.get(choix),stockageRessource);
                    }else {
                        System.out.println("To expensive ! ");
                    }
                } else {
                    System.out.println("No Card to play");
                }
            }

        }
    }
}
