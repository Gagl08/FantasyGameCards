/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import fr.bordeaux.depInfo.projetAO.capacity.Capacity;
import fr.bordeaux.depInfo.projetAO.event.Event_Manager;
import fr.bordeaux.depInfo.projetAO.exception.RessourceException;
import fr.bordeaux.depInfo.projetAO.ressouce.*;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * Class to create an genere a game
 */
public class Turn {
    //Color use for the interface
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    /**
     * Use the first when you create the game
     * Declare and Initialise the principal fonctions an Object to start a game
     */
    public StockageCapacity stockageCapacity ;
    public StockageRessource stockageRessource;
    Event_Manager eventManager;

    /**
     * Constructeur Turn
     */
    public Turn(){
        this.eventManager = new Event_Manager();
        this.stockageRessource = createStockageRessource();
        this.stockageCapacity = createStockageCapacity();
    }

    /**
     * First fonction use to start a gamme
     * Call the fonction for initialise the stockage
     */
    public void lunchGamme (){
        int turn=1;
        int iturn;

        //Create Board of gamme and the hand of the player
        PlayerHand playerHand = new PlayerHand();
        Board board = new Board();

        //Draw the card
        for (int i = 0; i < 5; i++) {
            playerHand.draw(turn);
        }

        iturn = gamme(board,playerHand,turn,this.stockageRessource,this.stockageCapacity);
        System.out.println("You have play " + iturn + "turn's");
    }

    /**
     * General Stockage ressource use by the player
     * @return Stockage ressource
     */
    public StockageRessource createStockageRessource(){
        StockageRessource stockageRessource = new StockageRessource();

        HashMap<String, Ressource> list = new HashMap<>();
        list.put("Food", new Ressource(25));
        list.put("Wood", new Ressource(25));
        list.put("Stone", new Ressource(15));
        list.put("Coal", new Ressource(0));
        list.put("Iron", new Ressource(0));
        list.put("Gold", new Ressource(30));
        list.put("Brique", new Ressource(0));
        list.put("Lumber", new Ressource(0));
        list.put("Weapon", new Ressource(0));
        list.put("Tool", new Ressource(0));
        list.put("Defence", new Ressource(0));

        stockageRessource.addRessource(list);
        return stockageRessource;
    }

