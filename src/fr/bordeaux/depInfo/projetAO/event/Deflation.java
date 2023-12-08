/*
 * Approche Objet
 * TD 6                               Fantasy Cards Game
 * Projet universitaire                         2023/2024
 */

package fr.bordeaux.depInfo.projetAO.event;

import fr.bordeaux.depInfo.projetAO.Board;
import fr.bordeaux.depInfo.projetAO.PlayerHand;
import fr.bordeaux.depInfo.projetAO.Turn;
import fr.bordeaux.depInfo.projetAO.exception.RessourceException;

/**
 * Deflation event
 */
public class Deflation implements Event_Interface{
    @Override
    public void startEvent(Turn turn, Board board, PlayerHand player) {
        try {
            board.consumeRessources(turn.stockageRessource);
            int new_quantity = turn.stockageRessource.getList_ressource().get("Gold").getQuantity() / 4;
            turn.stockageRessource.getList_ressource().get("Gold").addQuantity( turn.stockageCapacity, "Gold", new_quantity );
        } catch (RessourceException e) {
            throw new RuntimeException(e);
        }
    }
}
