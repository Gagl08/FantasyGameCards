/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO.event;

import fr.bordeaux.depInfo.projetAO.Board;
import fr.bordeaux.depInfo.projetAO.PlayerHand;
import fr.bordeaux.depInfo.projetAO.Turn;

import java.util.Random;

/**
 * Event Inflation
 */
public class Inflation implements Event_Interface{
    @Override
    public void startEvent(Turn turn, Board board, PlayerHand player){
        Random random = new Random();
        int decrease_percentage = random.nextInt(1,25);
        board.gatherRessources(turn.stockageCapacity,turn.stockageRessource);
        int new_quantity = (turn.stockageRessource.getList_ressource().get("Gold").getQuantity() * decrease_percentage) / 100;
        turn.stockageRessource.getList_ressource().get("Gold").lessQuantity( new_quantity );
    }
}