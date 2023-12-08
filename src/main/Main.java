/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package main;

import fr.bordeaux.depInfo.projetAO.Turn;

public class Main {
    public static void main(String[] args) {
        System.out.println("d : to pass the turn");
        System.out.println("ff : to give up");
        System.out.println("i : to show the information of the building played");
        System.out.println("c : to show the commands");

        Turn turn = new Turn();
        turn.lunchGamme();
    }
}
