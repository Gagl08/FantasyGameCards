package fr.bordeaux.depInfo.projetAO.event;

import fr.bordeaux.depInfo.projetAO.Board;
import fr.bordeaux.depInfo.projetAO.PlayerHand;
import fr.bordeaux.depInfo.projetAO.Turn;


import java.util.Random;

public class WitchHunt implements Event_Interface{
    @Override
    public void startEvent(Turn turn, Board board, PlayerHand player){
        int cpt = 0;
        Random random = new Random();
        int nb_witches = random.nextInt(0,25);
        if (nb_witches != 0){
            for (int i = 0; i < board.cardsPlayed.size(); i++){
                int nb_habitants = board.cardsPlayed.get(i).getBuilding().getNbHabAllowed();
                board.cardsPlayed.get(i).getBuilding().setNbHabAllowed( nb_habitants - (nb_habitants * (1/nb_witches)) );
                cpt += nb_habitants - (nb_habitants * (1/nb_witches));
            }
            System.out.println(cpt + " filthy witches have been burned !");
        }
        else System.out.println("No witches have been found, but be careful...");
    }
}
