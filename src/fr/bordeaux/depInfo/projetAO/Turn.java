/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO;

import java.util.Objects;
import java.util.Scanner;

public class Turn {
    public void lunchGamme (){
        int turn=1;

        PlayerHand playerHand = new PlayerHand();
        Board board = new Board();

        StockageCapacity stockageCapacity = new StockageCapacity();
        StockageRessource stockageRessource = new StockageRessource();

        for (int i = 0; i < 5; i++) {
            playerHand.draw(turn);
        }
        gamme(board,playerHand,turn);
    }

    public void gamme (Board board, PlayerHand playerHand, int turn){
        boolean arret=false;
        Scanner entree=new Scanner(System.in);
        String choixMenu;
        int choix;

        while (!arret){
            System.out.println(turn);
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
                gamme(board,playerHand,turn);
            }else if(Objects.equals(choixMenu,"ff")) {
                arret = true;
            }else {
                choix=Integer.parseInt(choixMenu);
                if (choix<playerHand.hand.size()) {
                    playerHand.playCard(playerHand.hand.get(choix), board);
                } else {
                    System.out.println("No Card to play");
                }
            }

        }
    }
}
