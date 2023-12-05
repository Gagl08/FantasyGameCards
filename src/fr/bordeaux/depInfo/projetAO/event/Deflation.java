package fr.bordeaux.depInfo.projetAO.event;

import fr.bordeaux.depInfo.projetAO.Board;
import fr.bordeaux.depInfo.projetAO.PlayerHand;
import fr.bordeaux.depInfo.projetAO.Turn;
import fr.bordeaux.depInfo.projetAO.exception.RessourceException;

public class Deflation implements Event_Interface{
    @Override
    public void startEvent(Turn turn, Board board, PlayerHand player) {
        try {
            board.consumeRessources(turn.stockageRessource);
        } catch (RessourceException e) {
            throw new RuntimeException(e);
        }
    }
}
