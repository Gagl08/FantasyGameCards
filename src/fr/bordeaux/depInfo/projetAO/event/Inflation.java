package fr.bordeaux.depInfo.projetAO.event;

import fr.bordeaux.depInfo.projetAO.Board;
import fr.bordeaux.depInfo.projetAO.PlayerHand;
import fr.bordeaux.depInfo.projetAO.Turn;

public class Inflation implements Event_Interface{
    @Override
    public void startEvent(Turn turn, Board board, PlayerHand player){
        board.gatherRessources(turn.stockageCapacity,turn.stockageRessource);
        int new_quantity = turn.stockageRessource.getList_ressource().get("Gold").getQuantity() / 4;
        turn.stockageRessource.getList_ressource().get("Gold").lessQuantity( new_quantity );
    }
}
