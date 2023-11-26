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

/**
 * Class to create an genere a game
 */
public class Turn {

    /**
     * Use the first when you create the game
     * Declare and Initialise the principal fonctions an Object to start a game
     */
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

    /**
     * General Stockage ressource use by the player
     * @return Stockage ressource
     */
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

    /**
     * Genere the turn by turn
     * IHM and recepteur of the choices of the player
     * @param board Board where we put the card played
     * @param playerHand Hand of Card of the player
     * @param turn actual
     * @param stockageRessource Global Ressources of the player
     * @param stockageCapacity Capacity max of the ressources of the player
     */
    public void gamme (Board board, PlayerHand playerHand, int turn, StockageRessource stockageRessource, StockageCapacity stockageCapacity){
        boolean arret=false;
        Scanner entree=new Scanner(System.in);
        String choixMenu;
        int choix;

        //Start the IHM
        while (!arret){
            System.out.println(turn);

            //Ressources
            System.out.println("Ressource : ");
            for (int i = 0; i < stockageRessource.list_ressource.size();i++ ) {
                System.out.print(stockageRessource.list_ressource.get(i).getName()+ " : ");
                System.out.println(stockageRessource.list_ressource.get(i).getQuantity());
            }

            //BOARD
            System.out.println("Board : ");
            for (int i = 0; i <board.cardsPlayed.size();i++ ) {
                System.out.println(board.cardsPlayed.get(i).getBuilding().getName());
            }

            //HAND
            System.out.println("Hand : ");
            for(int i = 0; i<playerHand.hand.size();i++){
                System.out.println(i + " to play " + playerHand.hand.get(i).getBuilding().getName());
            }

            //Get the instruction of the player

            choixMenu=entree.nextLine();

            //Pass turn
            if(Objects.equals(choixMenu, "d")){
                turn++;
                playerHand.draw(turn);
                gamme(board,playerHand,turn,stockageRessource,stockageCapacity);

            //Stop the game
            }else if(Objects.equals(choixMenu,"ff")) {
                arret = true;

            //Play a card
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
