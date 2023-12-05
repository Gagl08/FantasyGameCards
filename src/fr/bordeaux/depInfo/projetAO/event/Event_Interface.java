package fr.bordeaux.depInfo.projetAO.event;
import fr.bordeaux.depInfo.projetAO.Board;
import fr.bordeaux.depInfo.projetAO.PlayerHand;
import fr.bordeaux.depInfo.projetAO.Turn;

public interface Event_Interface {
    public void startEvent(Turn turn, Board board, PlayerHand player);
}