    /**
     * General Stockage ressource use by the player
     * @return Stockage ressource
     */
    public StockageCapacity createStockageCapacity(){
        StockageCapacity stockageCapacity = new StockageCapacity();

        HashMap<String, Capacity> list = new HashMap<>();
        list.put("Food_Capacity", new Capacity(50));
        list.put("Wood_Capacity", new Capacity(50));
        list.put("Stone_Capacity", new Capacity(30));
        list.put("Coal_Capacity", new Capacity(10));
        list.put("Iron_Capacity", new Capacity(10));
        list.put("Brique_Capacity", new Capacity(25));
        list.put("Lumber_Capacity", new Capacity(25));
        list.put("Habitant_Capacity", new Capacity(5));
        list.put("Weapon_Capacity", new Capacity(10));
        list.put("Tool_Capacity", new Capacity(10));

        stockageCapacity.addCapacity(list);
        return stockageCapacity;
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
    public int gamme (Board board, PlayerHand playerHand, int turn, StockageRessource stockageRessource, StockageCapacity stockageCapacity){
        Scanner entree=new Scanner(System.in);
        String choixMenu;
        int choix;
        boolean info = false;

        //Start the IHM
        while (true){
            System.out.println("Turn : "+turn + "\n");
            String key_capacity;
            int capa;

            this.eventManager.startEvent(this, board, playerHand);
            //Ressources
            System.out.print("Ressource : ");
            for (String key : stockageRessource.list_ressource.keySet()) {
                key_capacity = key + "_Capacity";
                try {
                    capa = stockageCapacity.list_capacity.get(key_capacity).getQuantity();
                } catch (Exception e){
                    capa = -5;
                }
                System.out.print(key + " : ");
                System.out.print(stockageRessource.list_ressource.get(key).getQuantity());
                if(capa != -5){
                    System.out.print("/"+capa);
                }
                System.out.print(", ");
            }

            //BOARD
            System.out.print("\nBoard : ");
            for (int i = 0; i <board.cardsPlayed.size();i++ ) {
                if (!board.cardsPlayed.get(i).building.isActive()){
                    System.out.print(ANSI_YELLOW);
                }
                System.out.print(board.cardsPlayed.get(i).getBuilding().getName());
                if (info){
                    System.out.print(board.cardsPlayed.get(i).getBuilding().getNbWorkerActual());
                    System.out.print("/"+board.cardsPlayed.get(i).getBuilding().getNbWorkerNeeded());
                }
                System.out.print(", "+ANSI_RESET);
            }

            //HAND
            System.out.println("\nHand : ");
            for(int i = 0; i<playerHand.hand.size();i++){
                System.out.print("\n"+i + " to play " + playerHand.hand.get(i).getBuilding().getName()+"; ");
                System.out.print(ANSI_PURPLE +" --> Cost : "+ ANSI_RESET);
                for (String key : playerHand.hand.get(i).building.getResConstruct().list_ressource.keySet()){
                    System.out.print(ANSI_PURPLE + playerHand.hand.get(i).getBuilding().getResConstruct().list_ressource.get(key).getName() + " : " );
                    if (playerHand.hand.get(i).getBuilding().getResConstruct().list_ressource.get(key).getQuantity()>stockageRessource.list_ressource.get(key).getQuantity()){
                        System.out.print(ANSI_RED);
                    }
                    System.out.print(playerHand.hand.get(i).getBuilding().getResConstruct().list_ressource.get(key).getQuantity()+ ", "+ANSI_RESET);
                }
                System.out.print(ANSI_GREEN +" --> Produce : "+ ANSI_RESET);
                for (String key : playerHand.hand.get(i).building.getResProd().list_ressource.keySet()){
                    System.out.print(ANSI_GREEN + playerHand.hand.get(i).getBuilding().getResProd().list_ressource.get(key).getName() + " : " );
                    System.out.print(playerHand.hand.get(i).getBuilding().getResProd().list_ressource.get(key).getQuantity()+ ", "+ANSI_RESET);
                }
                System.out.print(ANSI_BLUE +" --> Consome : " + ANSI_RESET);
                for (String key : playerHand.hand.get(i).building.getResConso().list_ressource.keySet()){
                    System.out.print(ANSI_BLUE + playerHand.hand.get(i).getBuilding().getResConso().list_ressource.get(key).getName() + " : " );
                    System.out.print(playerHand.hand.get(i).getBuilding().getResConso().list_ressource.get(key).getQuantity()+ ", "+ANSI_RESET);
                }
            }
            System.out.println("\n");

            //Get the instruction of the player
            choixMenu=entree.nextLine();

            //Pass turn
            if(Objects.equals(choixMenu, "d")){
                    return passTurn(board,playerHand,turn,stockageRessource,stockageCapacity);
            //Stop the game
            }else if(Objects.equals(choixMenu,"ff")) {
                return 0;
            }else if(Objects.equals(choixMenu, "i")) {
                info = !info;
            }else if(Objects.equals(choixMenu,"c")){
                System.out.println("d : to pass the turn");
                System.out.println("ff : to give up");
                System.out.println("i : to show the information of the building played");
                System.out.println("c : to show the commands");
            //Play a card
            }else {
                try {
                    choix=Integer.parseInt(choixMenu);
                    if (choix<playerHand.hand.size()) {
                        try {
                            playerHand.constructCard(playerHand.hand.get(choix),stockageRessource);
                            playerHand.gatherCapacity(playerHand.hand.get(choix),stockageCapacity);
                            playerHand.playCard(playerHand.hand.get(choix), board);
                            return passTurn(board,playerHand,turn,stockageRessource,stockageCapacity);
                        }catch (RessourceException e){
                            System.out.println(ANSI_RED + e.getName() + ANSI_RESET);
                        }
                    } else {
                        System.out.println("No Card to play");
                    }
                }catch (Exception e){
                    System.out.println(ANSI_RED + "Unknow command"+ANSI_RESET);
                }
            }
        }
    }

    public int passTurn(Board board, PlayerHand playerHand, int turn, StockageRessource stockageRessource, StockageCapacity stockageCapacity){
        turn++;
        playerHand.draw(turn);
        if(playerHand.hand.size()>7){
            playerHand.deleteOneCard();
        }
        try {
            board.updateBoard(stockageRessource, stockageCapacity);
        }
        catch (RessourceException e){
            return 0;
        }
        return 1+gamme(board,playerHand,turn,stockageRessource,stockageCapacity);
    }
}

